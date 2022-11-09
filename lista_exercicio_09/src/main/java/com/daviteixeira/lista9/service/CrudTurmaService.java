package com.daviteixeira.lista9.service;

import java.util.Optional;
import java.util.Scanner;

import javax.transaction.Transactional;

import com.daviteixeira.lista9.orm.Turma;
import com.daviteixeira.lista9.repository.TurmaRepository;

public class CrudTurmaService {
    
    private TurmaRepository turmaRepository;

    public CrudTurmaService(TurmaRepository turmaRepository){
        this.turmaRepository = turmaRepository;
    }

    public void menu(Scanner scanner){
        Boolean isTrue = true;

        while(isTrue){
            System.out.println("\nQual ação você quer executar?");
            System.out.println("1 - Cadastrar periodo e disciplina de um aluno");
            System.out.println("2 - Atualizar periodo e disciplina de um aluno");
            System.out.println("3 - Vizualizar periodos e disciplinas de todos os alunos");
            System.out.println("4 - Deletar periodo e disciplina de um aluno");
            System.out.println("5 - Visualizar periodo e disciplina de um aluno");
            System.out.println("0 - Voltar ao menu Principal");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();

            switch(opcao){
                case 1:
                    this.cadastrarPeriodoEDisciplina(scanner);
                    break;
                case 2:
                    this.atualizarPeriodoEDisciplina(scanner);
                    break;
                case 3:
                    this.visualizarTodosOsPeriodosEDisciplinas();
                    break;
                case 4:
                    this.deletarPeriodoEDisciplina(scanner);
                    break;
                case 5:
                    this.visualizarPeriodoEDisciplinaDeUmAluno(scanner);
                default:
                    isTrue = false;
                    break;
            }
        }
        System.out.println();
    }

    private void cadastrarPeriodoEDisciplina(Scanner scanner){
        System.out.print("Digite o nome do periodo: ");
        String periodo = scanner.next();

        System.out.print("Digite o nome da disciplina: ");
        String disciplina = scanner.next();

        System.out.print("Digite o ID da turma: ");
        int turmaId = scanner.nextInt();

        Optional<Turma> optional = turmaRepository.findById(turmaId);

        if(optional.isPresent()){
            Turma turma = optional.get();
            this.turmaRepository.save(turma);
            System.out.println("\nA nova Turma foi salva no Banco!\n");
        }else{
            System.out.println("Aluno ID " + turmaId + " inválido!");
        }
    }

    private void atualizarPeriodoEDisciplina(Scanner scanner){

    }

    public void visualizarTodosOsPeriodosEDisciplinas(){

    }

    public void deletarPeriodoEDisciplina(Scanner scanner){

    }

    @Transactional
    public void visualizarPeriodoEDisciplinaDeUmAluno(Scanner scanner){

    }
}
