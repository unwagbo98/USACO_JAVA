/*
PROG: friday
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   27 Oct 2013
// PROLEM ID        :   Friday the Thirteenth
// DESCRIPTION      :   a program that will compute the frequency that the 13th 
//                      of each month lands on Sunday, Monday, Tuesday, Wednesday, 
//                      Thursday, Friday, and Saturday over a given period of N years.
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
public class friday
{
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        BufferedReader in = new BufferedReader(new FileReader("friday.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
       
        //Reads in input
        int N= Integer.parseInt(in.readLine());
        int[] year = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[] leap = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[] counter={0,0,0,0,0,0,0};
        int day=0;
        for(int u=1900; u<1900+N;u++)
        {
            if(u%4==0 && (u%100 != 0 || u%400 == 0))
            {
                for(int g=0;g<12;g++)
                {
                    counter[day]++;
                    day=(day+leap[g])%7;
                }
            }
            else
            {
                for(int g=0;g<12;g++)
                {
                    counter[day]++;
                    day=(day+year[g])%7;
                }
            }
        }
        
        for(int u=0; u<6;u++)
        {
            out.print(counter[u]+" ");
        }
        out.print(counter[6]+"\n");
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
}

