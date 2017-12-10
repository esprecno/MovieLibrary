
package movielibrary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Quentin KAMENDA - ISEN Lille 2017
 * @version 0.1
 * @since 10th December 2017
 */
public class Library implements Serializable{
    
    /**
     * List of all movies in the Library
     */
    private ArrayList<Movie> collection;

    /**
     * Constructor for an empty Library
     */
    public Library() {
        this.collection = new ArrayList<Movie>();
    }
    
    /**
     * Method to add a created movie in the library
     * @param movie the movie to be added
     */
    public void addMovie(Movie movie){
        this.collection.add(movie);
    }

    @Override
    /**
     * toString method to read the content of a Library
     */
    public String toString() {
        String printer = "";
        if (this.collection.isEmpty()){
            printer = "This Library is currently empty!";
        }
        else{
            for (int i=0; i < this.collection.size(); i++){
                printer = printer + this.collection.get(i).toString();
            }
        }
        return printer;
    }
    
    /**
     * Method to delete a (single occurence of a)movie from the movie collection
     * @param name the name of the movie to be deleted
     */
    public void delMovie(String name){
        
        Iterator<Movie> i = collection.iterator();
        
        while(i.hasNext()){
            Movie m = (Movie) i.next();
            
            if (name.equals(m.getName())){
                this.collection.remove(m);
                System.out.println(m.getName() + " has been succesfully removed!");
                return;
            }
        }
//        for (Movie movie : this.collection) {
//            if (name.equals(movie.getName())){
//                this.collection.remove(movie);
//                System.out.println(movie.getName() + " has been succesfully removed!");
//            }
//        }
    }
    
}
