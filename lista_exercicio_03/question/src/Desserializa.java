import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Desserializa {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Anime verAnime = null;

        FileInputStream arquivo = new FileInputStream("lista_exercicio_03/question01/arquivo.txt");
        ObjectInputStream ler = new ObjectInputStream(arquivo);

        verAnime =  (Anime) ler.readObject();
        System.out.println("Seu arquivo foi Desserializado!");
        System.out.println(verAnime);
        ler.close();

    }
}
