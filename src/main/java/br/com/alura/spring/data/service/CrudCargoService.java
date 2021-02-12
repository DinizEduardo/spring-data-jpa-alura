package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudCargoService {

    private final CargoRepository repository;

    private boolean system = true;

    public CrudCargoService(CargoRepository repository) {
        this.repository = repository;
    }

    public void inicial(Scanner scanner) {
        while(system) {
            System.out.println("Qual opcao voce deseja: ");
            System.out.println("0 - sair");
            System.out.println("1 - salvar");
            System.out.println("2 - visualizar");
            System.out.println("3 - editar");

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
                default:
                    system = false;
                    break;
            }
        }
    }

    private void editar(Scanner scanner) {
        System.out.println("Qual id voce deseja editar: ");
        int id = scanner.nextInt();

        System.out.println("Qual a nova descricao ");
        String descricao = scanner.next();

        Cargo cargo = new Cargo();
        cargo.setId(id);
        cargo.setDescricao(descricao);

        repository.save(cargo);

        System.out.println("Alterado!");
    }

    private void visualizar(Scanner scanner) {
        Iterable<Cargo> cargos = repository.findAll();

        cargos.forEach(System.out::println);
    }

    private void salvar(Scanner scanner) {
        System.out.println("Qual a descricao que voce deseja salvar: ");
        String descricao = scanner.next();

        Cargo cargo = new Cargo();

        cargo.setDescricao(descricao);

        repository.save(cargo);
    }
}
