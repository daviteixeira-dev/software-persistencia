import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Serializa {
    public static void main(String[] args) throws IOException {
        Anime n1 = new Anime(1, "Dragon Ball Z", "Shounen", 291);
        Anime n2 = new Anime(2, "Naruto Shippuden", "Shounen", 500);

        List<Anime> lista = new ArrayList<Anime>();

        lista.add(n1);
        lista.add(n2);
        Animes animes = new Animes(lista);
        File arquivo = new File("animes.xml");

        XmlMapper xml = new XmlMapper();
        xml.writeValue(arquivo, lista);
        xml.enable(SerializationFeature.INDENT_OUTPUT);
        xml.writeValue(arquivo, animes);
    }
}
