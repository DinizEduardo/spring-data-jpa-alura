package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatorioService {
    private boolean system = true;

    private final FuncionarioRepository repository;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public RelatorioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public void inicial(Scanner scanner) {
        while(system) {
            System.out.println("Qual opcao de funcionario voce deseja: ");
            System.out.println("0 - sair");
            System.out.println("1 - Buscar por nome");
            System.out.println("2 - Busca por nome, data contratacao e salario maior");

            int option = scanner.nextInt();

            switch (option){
                case 1:
                    buscaFuncionarioNome(scanner);
                    break;
                case 2:
                    buscaFuncionarioNomeSalarioContratacao(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void buscaFuncionarioNomeSalarioContratacao(Scanner scanner) {

        System.out.println("Nome ");
        String nome = scanner.next();

        System.out.println("Data ");
        String dataString = scanner.next();

        LocalDate data = LocalDate.parse(dataString, formatter);


        System.out.println("Salario ");
        float salario = scanner.nextFloat();

        List<Funcionario> list = repository.findNomeDataContratacaoSalarioMaior(nome, salario, data);

        list.forEach(System.out::println);
    }

    private void buscaFuncionarioNome(Scanner scanner) {

        System.out.println("Qual nome deseja procurar");
        String nome = scanner.next();

        List<Funcionario> list = repository.findByNome(nome);

        list.forEach(System.out::println);

    }
}
