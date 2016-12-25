/*
PROG: milk2
ID: unwagbo1
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
public class milk2
{
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        BufferedReader in = new BufferedReader(new FileReader("milk2.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        
         StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        //Reads in input
        int N= Integer.parseInt(tokenizer.nextToken());
        
        int [][] times= new int[N][2];
        for(int u=0;u<N;u++)
        {
            StringTokenizer tokenizer2 = new StringTokenizer(in.readLine());
            times[u][0]=Integer.parseInt(tokenizer2.nextToken());
            times[u][1]=Integer.parseInt(tokenizer2.nextToken());
        }
         
        //Sorts the times
         for (int u = 0; u <  N - 1 ; u++) 
         {
             for (int g = 0; g < N-1-u; g++) 
             {
                 int swap;
                 int swap2;
                 if (times[g][0] > times[g+1][0]) /* For descending order use < */
                 {
                     swap = times[g][0];
                     swap2 =times[g][1];
                     times[g][0] = times[g+1][0];
                     times[g][1] = times[g+1][1];
                     times[g+1][0] = swap;
                     times[g+1][1] = swap2;
                 }
             }
         }
        
        //Calculate longest work time
        int [] longest= new int[N];
        for(int u=0;u<N-1;u++)
        {
            int g=u+1;
            int[] tempTime=new int[2];
            tempTime[0]=times[u][0];
            tempTime[1]=times[u][1];
            while(times[g][0]<=tempTime[1]&&g<N-1)
            {
                if(tempTime[1]<times[g][1])
                    tempTime[1]= times[g][1];
                g++;
            }
       
            longest[u]= tempTime[1]-tempTime[0];
           
        }
        longest[N-1]=times[N-1][1]-times[N-1][0];
  
        int maxWork=0;
        Arrays.sort(longest);
        maxWork=longest[N-1];
 
        if(N==1)
            maxWork=times[0][1]-times[0][0];
       //Calculates Idle Time
       int [] longest2= new int[N];
        for(int u=0;u<N-1;u++)
        {  
            int g = u+1;
            int skips=0;
            if(times[u][1]>times[g][0])
            {
                while(times[u][1]>times[g][1] && g<N-1)
                {
                    g++;
                    skips++;
                }
            }
            else
            {    
                longest2[u]=times[u+1][0]-times[u][1];
            }
            u+=skips;
        }
        
        int maxIdle=0;
        for(int u=0;u<N-1;u++)
        {
            if(maxIdle<longest2[u])
                maxIdle=longest2[u];
        }
        //Prints Results
        out.println(maxWork+" "+maxIdle);
        
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
}
