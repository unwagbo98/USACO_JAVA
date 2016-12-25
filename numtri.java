/*
PROG: numtri
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

public class numtri
{
    public static void main (String[] args) throws IOException, NullPointerException
    {
         //Opening files for input and output
        BufferedReader in = new BufferedReader(new FileReader("numtri.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
        
        int N=Integer.parseInt(in.readLine());
        int[] sum= new int[N];
        int[][] tri= new int[N][N];      
        int M=N-1;
        for(int u=0;u<M;u++)
        {
            StringTokenizer tk = new StringTokenizer(in.readLine()," ");
            for(int g=0;g<=u;g++)
            { 
               tri[u][g]=Integer.parseInt(tk.nextToken());
            }
        }
        StringTokenizer tk2 = new StringTokenizer(in.readLine()," ");
        for(int u=0;u<N;++u)
        {
            sum[u]=Integer.parseInt(tk2.nextToken());
        }
        for(int u=M-1;u>-1;--u)
        {
            for(int g=0;g<=u;++g)
            {
                sum[g]= tri[u][g]+Math.max(sum[g],sum[g+1]);
            }
        }
        
        //Output
        out.println(sum[0]);
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
}