import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Desserializa {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper =  new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Animes animes = mapper.readValue(new File("animes.json"), Animes.class);
        System.out.println(animes.toString());
    }
}
