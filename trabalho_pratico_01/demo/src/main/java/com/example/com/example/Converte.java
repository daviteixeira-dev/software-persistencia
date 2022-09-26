package com.example.com.example;

// import java.io.BufferedWriter;
import java.io.File;
// import java.io.FileInputStream;
// import java.io.FileNotFoundException;
// import java.io.FileOutputStream;
// import java.io.FileWriter;
import java.io.IOException;
// import java.io.InputStream;
// import java.io.InputStreamReader;
// import java.io.Reader;
// import java.io.StringWriter;
// import java.io.Writer;
// import java.nio.charset.Charset;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
import java.util.Scanner;

// import org.json.JSONException;
// import org.json.JSONObject;
// import org.json.XML;

// import com.opencsv.bean.StatefulBeanToCsv;
// import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.databind.ObjectWriter;
// import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
// import com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder;
import com.fasterxml.jackson.xml.XmlMapper;

public class Converte {

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do arquivo json: ");
        String arquivo = scanner.nextLine();

        //XML - Deu certo criar o xml
        File file = new File("animes.xml");
        XmlMapper xml = new XmlMapper();
        xml.writeValue(file, arquivo);

        // //XML
        // Writer file = Files.newBufferedWriter(Paths.get("animes.xml"));
        // XmlMapper xml = new XmlMapper();
        // xml.writeValue(file, arquivo);
        

        JsonNode jsonTree = new ObjectMapper().readTree(new File(arquivo)); //C:/Users/clien/Documents/DEV/software-persistencia/animes.json

        // Metodo 01
        CsvSchema.Builder builder = CsvSchema.builder()
            .addColumn("id")
            .addColumn("nome")
            .addColumn("genero")
            .addColumn("numeroDeEp")
            .addColumn("numeroDeTemporadas")
            .addColumn("personagemPrincipal");
        
        CsvSchema csvSchema = builder.build().withHeader();

        CsvMapper csvMapper = new CsvMapper();
        csvMapper.writerFor(JsonNode.class)
            .with(csvSchema)
            .writeValue(new File("animes.csv"), jsonTree); //C:/Users/clien/Documents/DEV/software-persistencia/animes.csv

        // Metodo 02
        // Builder csvSchemaBuilder = CsvSchema.builder();
        // JsonNode firstObject = jsonTree.elements().next();
        // firstObject.fieldNames().forEachRemaining(fieldName -> {csvSchemaBuilder.addColumn(fieldName);} );
        // CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();

        // CsvMapper csvMapper = new CsvMapper();
        // csvMapper.writerFor(JsonNode.class)
        //     .with(csvSchema)
        //     .writeValue(new File("C:/Users/clien/Documents/DEV/software-persistencia/animes.csv"), jsonTree);

        //XML
        // ObjectMapper jsonMapper = new ObjectMapper();
        // JsonNode node = jsonMapper.readValue(arquivo, JsonNode.class);
        // XmlMapper xmlMapper = new XmlMapper();
        //     // xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        //     // xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        //     // xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_1_1, true);
        // StringWriter sw = new StringWriter();
        // xmlMapper.writeValue(sw, node);
        // System.out.println(sw.toString());

        //XML
        // JSONObject json = new JSONObject(arquivo);
        // System.out.println(XML.toString(json));

        // //XML
        // Writer file = Files.newBufferedWriter(Paths.get("animes.xml"));
        // XmlMapper xml = new XmlMapper();
        // xml.writeValue(file, arquivo);
        scanner.close();
    }
}
