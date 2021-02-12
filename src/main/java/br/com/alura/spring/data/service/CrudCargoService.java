package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudCargoService {

    private final CargoRepository repository;

    public CrudCargoService(CargoRepository repository) {
        this.repository = repository;
    }

    public void inicial(Scanner scanner) {
        salvar(scanner);
    }

    private void salvar(Scanner scanner) {
        System.out.println("Qual a descricao que voce deseja salvar: ");
        String descricao = scanner.next();

        Cargo cargo = new Cargo();

        cargo.setDescricao(descricao);

        repository.save(cargo);
    }
}
