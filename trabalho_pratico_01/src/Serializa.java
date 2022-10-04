import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Serializa {
    public static void main(String[] args) throws Exception{

        System.out.println("========== Cadastro de Animes ==========");

        Scanner scanner = new Scanner(System.in);
        ArrayList<Anime> listaDeAnimes = new ArrayList<Anime>();

        System.out.print("Quantos animes você quer cadastrar? ");
        int numeroDeAnimes = scanner.nextInt();

        System.out.println("========== INICIANDO ==========");

        // Laço de repetição
        for (int i = 0; i < numeroDeAnimes; i++) {
            System.out.print("ID do anime: ");
            int id = scanner.nextInt();

            System.out.print("Nome do anime: ");
            scanner.nextLine();
            String nome = scanner.nextLine();

            System.out.print("Genero do anime: ");
            String genero = scanner.nextLine();

            System.out.print("Numero de episodios do anime: ");
            int numeroEp = scanner.nextInt();

            System.out.print("Numero de temporadas do anime: ");
            int numeroTemporadas = scanner.nextInt();

            System.out.print("Qual o nome do personagem principal? ");
            scanner.nextLine();
            String personagemPrincipal = scanner.nextLine();

            System.out.println("====Anime cadastrado!====");

            Anime n = new Anime(id,nome,genero,numeroEp,numeroTemporadas,personagemPrincipal);
            
            listaDeAnimes.add(n);
        }

        // Imprimir animes no terminal
        for(int i = 0; i < listaDeAnimes.size(); i++){
            Anime nTemp = listaDeAnimes.get(i);
            System.out.println("O id do anime N" + i + "° é: " + nTemp.getId());
            System.out.println("O nome do anime N" + i + "° é: " + nTemp.getNome());
            System.out.println("O genero do anime N" + i + "° é: " + nTemp.getGenero());
            System.out.println("O numero de epsodios do anime N" + i + "° é: " + nTemp.getNumeroEp());
            System.out.println("O numero de temporadas do anime N" + i + "° é: " + nTemp.getNumeroTemporadas());
            System.out.println("O personagem principal do anime N" + i + "° é: " + nTemp.getPersonagemPrincipal());
            System.out.println("=============================================");
        }

        System.out.println("Lista Cadastrada!");

        Animes animes = new Animes(listaDeAnimes);
        ObjectMapper jsonString = new ObjectMapper();
        jsonString.enable(SerializationFeature.INDENT_OUTPUT);
        jsonString.writeValue(new File("animes.json"), animes);

        scanner.close();
    }
}
