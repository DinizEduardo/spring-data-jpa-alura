package br.com.alura.spring.data.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class FuncionarioService {


    public void inicial(Scanner scanner) {
        System.out.println("O que deseja fazer com o funcionario: ");
        System.out.println("0 - sair");
        System.out.println("1 - Novo");
        System.out.println("2 - Visualizar todos");
        System.out.println("3 - Alterar");
        System.out.println("4 - excluir");
    }
}
