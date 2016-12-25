/*
PROG: decorate
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   22 Mar 2014
// PROLEM ID        :   Number Triangles
// DESCRIPTION      :   A program that calculates the highest sum of numbers 
//                      that can be passed on a route that starts at the top 
//                      and ends somewhere on the base.
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
import java.lang.*;

public class decorate
{
    public static void main (String[] args) throws IOException, NullPointerException
    {
         //Opening files for input and output
        Scanner in = new Scanner(new FileReader("decorate.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("decorate.out")));
        
        int N=in.nextInt();
        int x=0;
        char[] place= new char[99999];
        boolean[] numCows= new boolean[N];
        int[] counter= new int[N];
        for(int u=0;u<N;u++)
        {
            StringTokenizer tk= new StringTokenizer(in.nextLine());
            place[Integer.parseInt(tk.nextToken())]= tk.nextToken().charAt(0);
        }
              
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
}