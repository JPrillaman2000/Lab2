import java.util.*;

public class Genre {

    ArrayList<String> genres = new ArrayList<String>();
    private String primaryTitle;

    public Genre(){
        primaryTitle = null;
    }

    public Genre(ArrayList<String> genres){
        this.genres = genres;
    }

    public Genre(String primaryTitle, ArrayList<String> genres){
        this.primaryTitle = primaryTitle;
        this.genres = genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public String toString(){
        if(primaryTitle != null){
            return primaryTitle + ": " + genres.toString();
        }
        else{
            return genres.toString();
        }
    }

    public boolean isGenre(String genre){
        boolean containing = false;
        if(genres.contains(genre)){
            containing = true;
        }
        return containing;
    }
}