/*
PROG: preface
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   3 Jul 2014
// PROLEM ID        :   Preface Numbering
// DESCRIPTION      :   Calculate and print the number of I's, V's, etc. 
//                      (in order from lowest to highest) required to typeset 
//                      all the page numbers (in Roman numerals) from 1 through N.
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
import java.lang.*;

public class preface
{
    private static int Icount=0,Vcount=0,Xcount=0,Lcount=0,Ccount=0,Dcount=0,Mcount=0;
    public static void main (String[] args) throws IOException, NullPointerException
    {
         //Opening files for input and output
        Scanner in = new Scanner(new FileReader("preface.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
        
        int N=in.nextInt();
        
        
        for(int u=1;u<=N;u++)
        {
            convert(u);
        }
        
        if(Icount > 0)
        {
            out.println("I "+Icount);
        }
        if(Vcount > 0)
        {
            out.println("V "+Vcount);
        }
        if(Xcount > 0)
        {
            out.println("X "+Xcount);
        }
        if(Lcount > 0)
        {
            out.println("L "+Lcount);
        }
        if(Ccount > 0)
        {
            out.println("C "+Ccount);
        }
        if(Dcount > 0)
        {
            out.println("D "+Dcount);
        }
        if(Mcount > 0)
        {
            out.println("M "+Mcount);
        }
        
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
    
   // Modified Integer to Roman Numeral Converter
    private static void convert(int input) 
    {
        while (input >= 1000) 
        {
            Mcount++;
            input -= 1000;        
        }
        while (input >= 900) 
        {
            Ccount++;
            Mcount++;
            input -= 900;
        }
        while (input >= 500) 
        {
            Dcount++;
            input -= 500;
        }
        while (input >= 400) 
        {
            Ccount++;
            Dcount++;
            input -= 400;
        }
        while (input >= 100) 
        {
            Ccount++;
            input -= 100;
        }
        while (input >= 90) 
        {
            Xcount++;
            Ccount++;
            input -= 90;
        }
        while (input >= 50) 
        {
            Lcount++;
            input -= 50;
        }
        while (input >= 40) 
        {
            Xcount++;
            Lcount++;
            input -= 40;
        }
        while (input >= 10) 
        {
            Xcount++;
            input -= 10;
        }
        while (input >= 9) 
        {
            Icount++;
            Xcount++;
            input -= 9;
        }
        while (input >= 5) 
        {
            Vcount++;
            input -= 5;
        }
        while (input >= 4) 
        {
            Icount++;
            Vcount++;
            input -= 4;
        }
        while (input >= 1) 
        {
            Icount++;
            input -= 1;
        }    
    }
   
}
