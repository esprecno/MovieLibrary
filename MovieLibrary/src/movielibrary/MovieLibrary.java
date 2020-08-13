
package movielibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Quentin KAMENDA - ISEN Lille 2017
 * @version 0.3 (Filter)
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
     * File name for the Serialization
     */
    static String fileName = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        while (true){
            System.out.println("\n Enter 0 to save and quit"
                    + "\n Enter 1 to load a Library"
                    + "\n Enter 2 to add a Movie to your collection"
                    + "\n Enter 3 to delete a Movie from your collection"
                    + "\n Enter 4 to view the content of your Library"
                    + "\n Enter 5 to list all the movies of a year");
            
            Integer action = input.nextInt();
            switch (action){
                case 0:
                    SaveAndQuit.saveAndQuit();
                    break;
                case 1:
                    System.out.println("Enter the name of the file to load:");
                    LoadLib.loadLib(input.next());
                    break;
                case 2:
                    AddMovie.addMovie();
                    break;
                case 3:
                    System.out.println("Enter the name of the movie you want to delete: ");
                    lib.delMovie(input.next());
                    break;
                case 4:
                    System.out.println(lib.toString());
                    break;
                case 5:
                    System.out.println("Enter the year to filter: ");
                    System.out.println(lib.yearMovies(input.nextInt()).toString());
                    break;
                // ADD CASES HERE TO ADD FUNCTIONALITIES
                default:
                    break;
            }
        }
    } 
    
}
