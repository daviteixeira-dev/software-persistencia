import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("=====Aplicação para inserir e listar alunos!=====");
        Scanner ler = new Scanner(System.in);

        while (true) {
            System.out.println("");
            System.out.println("=====Bem-vindo ao menu principal=====");
            System.out.println("Qual opção deseja realizar?");
            System.out.println("1 - Listar todos os alunos");
            System.out.println("2 - Inserir um novo aluno");
            System.out.println("3 - Finalizar a aplicação");
            System.out.print("Informe: ");

            String option = ler.nextLine();

            if (option.equals("1")) {
                showAlunos(ler);
            } else if (option.equals("2")) {
                novoAluno(ler);
            } else {
                System.out.println("");
                System.out.println("Aplicação Finalizada!");
                break;
            }
            continue;
        }

        ler.close();
    }

    public static void novoAluno(Scanner ler) {
        System.out.println("=====Cadastro de um novo aluno=====");
        System.out.print("Digite o CPF deste aluno: ");
        String cpf = ler.nextLine();
        System.out.print("Digite uma matricula para esse aluno: ");
        String matricula = ler.nextLine();
        System.out.print("Qual o nome deste aluno? ");
        String nome = ler.nextLine();
        System.out.print("Digite o email desse aluno: ");
        String email = ler.nextLine();
        System.out.print("Digite o telefone desse aluno: ");
        String telefone = ler.nextLine();

        try {
            // Carrega a classe, adicionando o driver JDBC ao Classpath
            Class.forName("org.postgresql.Driver");
            // Estabelecer a conexão a partir de uma URL, neste caso usando uma classe de ConnectionFactory
            Connection conn = ConnectionFactory.getConnection();
            System.out.println("=====Conexão com o Banco de Dados OK!=====");

            String sql = "insert into alunos (cpf, matricula, nome, email, telefone) values (?,?,?,?,?)";

            // Cria um comando Statement
            PreparedStatement st = conn.prepareStatement(sql);
            
            st.setString(1, cpf);
            st.setString(2, matricula);
            st.setString(3, nome);
            st.setString(4, email);
            st.setString(5, telefone);

            // Processa os resultados dessa consulta
            st.executeUpdate();
            System.out.println("Aluno cadastrado com sucesso!");
            st.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void showAlunos(Scanner ler) throws SQLException {
        System.out.println("=====Listagem de Alunos=====");

        try {
            // Carrega a classe, adicionando o driver JDBC ao Classpath
            Class.forName("org.postgresql.Driver");
            // Estabelecer a conexão a partir de uma URL, neste caso usando uma classe de ConnectionFactory
            Connection conn = ConnectionFactory.getConnection();
            System.out.println("=====Conexão com o Banco de Dados OK!=====");

            String sql = "select * from alunos where id >=?";

            // Cria um comando Statement
            PreparedStatement st = conn.prepareStatement(sql);
            
            st.setInt(1, 1);
            // Executa uma consulta ou atualização
            ResultSet rs = st.executeQuery();
            // Processa os resultados dessa consulta
            while (rs.next()) {
                int id = rs.getInt("id");
                String cpf = rs.getString("cpf");
                String matricula = rs.getString("matricula");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String telefone = rs.getString("telefone");
                System.out.println("{Aluno com id: " + id + ", nome: " + cpf + ", matricula: " + matricula +
                        ", nome: " + nome + ", email: " + email + "e telefone: " + telefone + "}");
            }
            // Fecha a conexão
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
