
package movielibrary;

import java.util.Scanner;

/**
 * 
 * @author Quentin KAMENDA - ISEN Lille 2017
 * @version 0.0 (no way to load/save the datas)
 * @since 10th December 2017
 */
public class MovieLibrary {
    
    /**
     * Input
     */
    static Scanner input = new Scanner(System.in);
    /**
     * Default library
     */
    static Library lib = new Library();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        while (true){
            System.out.println("\n Enter 0 to quit"
                    + "\n Enter 1 to view the content of your library"
                    + "\n Entrer 2 to add a Movie to your collection");
            
            Integer action = input.nextInt();
            
            switch (action){
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println(lib.toString());
                    break;
                case 2:
                    addMovie();
                    break;
                
                // ADD CASES HERE TO ADD FUNCTIONALITIES
                default:
                    break;
            }
        }
    }
    
    /**
     * Method to make the user add a movie in his library
     */
    private static void addMovie(){
        String name, director, genre;
        Integer year;
        
        System.out.println("Entrer the name of the movie (no spaces):");
        name = input.next();
        
        System.out.println("Enter its director:");
        director = input.next();
        
        System.out.println("Enter the genre:");
        genre = input.next();
        
        System.out.println("Enter the release year:");
        year = input.nextInt();
        
        Movie movie = new Movie(name, director, genre, year);
        lib.addMovie(movie);
    }
    
}
