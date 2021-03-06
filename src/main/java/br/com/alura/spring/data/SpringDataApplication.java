package br.com.alura.spring.data;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CrudCargoService cargoService;
	private final FuncionarioService funcionarioService;
	private final UnidadeService unidadeService;
	private final RelatorioService relatorioService;
	private final RelatorioFuncionarioDinamico relatorioFuncionarioDinamico;

	private boolean system = true;

	public SpringDataApplication(CrudCargoService cargoService, FuncionarioService funcionarioService, UnidadeService unidadeService, RelatorioService relatorioService, RelatorioFuncionarioDinamico relatorioFuncionarioDinamico) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeService = unidadeService;
		this.relatorioService = relatorioService;
		this.relatorioFuncionarioDinamico = relatorioFuncionarioDinamico;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while(system){
			System.out.println("Qual opcao voce deseja ir");
			System.out.println("0 - sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionario");
			System.out.println("3 - Unidade");
			System.out.println("4 - Relatorios");
			System.out.println("5 - Relatorios dinamicos");

			int option = scanner.nextInt();

			if(option == 1) {
				cargoService.inicial(scanner);
			}else if(option == 2){
				funcionarioService.inicial(scanner);
			}else if(option == 3){
				unidadeService.inicial(scanner);
			}else if(option == 4) {
				relatorioService.inicial(scanner);
			}else if(option == 5) {
				relatorioFuncionarioDinamico.inicial(scanner);
			}else {
				system = false;
			}
		}

	}
}
