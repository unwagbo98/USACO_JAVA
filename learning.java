/*
PROG: learning
ID: unwagbo
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   12 Oct 2013
// PROLEM ID        :   Milking Cows
// DESCRIPTION      :   Program that will examine a list of beginning and 
//                      ending times for N (1 <= N <= 5000) farmers milking N cows and compute 
//                      (in seconds):
//                      The longest time interval at least one cow was milked.
//                      The longest time interval (after milking starts) during which no cows were being milked.
//                      will output GO\n (STAY\n otherwise)
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
public class learning
{
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        BufferedReader in = new BufferedReader(new FileReader("learning.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("learning.out")));
        

        //Reads in input
        StringTokenizer tk= new StringTokenizer(in.readLine());
        int N= Integer.parseInt(tk.nextToken());
        int A= Integer.parseInt(tk.nextToken());
        int B= Integer.parseInt(tk.nextToken());
        int count=0;
        int[] known=new int[N];
        String[] spot=new String[B+1];
       
        
        for(int u=0;u<N;u++)
        {
            tk= new StringTokenizer(in.readLine());
            String temp= tk.nextToken();
            known[u] = Integer.parseInt(tk.nextToken());
            spot[known[u]]=temp;
        }
        Arrays.sort(known);
        if(N==1)
        {
            if(spot[known[0]].charAt(0)=='S')
            {
                System.out.println(B-A);
            }
            else
            {
                System.out.println(0);
            }
            out.close();
            System.exit(0);
        }
        for(int u=0;u<N;u++)
        {
            if(u==N-1)
            {
                if(known[u]<B && spot[known[u]].charAt(0)=='S')
                {
                    count+=(B-known[u])+1;
                }
                continue;
            }
            if(u==0)
            {
                if(known[u]>A && spot[known[u]].charAt(0)=='S')
                {
                    count+=known[u]-A;
                }
            }
            
            if(spot[known[u]].charAt(0)=='S' && spot[known[u+1]].charAt(0)=='S')
            {
                count+=known[u+1]-known[u]+1;
            }
            else if(spot[known[u]].charAt(0)=='S' )
            {
                count+=(known[u+1]-known[u]+1)/2+1;
            }
            else if(spot[known[u+1]].charAt(0)=='S' )
            {
                count+=(known[u+1]-known[u]+1)/2;
            }
        }
        
        
        
        //Prints Results
        out.println(count);
        
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
}
