/*
PROG: holstein
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   24 Apr 2014
// PROLEM ID        :   Healthy Holsteins
// DESCRIPTION      :   A program to help Farmer John feed his cows so they stay healthy 
//                      while minimizing the number of scoops that a cow is fed.
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
import java.lang.*;

public class holstein
{
    private static int V, G;
    private static int count=0;
    private static int min=9999;
    private static int[] Daily, tempScoop;
    private static boolean[] used;
    private static String ans;
    private static String[] answer;
    private static ArrayList<int[]> Scoop = new ArrayList<int[]>();
    public static void main (String[] args) throws IOException, NullPointerException
    {
         //Opening files for input and output
        Scanner in = new Scanner(new FileReader("holstein.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
        
        V=in.nextInt();
        Daily= new int[V];
        for(int u=0;u<V;u++)
        {
            Daily[u]=in.nextInt();
        }
        
        G= in.nextInt();
        
        
        
        for(int u=0;u<G;u++)
        {
            int[] tempScoop= new int[V];
            for(int g=0;g<V;g++)
            {
                tempScoop[g]=in.nextInt();
            }
            
            Scoop.add(u,tempScoop);
        }
        
        answer= new String[G+1];
        for(int u=0;u<G;u++)
        {
            boolean[] checked= new boolean[G];
            used= new boolean[G];
            ans="";
            count=0;
            solve(Scoop.get(u), u, count, ans);
        }
        
        out.println(min+answer[min]);
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
    
    private static void solve(int[] a, int b,int c, String d)
    {
        if(count>=G)
            return;

        d+=" "+(b+1);
        c++;
        
        if(check(a))
        {
            if(c<min)
            {
                min=c;
                answer[min]= d;
            }
        }
        else
        {
            for(int u= b+1; u<G;u++)
            {
                int[] temp= new int[V];
                for(int g=0;g<V;g++)
                {
                    temp[g]= a[g]+Scoop.get(u)[g];
                }   
                solve(temp,u,c,d);
            }
        }        
        return;
    }
    
    private static boolean check (int[] a)
    {
        for(int u=0;u<V;u++)
        {
            if(a[u]<Daily[u])
                return false;
        }
        return true;
    }
}