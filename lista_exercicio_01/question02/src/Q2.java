import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);

        System.out.printf("Nome do arquivo:\n");
        String arquivo = ler.nextLine();

        System.out.printf("Nome do arquivo:\n");
        String novoArquivo = ler.nextLine();

        InputStream entrada = new FileInputStream(arquivo);
        Scanner textoEntrada = new Scanner(entrada);

        PrintStream ps = new PrintStream(novoArquivo);

        while(textoEntrada.hasNextLine()){
            if(textoEntrada.hasNextLine()){
                ps.println(textoEntrada.nextLine());
            }
        }

        
        ps.close();
        textoEntrada.close();
        ler.close();
    }
}
