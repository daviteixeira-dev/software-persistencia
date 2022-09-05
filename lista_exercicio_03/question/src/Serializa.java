import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializa {
    public static void main(String[] args) throws IOException{
        Anime novoAnime = new Anime();

        novoAnime.setId(001);
        novoAnime.setNome("Dragon Ball Z");
        novoAnime.setGenero("Shounen");
        novoAnime.setNumeroDeEpsodios(291);

        FileOutputStream arquivo = new FileOutputStream("lista_exercicio_03/question01/arquivo.txt");
        ObjectOutputStream saida = new ObjectOutputStream(arquivo);
        saida.writeObject(novoAnime);

        System.out.println("Seu arquivo foi serializado!");
        saida.close();
        arquivo.close();
    }
}
