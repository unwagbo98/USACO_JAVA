/*
PROG: prefix
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   5 Jul 2014
// PROLEM ID        :   Runaround Numbers
// DESCRIPTION      :   A program that finds and prints the next runaround number 
//                      higher than M
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
import java.lang.*;

public class prefix
{
    private static int size,primSize=0,numPrim=0;
    private static String seq;
    private static String[] prim=new String[200];
    private static boolean[][] valid;
    public static void main (String[] args) throws IOException, NullPointerException
    {
         //Opening files for input and output
        BufferedReader in = new BufferedReader(new FileReader("prefix.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));
        String temp= in.readLine();
        do
        {
            StringTokenizer tk= new StringTokenizer(temp);
            
            while(tk.hasMoreTokens())
            {
                prim[numPrim]=tk.nextToken();
                primSize= Math.max(prim[numPrim].length(),primSize);
                numPrim++;
            }
            temp=in.readLine();
        }while(temp.charAt(0)!= '.');

        StringBuilder sb = new StringBuilder();
        temp=in.readLine();
        while(temp != null)
        {
            sb.append(temp);
            temp=in.readLine();
        }
        
        seq= sb.toString();
        size=seq.length();
        int ans=0;
        valid=new boolean[size][primSize+1];
        
        for(int u=0;u<)
        
        System.out.println(ans);
        out.println(ans);
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
    
}
