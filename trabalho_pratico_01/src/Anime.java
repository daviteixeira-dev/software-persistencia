public class Anime {
    private int id;
    private String nome;
    private String genero;
    private int numeroEp;
    private int numeroTemporadas;
    private String personagemPrincipal;
    
    public Anime() {}

    public Anime(int id, String nome, String genero, int numeroEp, int numeroTemporadas, String personagemPrincipal) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.numeroEp = numeroEp;
        this.numeroTemporadas = numeroTemporadas;
        this.personagemPrincipal = personagemPrincipal;
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

    public int getNumeroEp() {
        return numeroEp;
    }

    public void setNumeroEp(int numeroEp) {
        this.numeroEp = numeroEp;
    }

    public int getNumeroTemporadas() {
        return numeroTemporadas;
    }

    public void setNumeroTemporadas(int numeroTemporadas) {
        this.numeroTemporadas = numeroTemporadas;
    }

    public String getPersonagemPrincipal() {
        return personagemPrincipal;
    }

    public void setPersonagemPrincipal(String personagemPrincipal) {
        this.personagemPrincipal = personagemPrincipal;
    }

    @Override
    public String toString() {
        return "ListaDeAnimes{" +
        "Animes='" + id + '\'' +
        ", nome='" + nome + '\'' +
        ", genero='" + genero + '\'' +
        ", numeroEP='" + numeroEp + '\'' +
        ", numeroTP='" + numeroTemporadas + '\'' +
        ", personagem='" + personagemPrincipal + '\'' +
        '}';
    }
 }
