/*
PROG: runround
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   5 Jul 2014
// PROLEM ID        :   Runaround Numbers
// DESCRIPTION      :   A program that finds and prints the next runaround number 
//                      higher than M
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
import java.lang.*;

public class runround
{
    public static void main (String[] args) throws IOException, NullPointerException
    {
         //Opening files for input and output
        Scanner in = new Scanner(new FileReader("runround.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
        
        int M=in.nextInt();
        
        for(int u=M+1;;u++)
        {
            boolean[] used= new boolean[10];
            boolean test=true;
            init(used);
            String num= u+"";
            int size= num.length();
            for(int g=0;g<size;g++)
            {
                if(used[num.charAt(g)-'0'])
                {
                    test=false;
                }
                else
                    used[num.charAt(g)-'0']=true;
            }
            
            if(test)
            {
                if(runAround(num, size))
                {
                    out.println(num);
                    break;
                }
                
            }
            else
                continue;
        }
        
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
    
    private static void init(boolean[] x)
    {
        x[0]=true;
        for(int u=1; u<=9;u++)
        {
            x[u]=false;
        }
    }
    
    private static boolean runAround(String x, int y)
    {
        boolean[] reached= new boolean[y];
        
        for(int u=0;u<y;u++)
        {
            reached[u]=false;
        }
        
        int current=0;
        boolean ftest=false;
        for(int u=0;u<y;u++)
        {
            if(reached[current])
            {
                break;
            }
            reached[current]=true;
            current= ((x.charAt(current)-'0')+current)%y;
        }
        
        ftest= (current==0);
        boolean test=ftest;
        for(int u=0;u<y;u++)
        {
            if(!reached[u] || !test)
            {
                test=false;
                break;
            }
        }
        return test;
    }
}
