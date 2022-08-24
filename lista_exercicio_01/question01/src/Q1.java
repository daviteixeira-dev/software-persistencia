import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        int n1, n2, count = 0;
        String valorInicial, valorfinal;

        Scanner ler = new Scanner(System.in);

        System.out.printf("Nome do arquivo:\n");
        String arquivo = ler.nextLine();

        InputStream entrada = new FileInputStream(arquivo);
        Scanner textoEntrada = new Scanner(entrada);


        System.out.println("Digite o valor de N1: ");
        valorInicial = ler.nextLine();

        System.out.println("Digite o valor de N2: ");
        valorfinal = ler.nextLine();

        n1 = Integer.parseInt(valorInicial);
        n2 = Integer.parseInt(valorfinal);

        while(textoEntrada.hasNextLine()){
            textoEntrada.nextLine();
            count++;
        }

        count = n2 > 1 ? n2: count;

        entrada.close();
        textoEntrada.close();

        InputStream novaEntrada = new FileInputStream(arquivo);
        Scanner novoTextoEntrada = new Scanner(novaEntrada);

        for(int j = 1; j <= count; j++){
            if((j >= n1)){
                System.out.println(novoTextoEntrada.nextLine());
            }else{
                novoTextoEntrada.nextLine();
            }
        }

        ler.close();
        novoTextoEntrada.close();
    }
}
