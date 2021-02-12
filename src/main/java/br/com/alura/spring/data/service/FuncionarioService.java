package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
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
                case 2:
                    visualizar(scanner);
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
        System.out.println("Digite o id que deseja excluir: ");
        int id = scanner.nextInt();

        Optional<Funcionario> funcionario = repository.findById(id);

        if(funcionario.isPresent()) {
            repository.deleteById(id);
        }else {
            System.out.println("Id não existe");
        }

    }

    private void editar(Scanner scanner) {
        System.out.println("Digite o id de funcionario que deseja alterar: ");
        int id = scanner.nextInt();

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
        funcionario.setId(id);
        funcionario.setCargo(cargo);
        funcionario.setCpf(cpf);
        funcionario.setDataContratacao(hoje);
        funcionario.setSalario(salario);
        funcionario.setNome(nome);

        repository.save(funcionario);

    }

    private void visualizar(Scanner scanner) {
        Iterable<Funcionario> funcionarios = repository.findAll();
        funcionarios.forEach(System.out::println);
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
