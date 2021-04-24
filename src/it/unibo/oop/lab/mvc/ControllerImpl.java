package it.unibo.oop.lab.mvc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import it.unibo.oop.lab.mvcio.SimpleGUI;

public class ControllerImpl implements Controller {
    ControllerImpl cont;
    File file= new File(System.getProperty("user.home")+File.separator+"test.txt");
    private int current=0;
    List<String> list = new ArrayList<>();

    public ControllerImpl() {
    }

    
    public void SetNextString(String s) {
       list.set(current++,s);
       
    }

    
    public String GetNextString() {
        
        return list.get(current);
        
    }

    
    public List<String> Hisotry() throws IllegalArgumentException{
        List<String> temp = new ArrayList<>();
        int i=0;
        while( i<=this.current) {
          temp.add(list.get(i));
        }
        return temp;
    }

    
    public void PrintCurrent() throws IOException, IllegalArgumentException {
       try(
        BufferedWriter w = new BufferedWriter(new FileWriter(this.file))
        )
       {
         w.write(cont.GetNextString());
       }
       
    
         };
}


