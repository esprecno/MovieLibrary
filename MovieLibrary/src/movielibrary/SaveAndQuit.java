/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movielibrary;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import static movielibrary.MovieLibrary.*;

/**
 *
 * @author GUSTAVO
 */
public class SaveAndQuit {
    
    /**
     * Saves the Library in a '.ser' file and quits the program
     */
    public static void saveAndQuit(){
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
            //e.printStackTrace();
            System.err.print("Unable to open the file!");
        } catch (IOException e){
            //e.printStackTrace();
            System.err.print("Unable to open the file!!");
        }
        
        System.exit(0);
    }
}
