public class Anime {
    private int id;
    private String nome;
    private String genero;
    private int numeroDeEpsodios;

    public Anime(){}

    public Anime(int id, String nome, String genero, int numeroDeEpsodios) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.numeroDeEpsodios = numeroDeEpsodios;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getNumeroDeEpsodios() {
        return numeroDeEpsodios;
    }
    public void setNumeroDeEpsodios(int numeroDeEpsodios) {
        this.numeroDeEpsodios = numeroDeEpsodios;
    }

    @Override
    public String toString() {
        return "Anime [genero=" + genero + ", id=" + id + ", nome=" + nome + ", numeroDeEpsodios=" + numeroDeEpsodios
                + "]";
    }
}
