package com.lista;

import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.lista.dao.AlunoDAO;
import com.lista.dao.AlunoJDBCDAO;
import com.lista.entidade.Aluno;

public class App {
    public static void main( String[] args ){

        AlunoDAO baseAlunos = new AlunoJDBCDAO();

        System.out.println("=====Aplicação de dados sobre alunos!=====");
        Scanner ler = new Scanner(System.in);

        while (true) {

            System.out.println("");
            System.out.println("=====Bem-vindo ao menu principal=====");
            System.out.println("Qual opção deseja realizar?");
            System.out.println("1 - Inserir um novo aluno");
            System.out.println("2 - Deletar um aluno");
            System.out.println("3 - Alterar informação de um aluno");
            System.out.println("4 - Exibir informação de um aluno");
            System.out.println("5 - Exibir todos os alunos cadastrados");
            System.out.println("6 - Finalizar a aplicação");
            System.out.print("Informe: ");

            Aluno alu;
            String option = ler.nextLine();


            if (option.equals("1")) { //Inserir um novo aluno
                
                alu = new Aluno();
                obterAluno(alu);
				baseAlunos.inserirAluno(alu);

            } else if (option.equals("2")) { //Deletar um aluno

                int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do aluno para remover:"));
                alu = baseAlunos.consultarAluno((id));
                if(alu != null) { 
                    baseAlunos.deletarAluno(alu.getId()); 
                }else { 
                    JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
                 }

            } else if(option.equals("3")){ //Alterar informação de um aluno

                String cpf = JOptionPane.showInputDialog("Digite o CPF do cliente a ser alterado: ");
                alu = baseAlunos.consultarAlunoPeloCPF(cpf);
                obterAluno(alu);
				baseAlunos.inserirAluno(alu);

            } else if(option.equals("4")){ //Exibir informação de um aluno

                int id = Integer.parseInt(JOptionPane.showInputDialog("Id"));
				alu = baseAlunos.consultarAluno(id);
				listaAluno(alu);

            } else if(option.equals("5")){ //Exibir todos os alunos cadastrados

                listaAlunos(baseAlunos.todosAlunos());

            }else {
                System.out.println("");
                System.out.println("Aplicação Finalizada!");
                break;
            }
            continue;
        }
        ler.close();
    }

    public static void obterAluno(Aluno alu) {
		String cpf = JOptionPane.showInputDialog("CPF", alu.getCpf());
        String nome = JOptionPane.showInputDialog("Nome", alu.getNome());
        String email = JOptionPane.showInputDialog("Email", alu.getEmail());
		String telefone = JOptionPane.showInputDialog("Telefone", alu.getTelefone());
        String matricula = JOptionPane.showInputDialog("Matricula", alu.getMatricula());
		alu.setCpf(cpf);
		alu.setNome(nome);
		alu.setEmail(email);
        alu.setTelefone(telefone);
        alu.setMatricula(matricula);
    };

    public static void listaAluno(Aluno alu) {
		JOptionPane.showMessageDialog(null, alu == null ? "Nenhum aluno encontrado" : alu);
	};

    public static void listaAlunos(List<Aluno> alunos) {
		StringBuilder listagem = new StringBuilder();
		for(Aluno alu : alunos) {
			listagem.append(alu).append("\n");
		}
		JOptionPane.showMessageDialog(null, listagem.length() == 0 ? "Nenhum aluno encontrado" : listagem);
	}
}
