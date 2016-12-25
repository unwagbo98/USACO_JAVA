/*
PROG: sort3
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   24 Apr 2014
// PROLEM ID        :   Sorting a Three-Valued Sequence 
// DESCRIPTION      :   A program that computes the minimal number of exchange operations that 
//                      are necessary to make the sequence sorted.
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
import java.lang.*;

public class sort3
{
    private static int N;
    public static void main (String[] args) throws IOException, NullPointerException
    {
         //Opening files for input and output
        BufferedReader in = new BufferedReader(new FileReader("sort3.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
        
        N=Integer.parseInt(in.readLine());
        int[]numbers= new int[N];
        int[]sortedN= new int[N];
        int[] counts= new int[4];
        for(int u=0;u<N;u++)
        {
            numbers[u]= Integer.parseInt(in.readLine());
            sortedN[u]=numbers[u];
            counts[numbers[u]]++;
        }
        Arrays.sort(sortedN);
        int counter=0;
        int start=0;
        int current=0;
        int end=0;
        //put 1s in right place
        while(!(numbers.equals(sortedN)))
        {
            if(start>=counts[1])
                break;
            while(start<counts[1] && numbers[start]==1)
            {
                start++;
            }
            
            if(start>=counts[1])
                break;
            if(numbers[start]==3)
            {
                end=N-1;
                while(end > start && numbers[end]!=1)
                {
                    end--;
                }
                
                if(end<N && end>start && numbers[end]==1)
                {
                    counter++;
                    numbers[start]=1;
                    numbers[end]=3;
                }
            }
            if(numbers[start]==2)
            {
                end=counts[1];
                while(end<N && numbers[end]!=1)
                {
                    end++;
                }
                
                if(end<N && numbers[end]==1)
                {
                    counter++;
                    numbers[start]=1;
                    numbers[end]=2;
                }
            }
            start++;
        }        
        //put 2s in right place
        start=0;
        end=0;
        while(!(numbers.equals(sortedN)))
        {
            if(start>=N)
                break;
            while(start<N && numbers[start]!=3)
            {
                start++;
            }
            if(start>=N)
                break;
            if(numbers[start]==3)
            {
                end=N-1;
                while(end>start && numbers[end]!=2)
                {
                    end--;
                }
                
                if(end>start && numbers[end]==2)
                {
                    counter++;
                    numbers[start]=2;
                    numbers[end]=3;
                }
            }
            
            start++;
        }        
        out.println(counter);
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
    
}