package com.daviteixeira.lista9.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.daviteixeira.lista9.orm.Aluno;
import com.daviteixeira.lista9.orm.AlunoTurma;
import com.daviteixeira.lista9.repository.AlunoRepository;
import com.daviteixeira.lista9.repository.AlunoTurmaRepository;

@Service
public class CrudAlunoTurmaService {
    
    private AlunoTurmaRepository alunoTurmaRepository;
    private AlunoRepository alunoRepository;

    public CrudAlunoTurmaService(AlunoTurmaRepository alunoTurmaRepository, AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
        this.alunoTurmaRepository = alunoTurmaRepository;
    }

    public void menu(Scanner scanner){
        Boolean isTrue = true;

        while(isTrue){
            System.out.println("\nQual ação você quer executar?");
            System.out.println("1 - Cadastrar nota final e quantidade de faltas de um aluno");
            System.out.println("2 - Atualizar nota final e quantidade de faltas de um aluno");
            System.out.println("3 - Vizualizar notas e quantidade de faltas de todos os alunos");
            System.out.println("4 - Deletar nota final e quantidade de faltas de um aluno");
            System.out.println("0 - Voltar ao menu Principal");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();

            switch(opcao){
                case 1:
                    this.cadastrarNotaAndFaltas(scanner);
                    break;
                case 2:
                    this.atualizarNotaAndFaltas(scanner);
                    break;
                case 3:
                    this.visualizarTodasNotasAndFalta();
                    break;
                case 4:
                    this.deletarNotaAndFaltas(scanner);
                    break;
                default:
                    isTrue = false;
                    break;
            }
        }
        System.out.println();
    }

    private void cadastrarNotaAndFaltas(Scanner scanner){
        System.out.print("\nDigite o valor da nota final do aluno: ");
        float nota_final = scanner.nextFloat();

        System.out.print("Digite a quantidade de faltas do aluno: ");
        int qtd_faltas = scanner.nextInt();

        System.out.print("Digite o ID do aluno: ");
        int alunoId = scanner.nextInt();

        Optional<Aluno> optional = alunoRepository.findById(alunoId);
        
        if(optional.isPresent()){
            Aluno aluno = optional.get();
            AlunoTurma alunoTurma = new AlunoTurma(nota_final, qtd_faltas, aluno);
            alunoTurmaRepository.save(alunoTurma);
            System.out.println("Salvo!\n");
        }else{
            System.out.println("Aluno ID " + alunoId + " inválido!");
        }
    }

    public void atualizarNotaAndFaltas(Scanner scanner){
        System.out.print("Digite o ID da ficha(aluno_turma) a ser atualizada: ");
        int id = scanner.nextInt();

        Optional<AlunoTurma> optionalAlunoTurma = this.alunoTurmaRepository.findById(id);

        if(optionalAlunoTurma.isPresent()){
            AlunoTurma alunoTurma = optionalAlunoTurma.get();

            System.out.print("\nDigite o valor da nota final do aluno: ");
            float nota_final = scanner.nextFloat();

            System.out.print("Digite a quantidade de faltas do aluno: ");
            int qtd_faltas = scanner.nextInt();

            System.out.print("Digite o ID do aluno: ");
            int alunoId = scanner.nextInt();

            Optional<Aluno> optionalAluno = this.alunoRepository.findById(alunoId);

            if(optionalAluno.isPresent()){
                Aluno aluno = optionalAluno.get();

                alunoTurma.setNota_final(nota_final);
                alunoTurma.setQtd_faltas(qtd_faltas);
                alunoTurma.setAluno(aluno);

                alunoTurmaRepository.save(alunoTurma);
                System.out.println("Atualizado!\n");
            }else{
                System.out.println("Aluno ID " + alunoId + " inválido!");
            }
        }
    }

    public void visualizarTodasNotasAndFalta(){
        Iterable<AlunoTurma> alunosTurmas = this.alunoTurmaRepository.findAll();
        for(AlunoTurma alunoTurma : alunosTurmas){
            System.out.println();
            System.out.println(alunoTurma);
        }
        System.out.println();
    }

    public void deletarNotaAndFaltas(Scanner scanner){
        System.out.print("Digite o ID da ficha do aluno a ser deletada: ");
        int id = scanner.nextInt();
        this.alunoTurmaRepository.deleteById(id);
        System.out.println("Ficha deletada!\n");
    }
}
