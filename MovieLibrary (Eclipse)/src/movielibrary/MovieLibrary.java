
package movielibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.google.gson.Gson;


/**
 * This is the main Class, where all the actions are available.
 * @author Quentin KAMENDA - ISEN Lille 2017
 * @version 0.4 (.json)
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
                	saveLibraryJson();
                    break;
                case 1:
                	loadLibraryJson();
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
                case 5:
                    System.out.println("Enter the year to filter: ");
                    System.out.println(lib.yearMovies(input.nextInt()).toString());
                    break;
                // TODO ADD CASES HERE TO ADD FUNCTIONALITIES
                default:
                	System.err.println("Not a valid Integer");
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
        
        input.nextLine();
        
        System.out.println("Entrer the name of the movie (no spaces):");
        name = input.nextLine();

        System.out.println("Enter its director (no spaces):");
        director = input.nextLine();

        System.out.println("Enter the genre (no spaces):");
        genre = input.nextLine();
        
        System.out.println("Enter the release year:");
        year = input.nextInt();
        
        Integer id = lib.getCollection().size()+1;
        
        Movie movie = new Movie(name, director, genre, year, id);
        if (!lib.checkMovie(movie)){
            lib.addMovie(movie);
        }
        
    }
    
    /**
     * Saves the Library in a '.ser' file and quits the program
     */
    @SuppressWarnings("unused")
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
            System.err.println("File not Found!");
        } catch (IOException e){
        	System.err.println("File not Found!!");
        }
        
        System.exit(0);
    }
    
    /**
     * Loads a Library (previously Serialized)
     * @param name the name of the .ser file
     */
    @SuppressWarnings("unused")
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
                //e.printStackTrace();
                System.err.print("Unable to open the file!");
            } catch (ClassNotFoundException e){
                //e.printStackTrace();
                System.err.print("Unable to open the file!!");
            }
        }
        
        else {
            System.out.println("The file does not exist. Check your file's name.");
        }
    }
    
    /**
     * Saves the Library in a .json file
     */
    private static void saveLibraryJson () {
    	
        Gson gson = new Gson();
        
        String json = gson.toJson(lib); 
        
        FileWriter out = null;
        System.out.println("Enter file name: ");
        File file = new File(input.next() + ".json");
        
        try {
        	out = new FileWriter(file);
        	out.write(json.toString());
        	out.close();
        } catch (FileNotFoundException e){
        	System.err.println("File not Found!");
        } catch (IOException e){
        	System.err.println("File not Found!!");
        }
        
        System.exit(0);
    	
    }
    
    /**
     * Loads a .json file Library
     */
    private static void loadLibraryJson () {
    	
    	Gson gson = new Gson();
        
        FileReader in = null;
        System.out.println("Enter file name: ");
        File file = new File(input.next() + ".json");
        
        try {
        	in = new FileReader(file);
        	lib = gson.fromJson(in, lib.getClass());
        	in.close();
        } catch (FileNotFoundException e){
        	System.err.println("File not Found!");
        } catch (IOException e){
        	System.err.println("File not Found!");
        }
    	
    }
    
    
}
