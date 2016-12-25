/*
PROG: subset
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   5 Jul 2014
// PROLEM ID        :   Subset Sums
// DESCRIPTION      :   A program that prints the number of ways a set containing 
//                      the integers from 1 through N can be partitioned into two 
//                      sets whose sums are identical. Print 0 if there are no such ways.
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
import java.lang.*;

public class subset
{
    private static int count =0, goal=0, N;
    private static boolean[][] test = new boolean[781][40];
    private static int[][] solved = new int[781][40];
    public static void main (String[] args) throws IOException, NullPointerException
    {
         //Opening files for input and output
        Scanner in = new Scanner(new FileReader("subset.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
        
        N=in.nextInt();
        
        for(int u=0;u<781;u++)
        {
            for(int g=0;g<40;g++)
            {
                test[u][g]=false;
            }
        }
        for(int u=1; u<=N; u++)
        {
            goal+=u;
        }
        
        if(goal%2==1)
        {
            out.println(0);
            out.close();
            System.exit(0);
        }
        goal/=2;
        
        out.println(solve(goal,N));
        
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
    
    private static int solve (int sum, int num)
    {
        
        if(sum<0 || num<0)
        {
            return 0;
        }
        
        if(sum==0 && num==0)
        {
            return 1;
        }
        
        if(sum==0 || num==0)
        {
            return 0;
        }
        
        if(test[sum][num])
        {
            return solved[sum][num];
        }
        
        test[sum][num]=true;
        solved[sum][num]=solve(sum,num-1)+solve(sum-num,num-1);
        return solved[sum][num];
    }
}
