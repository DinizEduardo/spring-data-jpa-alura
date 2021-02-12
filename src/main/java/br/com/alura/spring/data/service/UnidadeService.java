package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.Unidade;
import br.com.alura.spring.data.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class UnidadeService {

    private boolean system = true;

    private UnidadeRepository repository;

    public UnidadeService(UnidadeRepository repository) {
        this.repository = repository;
    }

    public void inicial(Scanner scanner) {

        while(system) {
            System.out.println("Qual opcao de unidade voce deseja: ");
            System.out.println("0 - sair");
            System.out.println("1 - salvar");
            System.out.println("2 - visualizar");
            System.out.println("3 - editar");
            System.out.println("4 - excluir");

            int option = scanner.nextInt();

            switch (option){
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    visualizar();
                    break;
                case 3:
                    editar(scanner);
                    break;
                case 4:
                    excluir(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void excluir(Scanner scanner) {

        System.out.println("Qual id voce deseja excluir");
        int id = scanner.nextInt();

        repository.deleteById(id);

        System.out.println("Unidade excluida!");

    }

    private void editar(Scanner scanner) {
        System.out.println("Digite o id que deseja alterar: ");
        int id = scanner.nextInt();

        System.out.println("Nome da unidade: ");
        String descricao = scanner.next();

        System.out.println("Endereco da unidade");
        String endereco = scanner.next();

        Unidade unidade = new Unidade();
        unidade.setId(id);
        unidade.setEndereco(endereco);
        unidade.setDescricao(descricao);
        repository.save(unidade);

        System.out.println("Unidade alterada com sucesso");
    }

    private void visualizar() {
        Iterable<Unidade> unidades = repository.findAll();
        unidades.forEach(System.out::println);
    }


    private void salvar(Scanner scanner) {

        System.out.println("Nome da unidade: ");
        String descricao = scanner.next();

        System.out.println("Endereco da unidade");
        String endereco = scanner.next();

        Unidade unidade = new Unidade();

        unidade.setEndereco(endereco);
        unidade.setDescricao(descricao);
        repository.save(unidade);

        System.out.println("Unidade criada com sucesso");

    }

}
