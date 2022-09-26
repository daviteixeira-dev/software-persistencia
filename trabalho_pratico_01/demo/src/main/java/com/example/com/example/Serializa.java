package com.example.com.example;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serializa {
    public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException, JsonProcessingException {

        System.out.println("========== Cadastro de Animes ==========");

        Scanner scanner = new Scanner(System.in);
        ArrayList<Anime> listaDeAnimes = new ArrayList<Anime>();

        System.out.print("Quantos animes você quer cadastrar? ");
        String numeroDeAnimes_s = scanner.nextLine();
        int numeroDeAnimes = Integer.parseInt(numeroDeAnimes_s);

        System.out.println("========== INICIANDO ==========");

        // Laço de repetição
        for (int i = 0; i < numeroDeAnimes; i++) {
            System.out.print("ID do anime: ");
            String id_string = scanner.nextLine();
            int id = Integer.parseInt(id_string);

            System.out.print("Nome do anime: ");
            String nome = scanner.nextLine();

            System.out.print("Genero do anime: ");
            String genero = scanner.nextLine();

            System.out.print("Numero de episodios do anime: ");
            String numeroEp_string = scanner.nextLine();
            int numeroEp = Integer.parseInt(numeroEp_string);

            System.out.print("Numero de temporadas do anime: ");
            String numeroTemporadas_string = scanner.nextLine();
            int numeroTemporadas = Integer.parseInt(numeroTemporadas_string);

            System.out.print("Qual o nome do personagem principal? ");
            String personagemPrincipal = scanner.nextLine();

            System.out.println("====Anime cadastrado!====");

            Anime n = new Anime();
            n.setId(id);
            n.setNome(nome);
            n.setGenero(genero);
            n.setNumeroEp(numeroEp);
            n.setNumeroTemporadas(numeroTemporadas);
            n.setPersonagemPrincipal(personagemPrincipal);
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

        ObjectMapper jsonString = new ObjectMapper();
        jsonString.writerWithDefaultPrettyPrinter().writeValue(new File("animes.json"), listaDeAnimes); //animes

        scanner.close();
    }
}
