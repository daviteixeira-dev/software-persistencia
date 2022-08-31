import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class Q4 {

    public static Properties getProp() throws IOException {
        Properties props = new Properties();

        FileInputStream file = new FileInputStream("C:/Users/clien/Documents/DEV/software-persistencia/lista_exercicio_02/question04/resources/config.properties");
        props.load(file);
        return props;
    }

    public static void main(String[] args) throws Exception {
        String arquivo;
        String linha_inicial;
        String linha_final;

        System.out.println("************ Leitura do arquivo de propriedades ************");

        Properties prop = getProp();

        arquivo = prop.getProperty("arquivo");
        linha_inicial = prop.getProperty("linha_inicial");
        linha_final = prop.getProperty("linha_final");

        System.out.println("Arquivo: " + arquivo);
        System.out.println("Linha Inicial: " + linha_inicial);
        System.out.println("Linha Final: " + linha_final);

        System.out.println("************ Leitura de um arquivo txt ************");

        Scanner scan = new Scanner(System.in);

        int inicio = Integer.parseInt(linha_inicial);
        int fim = Integer.parseInt(linha_final);

        System.out.println("Digite o nome do arquivo: ");

        String nome_arquivo = scan.nextLine();

        InputStream ler = new FileInputStream(nome_arquivo);
        Scanner entrada = new Scanner(ler);
        int count = 1;

        while(entrada.hasNextLine()){
            if(count >= inicio && count <= fim)
                System.out.println(entrada.nextLine());
            else { entrada.nextLine(); } 
                count++;
        }
        entrada.close();
        scan.close();
    }
}
