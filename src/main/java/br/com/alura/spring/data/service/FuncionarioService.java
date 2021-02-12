package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Scanner;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    private boolean system = true;

    public void inicial(Scanner scanner) {
        while(system) {
            System.out.println("Qual opcao de funcionario voce deseja: ");
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
                default:
                    system = false;
                    break;
            }
        }
    }


    private void salvar(Scanner scanner) {

        System.out.println("Digite o nome do funcionario: ");
        String nome = scanner.next();

        System.out.println("Digite o cpf do funcionario: ");
        String cpf = scanner.next();

        System.out.println("Digite o salario do funcionario: ");
        float salario = scanner.nextFloat();

        System.out.println("Id do cargo do funcionario: ");
        int idCargo = scanner.nextInt();

        LocalDate hoje = LocalDate.now();

        Cargo cargo = new Cargo();

        cargo.setId(idCargo);

        Funcionario funcionario = new Funcionario();
        funcionario.setCargo(cargo);
        funcionario.setCpf(cpf);
        funcionario.setDataContratacao(hoje);
        funcionario.setSalario(salario);
        funcionario.setNome(nome);

        repository.save(funcionario);

    }
}
