import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o nome do primeiro arquivo: ");
        String primeiro_arq = scan.nextLine();

        System.out.println("Agora digite o nome do segundo arquivo: ");
        String segundo_arq = scan.nextLine();

        System.out.println("Por fim, digite o nome do novo arquivo criado: ");
        String novo_arq = scan.nextLine();

        InputStream ler_primeiro_arq = new FileInputStream(primeiro_arq);
        InputStream ler_segundo_arq = new FileInputStream(segundo_arq);

        Scanner conteudo_primeiro_arq = new Scanner(ler_primeiro_arq);
        Scanner conteudo_segundo_arq = new Scanner(ler_segundo_arq);

        PrintStream saida = new PrintStream(novo_arq);

        while(conteudo_primeiro_arq.hasNextLine() || conteudo_segundo_arq.hasNextLine()){
            if(conteudo_primeiro_arq.hasNextLine()){
                saida.println(conteudo_primeiro_arq.nextLine());
            }else{
                saida.println(conteudo_segundo_arq.nextLine());
            }
        }

        scan.close();
        conteudo_primeiro_arq.close();
        conteudo_segundo_arq.close();
        saida.close();
    }
}
