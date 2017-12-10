
package movielibrary;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Quentin KAMENDA - ISEN Lille 2017
 * @version 0.0
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
        collection = new ArrayList<Movie>();
    }
    
    /**
     * Method to add a created movie in the library
     * @param movie the movie to be added
     */
    public void addMovie(Movie movie){
        collection.add(movie);
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
    
    
}
