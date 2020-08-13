/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movielibrary;

import static movielibrary.MovieLibrary.input;
import static movielibrary.MovieLibrary.lib;

/**
 *
 * @author GUSTAVO
 */
public class AddMovie {
    /**
     * Method to make the user add a movie in his library
     */
    public static void addMovie(){
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
        
        Movie movie = new Movie(name, director, genre, year);
        if (!lib.checkMovie(movie)){
            lib.addMovie(movie);
        }
        
    }
}
