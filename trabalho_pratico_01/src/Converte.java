import java.io.File;
import java.io.Writer;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Converte {
    public static void main (String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do arquivo json: ");
        String arquivo = scanner.nextLine();

        Animes animesJson = new ObjectMapper().readValue(new File(arquivo), Animes.class);

        toXML(animesJson);
        toCSV(animesJson);
        scanner.close();
    }

    //XML
    public static void toXML(Animes animes) throws Exception {

        File file = new File("animes.xml");
        XmlMapper xml = new XmlMapper();
        xml.enable(SerializationFeature.INDENT_OUTPUT);
        xml.writeValue(file, animes);
        System.out.println("O arquivo foi convertido para XML com sucesso!");
    }

    //CSV
    public static void toCSV(Animes animes) throws Exception {

        Writer writer = Files.newBufferedWriter(Paths.get("animes.csv"));
        StatefulBeanToCsv<Animes> beanToCsv = new StatefulBeanToCsvBuilder<Animes>(writer).build();
        beanToCsv.write(animes);
        writer.flush();
        writer.close();
        System.out.println("O arquivo foi convertido para CSV com sucesso!");
    }
}
