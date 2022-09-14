import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "assistidos");

public class Animes {
    private List<Anime> animes;

    public Animes(){}

    public Animes(List<Anime> animes) {
        this.animes = animes;
    }

    @JacksonXmlElementWrapper(localName = "animes");
    @JacksonXmlProperty(localName = "anime");

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
