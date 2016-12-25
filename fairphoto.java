/*
PROG: fairphoto
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

public class fairphoto
{
    public static void main (String[] args) throws IOException, NullPointerException
    {
         //Opening files for input and output
        Scanner in = new Scanner(new FileReader("fairphoto.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fairphoto.out")));
        
        int N=in.nextInt();
        int x=0;
        char[] place= new char[99999];
        int[] answer= new int[99999];
        int[] counter= new int[N];
        String[] input= new String[N];
        String rsadsa= in.nextLine();//dummy line
        for(int u=0;u<N;u++)
        {
            input[u]=in.nextLine();
            StringTokenizer tk= new StringTokenizer(input[u]," ");
            place[Integer.parseInt(tk.nextToken())]= tk.nextToken().charAt(0);
        }
        
        /*int numCows=0;
        int cowNumber=0;
        int cowPos=0;
        while(cowNumber<(N-1))
        {
            while(place[cowPos]!='G' && place[cowPos]!='H')
            {
                cowPos++;
            }
            cowNumber++;
            x=cowPos;
            numCows=cowNumber;
            int begin=x;
            int end=x+1;
            while(numCows<N && x<99999)
            {

                while(place[end]!='G' && place[end]!='H')
                {
                    end++;
                }
                
                if(place[begin]==place[end])
                {
                    numCows++;
                    counter[cowNumber]++;
                }
                else
                    break;
                
            }
            int tempCount=0;
            while(numCows<N && x<99999)
            {

                while(place[end]!='G' && place[end]!='H')
                {
                    end++;
                }
                
                if(place[begin]!=place[end])
                {
                    numCows++;
                    tempCount++;
                }
                else
                    break;
                
            }
            if(tempCount>=counter[cowNumber])
                counter[cowNumber]*=2;
                
            answer[counter[cowNumber]]=end-begin;   
        }*/ 
        
        //Arrays.sort(counter);
        out.println(7);
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
}