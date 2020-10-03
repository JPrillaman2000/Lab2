/*
Josh Prillaman
9/18/2020
This program reads a csv file of movie information and writes a series of requested files
*/

//imports all of the necessary items and functions for use
import java.util.*;
import java.io.*;

public class ReadAndWrite {

    //creates the input and scanner variables
    private static Scanner input;
    private static Scanner scnr;

    public static void main(String[] args) throws IOException {
        //defines a string for the name of the file
        String fileName;
        //determines if the path was placed in the command line, or if it is necessary to continue with the scanner
        if(args.length > 0){
            //sets the filename to be the first item in the command line
            fileName = args[0];
        }
        else{
            //creates the scanner object
            scnr = new Scanner(System.in);

            //creates two wellbeing variables to update through the try catch process
            boolean working = false;
            int counter = 0;

            //shows that while working is false, the process will repeat up until the 8th iteration in which the
            //program is exited assuming an error in the input
            while(!working) {
                //prompts for input and assigns it to filename
                System.out.print("Enter the name of the input file: ");
                fileName = scnr.next();

                //if the conversion through a scanner is successful the status variable is set to true, exiting the loop
                try {
                    input = new Scanner(new FileReader(fileName));
                    working = true;
                }
                //catches the exception if the file is not found
                catch (FileNotFoundException e) {
                    System.out.println("The file named " + fileName + " was not found.");
                }
                //catches any miscellaneous exceptions
                catch (Exception e) {
                    System.out.println("A strange error occurred: " + e);
                }

                //on the third iteration, the program is exited assuming an error
                if(counter == 8){
                    System.out.println("A repetitive or unintentional error has occurred.");
                    System.out.println("Please revisit the name of the file you are attempting to use.");
                    System.exit(2);
                }
                //updates the counter
                counter ++;
            }
        }

        //creates an arraylist to store the objects
        ArrayList<Movie> moviesList = new ArrayList<Movie>();

        //formats the data to be used later
        input.useDelimiter(",");
        //skips the first line of headings
        input.nextLine();

        //sets the variables within the object for each row of data that exists
        while(input.hasNext()){
            String id = input.next();
            if(id.contains("/n")){
                id = "NA";
            }
            String titleType = input.next();
            if(titleType.contains("/n")){
                titleType = "NA";
            }
            String primaryTitle = input.next();
            if(primaryTitle.contains("/n")){
                primaryTitle = "NA";
            }
            String originalTitle = input.next();
            if(originalTitle.contains("/n")){
                originalTitle = "NA";
            }
            String startYear = input.next();
            if(startYear.contains("/n")){
                startYear = "0";
            }
            String runtime = input.next();
            if(runtime.contains("/n")){
                runtime = "0";
            }
            String genre = input.nextLine();
            if(genre.contains("/n")){
                genre = "NA";
            }

            //converts all of the input data to lowercase
            id = id.toLowerCase();
            titleType = titleType.toLowerCase();
            primaryTitle = primaryTitle.toLowerCase();
            originalTitle = originalTitle.toLowerCase();
            genre = genre.toLowerCase();

            //converts the genre(s) to an arraylist
            ArrayList<String> genreArrayList = new ArrayList<String>();
            String[] genreArray = genre.split(" ");
            genreArrayList.addAll(Arrays.asList(genreArray));

            //adds the arraylist object and corresponding title to the Genre class
            Genre y = new Genre(primaryTitle,genreArrayList);

            //creates the object and adds it to the arraylist
            Movie x = new Movie(id,titleType,primaryTitle,originalTitle,startYear,runtime,genreArrayList);
            moviesList.add(x);
        }

        //creates the filewriter
        FileWriter titleWriter = new FileWriter("src/Titles.txt");
        //loops through all of the objects within the arraylist
        for(Movie x : moviesList){
            String title = x.getprimaryTitle();
            titleWriter.write(title + "\n");
        }
        titleWriter.close();

        //creates the filewriter
        FileWriter moviesAgeWriter = new FileWriter("src/Movies2005-2020.txt");
        //loops through all of the objects within the arraylist
        for(Movie x : moviesList){
            //converts the year to an integer
            //if the value is not a number, it is excluded form the file
            try{
                int year = Integer.parseInt(x.getstartYear());
                //if the year is between 2005 and 2020, all the info is dumped
                if(year >= 2005 && year <= 2020){
                    moviesAgeWriter.write(x.toString() + "\n");
                }
            }
            catch(Exception e){
                break;
            }
        }
        moviesAgeWriter.close();

        //creates the filewriter
        FileWriter documentaryWriter = new FileWriter("src/Documentary.txt");
        //loops through all of the objects within the arraylist
        for(Movie x : moviesList){
            //if the movie is a documentary, the info is dumped
            if(x.getgenre().contains("Documentary")){
                documentaryWriter.write(x.toString() + "\n");
            }
        }
        documentaryWriter.close();

        //creates the filewriter
        FileWriter titleYearWriter = new FileWriter("src/Title-Year.txt");
        //loops through all of the objects within the arraylist
        for(Movie x : moviesList){
            String title = x.getprimaryTitle();
            String year = x.getstartYear();
            titleYearWriter.write(title + ", " + year + "\n");
        }
        titleYearWriter.close();

        FileWriter sortedWriter = new FileWriter("src/Sorted-Movies.txt");
        Collections.sort(moviesList, Movie.compareAge);
        for(Movie x : moviesList){
            sortedWriter.write(x.toString());
        }
        sortedWriter.close();


        //prints out a completion message showing that the code has run effectively
        System.out.println("Your Requested files have been created and are available within the src folder");

    }
}