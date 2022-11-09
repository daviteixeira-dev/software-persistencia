package com.lista;

import java.sql.Connection;
import java.util.Scanner;

import com.lista.dao.AlunoDAO;
import com.lista.dao.AlunoJDBCDAO;
import com.lista.entidade.Aluno;
import com.lista.util.ConnectionFactory;

public class App {

    /**
     * @param args
     * @throws Exception
     */
    public static void main( String[] args ) throws Exception{

        Scanner ler = new Scanner(System.in);
        Connection connection = ConnectionFactory.getConnection();
        final AlunoDAO alunos = new AlunoJDBCDAO();
        
        System.out.println("=====Aplicação de dados sobre alunos!=====");

        while (true) {
            String cpf = "";
            String nome = "";
            String email = ""; 
            String telefone = "";
            String matricula = "";

            System.out.println("");
            System.out.println("=====Bem-vindo ao menu principal=====");
            System.out.println("Qual opção deseja realizar?");
            
            System.out.println("1 - Inserir um novo aluno");
            System.out.println("2 - Deletar um aluno");
            System.out.println("3 - Alterar informação de um aluno");
            
            System.out.println("4 - Exibir informação aluno");
    
            System.out.println("5 - Finalizar a aplicação");
            System.out.print("Informe: ");

            // Aluno alu;
            String option = ler.nextLine();


            if (option.equals("1")) { //Inserir um novo aluno
                System.out.print("Digite o cpf: ");
                cpf = ler.next();
                System.out.print("Digite o nome: ");
                nome = ler.next();
                System.out.print("Digite o email: ");
                email = ler.next();
                System.out.print("Digite o telefone: ");
                telefone = ler.next();
                System.out.print("Digite a matricula: ");
                matricula = ler.next();

                alunos.inserirAluno(new Aluno(matricula, cpf, nome, email, telefone));

            } else if (option.equals("2")) { //Deletar um aluno

                alunos.deletarAluno(ler.nextInt());

            } else if(option.equals("3")){ //Alterar informação de um aluno
                System.out.print("Digite o id: ");
                int id = ler.nextInt();
                System.out.print("Digite o cpf: ");
                cpf = ler.next();
                System.out.print("Digite o nome: ");
                nome = ler.next();
                System.out.print("Digite o email: ");
                email = ler.next();
                System.out.print("Digite o telefone: ");
                telefone = ler.next();
                System.out.print("Digite a matricula: ");
                matricula = ler.next();

                alunos.inserirAluno(new Aluno(matricula, cpf, nome, email, telefone));

            } else if(option.equals("4")){ //Exibir informação de um aluno
                alunos.todosAlunos();

            } else {
                System.out.println("");
                System.out.println("Aplicação Finalizada!");
                break;
            }
            continue;
        }
        ler.close();
    }
}