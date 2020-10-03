/*
Josh Prillaman
9/18/2020
This corresponds to the ReadAndWrite Class to process a csv file
*/

import java.util.*;

public class Movie {

    //defines all of the variables to be used
    private String id;
    private String titleType;
    private String primaryTitle;
    private String originalTitle;
    private String startYear;
    private String runtime;
    //creates the Genre object by calling the default constructor
    private Genre genres = new Genre();

    //blank constructor to set original values
    public Movie(){
        id = null;
        titleType = null;
        primaryTitle = null;
        originalTitle = null;
        startYear = null;
        runtime = null;
    }

    //constructor which initializes all of the input parameters
    public Movie(String id, String titleType, String primaryTitle, String originalTitle, String startYear, String runtime, ArrayList<String> genre){
        this.id = id;
        this.titleType = titleType;
        this.primaryTitle = primaryTitle;
        this.originalTitle = originalTitle;
        this.startYear = startYear;
        this.runtime = runtime;
        //sets the genre by using the  input ArrayList
        genres.setGenres(genre);

    }

    //all of the setter methods
    public void setid(String newid){
        this.id = newid;
    }
    public void settitleType(String newtitleType){
        this.titleType = newtitleType;
    }
    public void setprimaryTitle(String newprimaryTitle){
        this.primaryTitle = newprimaryTitle;
    }
    public void setoriginalTitle(String neworiginalTitle){
        this.originalTitle = neworiginalTitle;
    }
    public void setstartYear(String newstartYear){
        this.startYear = newstartYear;
    }
    public void setruntime(String newruntime){
        this.runtime = newruntime;
    }
    public void setgenre(ArrayList<String> newgenre){
        genres.setGenres(newgenre);
    }

    //all of the getter methods
    public String getid(){
        return id;
    }
    public String gettitleType(){
        return titleType;
    }
    public String getprimaryTitle(){
        return primaryTitle;
    }
    public String getoriginalTitle(){
        return originalTitle;
    }
    public String getstartYear(){
        return startYear;
    }
    public String getruntime(){
        return runtime;
    }
    public String getgenre(){
        return genres.toString();
    }

    //dump method which returns all of the values
    public String toString(){
        return (id + " " + titleType + " " + primaryTitle + " " + originalTitle + " " + startYear + " " + runtime + " " + genres.toString());
    }

    public static Comparator<Movie> compareAge  = new Comparator<Movie>(){
        public int compare(Movie movie1, Movie movie2){
            String startYear1 = movie1.getstartYear();
            String startYear2 = movie2.getstartYear();
            int tempVal = Integer.parseInt(startYear1) - Integer.parseInt(startYear2);

            if(tempVal == 0){
                tempVal = movie1.getprimaryTitle().compareTo(movie2.getprimaryTitle());
            }

            return tempVal;

            /*if(Integer.parseInt(movie1.getstartYear()) < Integer.parseInt(movie2.getstartYear())){
                //return -1;
                return Integer.parseInt(movie1.getstartYear()) - Integer.parseInt(movie2.getstartYear());
            }
            else if(Integer.parseInt(movie1.getstartYear()) > Integer.parseInt(movie2.getstartYear())){
                //return 1;
                return Integer.parseInt(movie1.getstartYear()) - Integer.parseInt(movie2.getstartYear());
            }
            else{
                return compareName.compare(movie1, movie2);
            }*/
        }
    };

    /*public static Comparator<Movie> compareName = new Comparator<>(){
        public int compare(Movie movie1, Movie movie2){
            if(movie1.getprimaryTitle().compareTo(movie2.getprimaryTitle()) < 0){
                //return -10;
                return movie1.getprimaryTitle().compareTo(movie2.getprimaryTitle());
            }
            else if(movie1.getprimaryTitle().compareTo(movie2.getprimaryTitle()) > 0){
                //return 10;
                return movie1.getprimaryTitle().compareTo(movie2.getprimaryTitle());
            }
            else{
                return 0;
            }
        }
    };*/

}
