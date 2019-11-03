package com.company;

import java.io.*;
import java.util.*;

public class DuplicateCounter {
    private Map<String, Integer> wordCounter;
    public DuplicateCounter(){
        wordCounter = new HashMap<String,Integer>();
    }
    //same order as before except now it's count
    public void count(String filename){
        System.out.println("Reading " + filename);
        Scanner scnr = null;
        try {
            scnr = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }
        scnr.useDelimiter("([0-9]|[.,!?:;'\"-]|\\s)+");
        while(scnr.hasNext()) {
            String input = scnr.next().toLowerCase();
            Integer counter = wordCounter.get(input);
                if(counter == null)
                counter = 1;
            else
                counter = counter + 1;
            wordCounter.put(input, counter);
        }
        scnr.close();
    }

    public void write(String filename){
        System.out.println("Duplicates counted " + filename);
        try {
            PrintWriter outfile = new PrintWriter(new File(filename));
            for(String i : wordCounter.keySet()) {
                outfile.println(i + " " + wordCounter.get(i));
            }
            outfile.close();
            System.out.println("Examine " + filename);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

//please no hard exam :(