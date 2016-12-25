/*
PROG: barn1
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   30 Oct 2013
// PROLEM ID        :   Barn Repair
// DESCRIPTION      :   A program that calculates the minimum number of stalls 
//						that must be blocked in order to block all the stalls 
//						that have cows in them.
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
public class barn1
{
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        BufferedReader in = new BufferedReader(new FileReader("barn1.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
        
         StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        //Reads in input
        int M= Integer.parseInt(tokenizer.nextToken());
        int S= Integer.parseInt(tokenizer.nextToken());
		int C= Integer.parseInt(tokenizer.nextToken());
        int [] Filled= new int[C];
		for(int u=0;u<C;u++)
		{
			Filled[u]=Integer.parseInt(in.readLine());
		}
		Arrays.sort(Filled);
        if(M>=C && M>S)
		{
			out.println(S-(Filled[C-1]-Filled[0]-1));
		}
		else if(M>=C)
		{
			out.println(S-(Filled[C-1]-Filled[0])-1);
		}
		else
		{
			int[] Unused = new int[C-1];
			for(int u=0;u<C-1;u++)
			{
				Unused[u]=Filled[u+1]-Filled[u]-1;
			}
			//Find the largest unused intervals
			int[] MaxUnused = new int[M-1];
			Arrays.sort(Unused);
			for(int u=0;u<M-1;u++)
			{
				MaxUnused[u]=Unused[C-u-2];
			}
			//Calculate the total empty stalls
			int Empty=0;
			for(int u=0;u<M-1;u++)
			{
				Empty+=MaxUnused[u];
			}
			//Output
			out.println(Filled[C-1]-Filled[0]-Empty+1);     
		}
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
}
