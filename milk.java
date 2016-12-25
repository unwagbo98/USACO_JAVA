/*
PROG: milk
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   26 Oct 2013
// PROLEM ID        :   Mixing Milk
// DESCRIPTION      :   A program that calculates the minimum price that Merry Milk Makers 
//                      can get their milk at for one day.
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
public class milk
{
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        BufferedReader in = new BufferedReader(new FileReader("milk.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
        
         StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        //Reads in input
        int N= Integer.parseInt(tokenizer.nextToken());
        int M= Integer.parseInt(tokenizer.nextToken());
        
        int [][] cost= new int[M][2];
        for(int u=0;u<M;u++)
        {
            StringTokenizer tokenizer2 = new StringTokenizer(in.readLine());
            cost[u][0]=Integer.parseInt(tokenizer2.nextToken());
            cost[u][1]=Integer.parseInt(tokenizer2.nextToken());
        }
         
        //Sorts the cost
        for (int u = 0; u <  M - 1 ; u++) 
        {
             for (int g = 0; g < M-1-u; g++) 
             {
                 int swap;
                 int swap2;
                 if (cost[g][0] > cost[g+1][0]) /* For descending order use < */
                 {
                     swap = cost[g][0];
                     swap2 =cost[g][1];
                     cost[g][0] = cost[g+1][0];
                     cost[g][1] = cost[g+1][1];
                     cost[g+1][0] = swap;
                     cost[g+1][1] = swap2;
                 }
             }
        }
        int min =0;
        int amount=0;
        int x=0;
        while(amount<N)
        {
            min+=cost[x][0]*cost[x][1];
            amount+=cost[x][1];
            x++;
        }
        int temp= amount-N;
        if(amount==N)
           out.println(min);
        else
        {
           min-= cost[x-1][0]*temp;
           out.println(min);
        }
    
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
}
