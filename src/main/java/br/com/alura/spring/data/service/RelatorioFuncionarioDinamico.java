package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.specification.SpecificationFuncionario;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatorioFuncionarioDinamico {
    private final FuncionarioRepository funcionarioRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner){

        System.out.println("Digite o nome ");
        String nome = scanner.next();

        if(nome.equalsIgnoreCase("NULL")) {
            nome = null;
        }

        System.out.println("Digite o cpf ");
        String cpf = scanner.next();

        if(cpf.equalsIgnoreCase("NULL")) {
            cpf = null;
        }

        System.out.println("Digite o salario");
        float salario = scanner.nextFloat();

        if(salario < 0) {
            salario = 0;
        }


        System.out.println("Digite o data de contratacao ");
        String dataString = scanner.next();

        LocalDate dataContratacao;

        if(dataString.equalsIgnoreCase("NULL")) {
            dataContratacao = null;
        }else {
            dataContratacao = LocalDate.parse(dataString, formatter);
        }


        List<Funcionario> funcionarios = funcionarioRepository
                .findAll(Specification
                        .where(
                                SpecificationFuncionario.nome(nome)
                                .or(SpecificationFuncionario.cpf(cpf))
                                .or(SpecificationFuncionario.salario(salario))
                                .or(SpecificationFuncionario.dataContratacao(dataContratacao))
                        )
                );

        funcionarios.forEach(System.out::println);

    }
}
