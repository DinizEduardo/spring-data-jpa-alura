package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class RelatorioService {
    private boolean system = true;

    private final FuncionarioRepository repository;

    public RelatorioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public void inicial(Scanner scanner) {
        while(system) {
            System.out.println("Qual opcao de funcionario voce deseja: ");
            System.out.println("0 - sair");
            System.out.println("1 - Buscar por nome");

            int option = scanner.nextInt();

            switch (option){
                case 1:
                    buscaFuncionarioNome(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void buscaFuncionarioNome(Scanner scanner) {

        System.out.println("Qual nome deseja procurar");
        String nome = scanner.next();

        List<Funcionario> list = repository.findByNome(nome);

        list.forEach(System.out::println);

    }
}
