
package movielibrary;

import java.io.Serializable;

/**
 *
 * @author Quentin KAMENDA - ISEN Lille 2017
 * @version 0.0
 * @since 10th December 2017
 */
public class Movie implements Serializable{
    
    /**
     * The name of the Movie.
     * Its director.
     * Its genre.
     * Its release year.
     */
    private String name, director, genre;
    private Integer releaseYear;

    
    /**
     * Constuctor for an "empty" movie.
     */
    public Movie() {
        name = null;
        director = null;
        genre = null;
        releaseYear = 0;
    }
    
    /**
     * Constructor for a movie
     * @param name the name of the movie
     * @param director the director of the movie
     * @param genre the genre of the movie
     * @param releaseYear the year the movie has been released
     */
    public Movie(String name, String director, String genre, Integer releaseYear) {
        this.name = name;
        this.director = director;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }
    
    @Override
    /**
     * toString method the read the informations on a Movie.
     */
    public String toString() {
        return  "\nName:         " + name + 
                "\nDirector:     " + director +
                "\nGenre:        " + genre + 
                "\nReleaseYear:  " + releaseYear + '\n';
    }

    
    
    /* Accessors & Mutators */
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    
    
}
