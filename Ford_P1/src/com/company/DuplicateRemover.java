package com.company;

import java.io.*;
import java.util.*;

public class DuplicateRemover {
    private Set<String> uniqueWords;
    //since remove was requested first, i made the remove method first
    public void remove(String dataFile) throws FileNotFoundException
    {
        String input;
        uniqueWords = new HashSet<String>();
        Scanner scnr=new Scanner(new File(dataFile));
        while(scnr.hasNext())
        {
            input=scnr.next();
            uniqueWords.add(input);
        }
        scnr.close();


    }
//then "write" second
    public void write(String outputFile) throws IOException
    {
        File f;
        f = new File(outputFile);
        FileWriter fw = null;
        if(!f.exists()) {
            f.createNewFile();
            fw=new FileWriter(f);
            Iterator iter=uniqueWords.iterator();

            while(iter.hasNext())
            {
                String input=(String)iter.next();
                fw.write(input+"\n");
            }
            fw.close();
            System.out.printf("Duplicates removed\n");
        }
        else
        {
            fw=new FileWriter(f,true);
            Iterator iter=uniqueWords.iterator();
            while(iter.hasNext())
            {
                String input=(String)iter.next();
                fw.write(input+"\n");
            }
            fw.close();
            System.out.printf("Duplicates Removed\n");
        }

    }

}
