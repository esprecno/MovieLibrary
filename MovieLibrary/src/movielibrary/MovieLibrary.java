
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
 * @version 0.2
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
                    + "\n Enter 4 to view the content of your Library");
            
            Integer action = input.nextInt();
            switch (action){
                case 0:
                    saveAndQuit();
                    break;
                case 1:
                    System.out.println("Enter the name of the file to load:");
                    loadLib(input.next());
                    break;
                case 2:
                    addMovie();
                    break;
                case 3:
                    System.out.println("Enter the name of the movie you want to delete: ");
                    lib.delMovie(input.next());
                    break;
                case 4:
                    System.out.println(lib.toString());
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
        
        System.out.println("Enter its director (no spaces):");
        director = input.next();
        
        System.out.println("Enter the genre (no spaces):");
        genre = input.next();
        
        System.out.println("Enter the release year:");
        year = input.nextInt();
        
        Movie movie = new Movie(name, director, genre, year);
        lib.addMovie(movie);
    }
    
    /**
     * Saves the Library in a '.ser' file and quits the program
     */
    private static void saveAndQuit(){
        System.out.println("Enter file name: ");
        
        fileName = input.next() + ".ser";
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        
        try {
            fos = new FileOutputStream(fileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(lib);
            fos.close();
            out.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        
        System.exit(0);
    }
    
    /**
     * Loads a Library (previously Serialized)
     * @param name the name of the .ser file
     */
    private static void loadLib(String name){
        FileInputStream fis = null;
        ObjectInputStream in = null;
        
        File file = new File(name + ".ser");
        
        if (file.exists()){
            try{
                fis = new FileInputStream(file);
                in = new ObjectInputStream(fis);
                lib = (Library) in.readObject();
                fis.close();
                in.close();  
                System.out.println("Library " + name + " successfully loaded!");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        
        else {
            System.out.println("The file does not exist. Check your file's name.");
        }
    }
    
    
}
