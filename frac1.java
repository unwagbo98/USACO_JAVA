/*
PROG: frac1
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   24 Apr 2014
// PROLEM ID        :   Ordered Fractions
// DESCRIPTION      :   A program that, given an integer N between 1 and 160 
//                      inclusive, prints the fractions in order of increasing magnitude..
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
import java.lang.*;

public class frac1
{
    private static int N;
    private static boolean[][] validFrac;
    public static void main (String[] args) throws IOException, NullPointerException
    {
         //Opening files for input and output
        BufferedReader in = new BufferedReader(new FileReader("frac1.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
        
        N=Integer.parseInt(in.readLine());
        validFrac= new boolean[N+1][N+1];
        
        //Make all possible fractions
        out.println("0/1");
        for(int den=2; den<=N; den++)
        {
            for(int num=1;num<den;num++)
            {
                solve(num,den);
            }
        }
        
        //Find how many fractions
        int counter=0;
        for(int u=0;u<=N;u++)
        {
            for(int g=0;g<=N;g++)
            {
                if(validFrac[u][g])
                {
                    counter++;
                    //out.println(u+"/"+g);
                }
            }
        }
        
        //Find the valid fractions in decimal form
        double[] ans= new double[counter];
        counter=0;
        for(int u=0;u<=N;u++)
        {
            for(int g=0;g<=N;g++)
            {
                if(validFrac[u][g])
                {
                    ans[counter]= (double)(u)/(double)(g);
                    counter++;
                    //out.println(u+"/"+g);
                }
            }
        }   
        
        //Sort the decimals from smallest to largest
        Arrays.sort(ans);
        
        // Print out the fractions
        for(int x=0; x<counter;x++)
        {
            double temp= ans[x];
            for(int u=0;u<=N;u++)
            {
                boolean test=false;
                for(int g=0;g<=N;g++)
                {
                    if(validFrac[u][g])
                    {
                        if(temp== ((double)(u)/(double)(g)))
                        {
                            out.println(u+"/"+g);
                            test=true;
                            break;
                        }
                        
                    }
                }
                if(test)
                    break;
            }
        }
        out.println("1/1");
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
    
    private static void solve(int n, int d)
    {
        int num= n/gcf(n,d);
        int den= d/gcf(n,d);
        validFrac[num][den]=true;
    }
    
    private static int gcf(int a, int b)
    {
       if(a == 0) 
           return b;
       if(b == 0) 
           return a;
       if(a > b) 
           return gcf(b, a % b);
       return gcf(a, b % a);
    }
}