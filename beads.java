/*
PROG: beads
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   26 Oct 2013
// PROLEM ID        :   Broken Necklace
// DESCRIPTION      :   A program to determine the largest number of 
//                      beads that can be collected from a supplied necklace. 
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
public class beads
{
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        BufferedReader in = new BufferedReader(new FileReader("beads.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
       
        //Reads in input
        int N= Integer.parseInt(in.readLine());
        String beads= in.readLine(); 
        beads+=beads+beads;
        char color;
        int[] counter=new int[N];
        for(int u=0;u<N;u++)
        {
           int temp=u;

           while((beads.charAt(temp)=='w'))
           {
               if(temp==2*N-1)
                    break;
               counter[u]++;
               temp++;
           } 
            color=beads.charAt(temp);
           while((beads.charAt(temp)==color)|| (beads.charAt(temp)=='w')&&(temp<(2*N-1)))
            {
                if(temp==2*N-1)
                    break;
                counter[u]++;
                temp++;
            }
           while((beads.charAt(temp)!=color)|| (beads.charAt(temp)=='w')&&(temp<(2*N-1)))
           {
               if(temp==2*N-1)
                   break;
               counter[u]++;
               temp++;
           }

        }
        Arrays.sort(counter);
        if(counter[N-1]>=N)
            out.println(N); 
        else
            out.println(counter[N-1]);
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
}

