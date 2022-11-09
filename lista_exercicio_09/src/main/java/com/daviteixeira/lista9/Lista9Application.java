package com.daviteixeira.lista9;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.daviteixeira.lista9.service.CrudAlunoService;
import com.daviteixeira.lista9.service.CrudAlunoTurmaService;
import com.daviteixeira.lista9.service.CrudTurmaService;

@SpringBootApplication
public class Lista9Application implements CommandLineRunner {

	private CrudAlunoService alunoService;
	private CrudAlunoTurmaService alunoTurmaService;
	private CrudTurmaService turmaService;

	public Lista9Application(CrudAlunoService alunoService, CrudAlunoTurmaService alunoTurmaService){
		this.alunoService = alunoService;
		this.alunoTurmaService = alunoTurmaService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Lista9Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Boolean isTrue = true;
		Scanner scanner = new Scanner(System.in);

		while(isTrue){
			System.out.println("\n***** Bem-vindo(a) ao menu principal *****\n");
			System.out.println("Qual entidade você deseja interagir? ");
			System.out.println("1 - Aluno");
			System.out.println("2 - AlunoTurma");
			System.out.println("3 - Turma");
			System.out.println("0 - Sair");
			System.out.print("Opção: ");

			int opcao = scanner.nextInt();

			switch(opcao){
				case 1:
					this.alunoService.menu(scanner);
					break;
				case 2:
					this.alunoTurmaService.menu(scanner);
					break;
				case 3:
					this.turmaService.menu(scanner);
				default:
					isTrue = false;
					break;
			}
		}
		System.out.println("\n***** Aplicação finalizada. *****\n");
	}
}
