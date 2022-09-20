import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serializa {
    public static void main(String[] args) throws JsonProcessingException {
        
        Anime n1 = new Anime(1, "Dragon Ball Z", "Shounen", 291);
        Anime n2 = new Anime(2, "Naruto Shippuden", "Shounen", 500);

        List<Anime> lista = new ArrayList<Anime>();

        lista.add(n1);
        lista.add(n2);
        Animes animes = new Animes(lista);

        ObjectMapper jsonString = new ObjectMapper();
        jsonString.writerWithDefaultPrettyPrinter().writeValue(new File("animes.json"), animes);
    }
}
