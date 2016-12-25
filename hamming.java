/*
PROG: hamming
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   3 Jul 2014
// PROLEM ID        :   Hamming Codes
// DESCRIPTION      :   Given N, B, and D: Find a set of N codewords (1 <= N <= 64), 
//                      each of length B bits (1 <= B <= 8), such that each of the 
//                      codewords is at least Hamming distance of D (1 <= D <= 7) away 
//                      from each of the other codewords.
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
import java.lang.*;

public class hamming
{
    
    public static void main (String[] args) throws IOException, NullPointerException
    {
         //Opening files for input and output
        Scanner in = new Scanner(new FileReader("hamming.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
        
        int N=in.nextInt(),B=in.nextInt(),D=in.nextInt();
        int max= (int)Math.pow(2,B);
        int[] ans= new int[N];
        ans[0]=0;
        int count=1;
        for(int u=1;u<max;u++)
        {
            boolean test=true;
            for(int o=0;o<count;o++)
            {
                String prev = Integer.toString(ans[o],2);
                String cur = Integer.toString(u,2);
                
                if(cur.length()> prev.length())
                {
                   String tempStg="";
                   for(int g=0;g<(cur.length()-prev.length());g++)
                   {
                       tempStg+="0";
                   }
                   prev=tempStg+prev;
                }
                
                int dist=0;
                for(int g=0;g<cur.length();g++)
                {
                    if(cur.charAt(g)!=prev.charAt(g))
                    {
                        dist++;
                    }
                }
                
                if(dist<D)
                {
                    test=false;
                    break;
                }
            }
            if(test)
            {
                ans[count]=u;
                count++;
            }
            if(count>=N)
            {
                break;
            }
            
        }
        
        for(int u=0;u<N;u++)
        {
            if(u%10==0)
            {
                out.print(ans[u]);
            }
            else if(u%10==9)
            {
                out.print(" "+ans[u]);
                out.println();
            }
            else
            {
                out.print(" "+ans[u]);
            }
            
        }
        if(N%10 !=0)
        {
            out.println();
        }
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
    
   
}