import java.util.List;

public class Animes {
    
    public Animes(){}
    
    public Animes(List<Anime> animes) {
        this.animes = animes;
    }

    private List<Anime> animes;
    
    public List<Anime> getAnimes() {
        return animes;
    }

    public void setAnimes(List<Anime> animes) {
        this.animes = animes;
    }

    @Override
    public String toString(){
        return this.animes.toString();
    }
}
