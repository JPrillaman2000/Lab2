/*
Josh Prillaman
9/18/2020
This corresponds to the ReadAndWrite Class to process a csv file
*/

public class Movie {

    //defines all of the variables to be used
    private String id;
    private String titleType;
    private String primaryTitle;
    private String originalTitle;
    private String startYear;
    private String runtime;
    private String genre;

    //blank constructor to set original values
    public Movie(){
        id = null;
        titleType = null;
        primaryTitle = null;
        originalTitle = null;
        startYear = null;
        runtime = null;
        genre = null;
    }

    //constructor which initializes all of the input parameters
    public Movie(String id, String titleType, String primaryTitle, String originalTitle, String startYear, String runtime, String genre){
        this.id = id;
        this.titleType = titleType;
        this.primaryTitle = primaryTitle;
        this.originalTitle = originalTitle;
        this.startYear = startYear;
        this.runtime = runtime;
        this.genre = genre;
    }

    //all of the setter methods
    public void setid(String newid){
        this.id = newid;
    }
    public void settitleType(String newtitleType){
        this.id = newtitleType;
    }
    public void setprimaryTitle(String newprimaryTitle){
        this.id = newprimaryTitle;
    }
    public void setoriginalTitle(String neworiginalTitle){
        this.id = neworiginalTitle;
    }
    public void setstartYear(String newstartYear){
        this.id = newstartYear;
    }
    public void setruntime(String newruntime){
        this.id = newruntime;
    }
    public void setgenre(String newgenre){
        this.id = newgenre;
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
        return genre;
    }

    //dump method which returns all of the values
    public String dump(){
        return (id + " " + titleType + " " + primaryTitle + " " + originalTitle + " " + startYear + " " + runtime + " " + genre);
    }

}
