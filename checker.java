/*
PROG: checker
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   3 Apr 2014
// PROLEM ID        :   Checker
// DESCRIPTION      :   A program that finds all unique solution sequences to the 
//                      Checker Challenge (with ever growing values of N).
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
public class checker 
{
    public static int N, row,count;
    public static int[] ans= new int[13];
    public static String[] answers= new String[99999];
    public static boolean[][] board= new boolean[14][14];
    public static boolean[] col= new boolean[13];
    public static boolean[] diag1= new boolean[27];
    public static boolean[] diag2= new boolean[27];
    public static PrintWriter out;
    
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        Scanner in = new Scanner(new FileReader("checker.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        out = new PrintWriter(new BufferedWriter(new FileWriter("checker.out")));
       
        //Reads in input
        N= in.nextInt();
        /*int[] ans= new int[13];
        String[] answers= new String[100];
        boolean[][] board= new boolean[14][14];
        boolean[] col= new boolean[13];
        boolean[] diag1= new boolean[27];
        boolean[] diag2= new boolean[27];*/
        /*count=0;
        for(int u=0;u<N;u++)
        {
            ans[u]=0;
            col[u]=false;
        }
        for(int u=0;u<27;u++)
        {
            diag1[u]=false;
            diag2[u]=false;
        }*/
        solve(0);
        
        /*for(int u=0;u<3;u++)
        {
            StringTokenizer tk = new StringTokenizer(answers[u]," .");
            out.print(tk.nextToken().charAt(4));
            for(int g=1;g<N;g++)
            {
                out.print(" "+tk.nextToken());
            }
            out.println();
        }*/
        out.println(count);
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
    public static void solve(int row)throws IOException
    {
        if(row==N)
        {
            if(count<3)
            {
                out.print(ans[0]+1);
                for(int g=1;g<N;g++)
                {
                    out.print(" "+(ans[g]+1));
                }
                out.println();
            }
            count++;
            return;
        }
        else
        {               
            for(int u=0;u<N;u++)
            {
                if(valid(u, row))
                //if(!(col[u]) && !(diag1[(u-row)+N]) && !(diag2[u+row]))
                {
                    col[u]=true;
                    diag1[(u-row)+N]= true;
                    diag2[u+row]= true;
                    ans[row]=u;
                    
                    /*if(row==N-1)
                    {
                        for(int g=0;g<N;g++)
                        {
                            answers[count]+=(ans[g]+1)+".";
                        }
                        count++;       
                    }*/
                    solve(row+1);
                    col[u]=false;
                    diag1[(u-row)+N]= false;
                    diag2[u+row]= false;
                }
            }
        }
       
    }
    
    public static boolean valid(int x, int y)
    {
        if(!(col[x]) && !(diag1[(x-y)+N]) && !(diag2[x+y]))
            return true;
        else
            return false;
    }
}

