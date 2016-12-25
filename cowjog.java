/*
PROG: cowjog
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
public class cowjog
{
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        Scanner in = new Scanner(new FileReader("cowjog.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjog.out")));
        

        //Reads in input
        int N= in.nextInt();
        int count =N;
        int[] speed= new int[N];
        
        for(int u=0;u<N;u++)
        {
            int temp=in.nextInt();
            speed[u]=in.nextInt();
        }
        
        for(int u=N-1;u>0;u--)
        {
            if(speed[u]<speed[u-1])
            {
                count--;
                speed[u-1]=speed[u];
            }
        }
        
        
        
        //Prints Results
        out.println(count);
        
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
}
