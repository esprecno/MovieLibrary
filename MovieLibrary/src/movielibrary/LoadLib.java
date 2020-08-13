/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movielibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import static movielibrary.MovieLibrary.lib;

/**
 *
 * @author GUSTAVO
 */
public class LoadLib {
    /**
     * Loads a Library (previously Serialized)
     * @param name the name of the .ser file
     */
    public static void loadLib(String name){
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
}
