package com.daviteixeira.lista9.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daviteixeira.lista9.orm.Aluno;
import com.daviteixeira.lista9.orm.AlunoTurma;
import com.daviteixeira.lista9.repository.AlunoRepository;

@Service
public class CrudAlunoService {
    
    private AlunoRepository alunoRepository;

    public CrudAlunoService(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    @Transactional
    public void menu(Scanner scanner){
        Boolean isTrue = true;

        while(isTrue){
            System.out.println("\nQual ação você deseja executar?");
            System.out.println("1 - Cadastrar um novo Aluno");
            System.out.println("2 - Atualizar informações de um Aluno");
            System.out.println("3 - Deletar um Aluno");
            System.out.println("4 - Visualizar todos os alunos cadastrados");
            System.out.println("5 - Visualizar um Aluno");
            System.out.println("0 - Voltar ao menu Principal");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();

            switch(opcao){
                case 1:
                    this.cadastrarAluno(scanner);
                    break;
                case 2:
                    this.atualizarAluno(scanner);
                    break;
                case 3:
                    this.deletarAluno(scanner);
                    break;
                case 4:
                    this.visualizarTodos();
                    break;
                case 5:
                    this.visualizarAluno(scanner);
                    break;
                default:
                    isTrue = false;
                    break;
            }
        }
        System.out.println();
    }

    private void cadastrarAluno(Scanner scanner){
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.next();

        System.out.print("Digite o cpf do aluno: ");
        String cpf = scanner.next();


        System.out.print("Digite a matricula do aluno: ");
        int matricula = scanner.nextInt();

        System.out.print("Digite o email do aluno: ");
        String email = scanner.next();

        System.out.print("Digite o telefone do aluno: ");
        String telefone = scanner.next();


        Aluno novoAluno = new Aluno(cpf, matricula, nome, email, telefone);
        this.alunoRepository.save(novoAluno);
        System.out.println("\nO novo Aluno foi salvo no Banco!\n");
    }

    private void atualizarAluno(Scanner scanner){
        
        System.out.print("Digite o ID do aluno a ser atualizado: ");
        Integer id = scanner.nextInt();

        Optional<Aluno> optional = this.alunoRepository.findById(id);

        if(optional.isPresent()){
            System.out.print("Digite o nome do aluno: ");
            String nome = scanner.next();

            System.out.print("Digite o cpf do aluno: ");
            String cpf = scanner.next();


            System.out.print("Digite a matricula do aluno: ");
            int matricula = scanner.nextInt();

            System.out.print("Digite o email do aluno: ");
            String email = scanner.next();

            System.out.print("Digite o telefone do aluno: ");
            String telefone = scanner.next();

            Aluno alunoEscolhido = optional.get();
            alunoEscolhido.setNome(nome);
            alunoEscolhido.setCpf(cpf);
            alunoEscolhido.setMatricula(matricula);
            alunoEscolhido.setEmail(email);
            alunoEscolhido.setTelefone(telefone);

            alunoRepository.save(alunoEscolhido);

            System.out.println("O Aluno escolhido foi atualizado com sucesso!\n");
        }else{
            System.out.println("O ID do Aluno informado: " + id + " É INVÁLIDO\n");
        }
    }

    private void deletarAluno(Scanner scanner){
        System.out.print("\nDigite o ID do Aluno a ser deletado: ");
        int id = scanner.nextInt();
        this.alunoRepository.deleteById(id);
        System.out.println("\nAluno Deletado!\n");
    }

    private void visualizarTodos(){
        Iterable<Aluno> todosOsAlunos = this.alunoRepository.findAll();
        
        for(Aluno aluno: todosOsAlunos){
            System.out.println();
            System.out.println(aluno);
        }
        System.out.println();
    }

    @Transactional
    public void visualizarAluno(Scanner scanner){
        System.out.print("Id do Aluno: ");
        int id = scanner.nextInt();

        Optional<Aluno> optional = alunoRepository.findById(id);

        if(optional.isPresent()){
            Aluno aluno = optional.get();

            System.out.println("Aluno: {");
            System.out.println("ID: " + aluno.getId());
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("CPF: " + aluno.getCpf());
            System.out.println("Matricula: " + aluno.getMatricula());
            System.out.println("Email: " + aluno.getEmail());
            System.out.println("Telefone: " + aluno.getTelefone());
            System.out.println("Turmas: [");

            for(AlunoTurma alunoTurma : aluno.getAlunoTurma()){
                System.out.println("\tId: " + alunoTurma.getId());
                System.out.println("\tNota Final: " + alunoTurma.getNota_final());
                System.out.println("\tQtd Faltas: " + alunoTurma.getQtd_faltas());
                System.out.println();
            }
            System.out.println("]\n}");
        }
    }
}
