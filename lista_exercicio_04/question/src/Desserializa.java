import java.io.File;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Desserializa {
    public static void main(String[] args) throws Exception {
        File arquivo = new File("animes.xml");

        XmlMapper xml = new XmlMapper();

        Animes x = XmlMapper.readValue(arquivo, Animes.class);
        System.out.println(x);
    }
}
