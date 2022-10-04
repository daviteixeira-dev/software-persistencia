import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

@JacksonXmlRootElement(localName = "ListaDeAnimes")
    

public class Animes {
    
    private List<Anime> animes;

    public Animes(){}

    public Animes(List<Anime> animes) {
        this.animes = animes;
    }

    @JacksonXmlProperty(localName = "Anime")
    @JacksonXmlElementWrapper(localName = "Animes")

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
