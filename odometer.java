/*
PROG: odometer
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   22 Mar 2014
// PROLEM ID        :   Number Triangles
// DESCRIPTION      :   A program that calculates the highest sum of numbers 
//                      that can be passed on a route that starts at the top 
//                      and ends somewhere on the base.
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
import java.lang.*;

public class odometer
{
    public static void main (String[] args) throws IOException, NullPointerException
    {
         //Opening files for input and output
        Scanner in = new Scanner(new FileReader("odometer.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("odometer.out")));
        
        long N=(long)in.nextInt();
        long M=(long)in.nextInt();
        
        int counter = 0;
        
        for(long u=N;u<=M;++u)
        {
            String num=u+"$";
            int length= (num).length()-1;
            for(int g=0;g<length;g++)
            {
                StringTokenizer tk = new StringTokenizer(num,(num.charAt(g)+""));
                int temp=-1;
                while(tk.hasMoreTokens())
                {
                    temp+=(tk.nextToken()).length();
                }
                if(temp==1)
                {
                    counter++;
                    break;
                }
            }
            
        }
        
        out.println(counter);
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
}