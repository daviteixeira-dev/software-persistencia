import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) throws Exception {
        Scanner S = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo: ");
        String arquivo = S.nextLine();
        
        System.out.println("Qual a substring?: ");
        String subString = S.nextLine();

        System.out.println("As linhas que contem a substring são: ");

        InputStream file = new FileInputStream(arquivo);
        Scanner ler = new Scanner(file, "UTF-8");

        while(ler.hasNextLine()){
            String line = ler.nextLine();

            if(line.contains(subString))
                System.out.println(line);
        }

        S.close();
        ler.close();
    }
}
