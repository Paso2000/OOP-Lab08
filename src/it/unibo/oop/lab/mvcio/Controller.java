package it.unibo.oop.lab.mvcio;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
/**
 * 
 */
public class Controller {
    Controller contt;
    File file = new File(System.getProperty("user.home")+File.separator+"test.txt");
    private static String FILE_NAME="test.txt";
    private final static String PATH = System.getProperty("user.home")
            + System.getProperty("file.separator")
            + Controller.class.getSimpleName()+ ".txt";
            
            
            
    void SetFile(String s) {
        Controller.FILE_NAME=s;
    }
    
    String GetFile() {
        return Controller.FILE_NAME;
    }
    
    String GetPath(File f) {
        return f.getPath();
    }
    
    void WriteOnFile(String s) throws IOException{
        try(BufferedWriter w = new BufferedWriter(new FileWriter(this.file))
           ){
            w.write(s);
        };
        
        
    }
    

    /*
     * This class must implement a simple controller responsible of I/O access. It
     * considers a single file at a time, and it is able to serialize objects in it.
     * 
     * Implement this class with:
     * 
     * 1) A method for setting a File as current file
     * 
     * 2) A method for getting the current File
     * 
     * 3) A method for getting the path (in form of String) of the current File
     * 
     * 4) A method that gets a String as input and saves its content on the current
     * file. This method may throw an IOException.
     * 
     * 5) By default, the current file is "output.txt" inside the user home folder.
     * A String representing the local user home folder can be accessed using
     * System.getProperty("user.home"). The separator symbol (/ on *nix, \ on
     * Windows) can be obtained as String through the method
     * System.getProperty("file.separator"). The combined use of those methods leads
     * to a software that runs correctly on every platform.
     */

}
