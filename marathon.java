/*
PROG: marathon
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
public class marathon
{
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        BufferedReader in = new BufferedReader(new FileReader("marathon.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("marathon.out")));
        

        //Reads in input
        int N= Integer.parseInt(in.readLine());
        int distance =99999999;
        int[][] point= new int[N][N];
        int tempDist=0;
        
        for(int u=0;u<N;u++)
        {
            StringTokenizer tk= new StringTokenizer(in.readLine());
            point[u][0]=Integer.parseInt(tk.nextToken());
            point[u][1]=Integer.parseInt(tk.nextToken());
        }
        
        for(int u=1;u<N-1;u++)
        {
            if(point[u][0]== point[0][0] && point[u][1]== point[0][1] )
            {
                continue;
            }
            if(point[u][0]== point[N-1][0] && point[u][1]== point[N-1][1] )
            {
                continue;
            }
            for(int g=0;g<N;g++)
            {
                if(g==0)
                {
                    tempDist=0;
                    continue;
                }
                if(g==u)
                {
                    continue;
                }
                if(g==(u+1))
                {
                    tempDist+=Math.abs(point[g][0]-point[g-2][0])+Math.abs(point[g][1]-point[g-2][1]);
                    continue;
                }
                tempDist+=Math.abs(point[g][0]-point[g-1][0])+Math.abs(point[g][1]-point[g-1][1]);
            }
            distance=Math.min(distance,tempDist);
        }
        
        /*for(int g=1;g<N;g++)
        {
                
            tempDist+=Math.abs(point[g][0]-point[g-1][0])+Math.abs(point[g][1]-point[g-1][1]);
        }
        distance=Math.min(distance,tempDist);*/
        
        
        
        //Prints Results
        out.println(distance);
        
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
}
