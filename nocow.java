/*
PROG: nocow
ID: unwagbo
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   5 Nov 2013
// PROLEM ID        :   Claf flac
// DESCRIPTION      :   A program that will Find the largest palindrome 
//                      in a string no more than 20,000 characters long.
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
import java.lang.*;
public class nocow
{
    public static void main (String[] args) throws IOException, NullPointerException
    {
         //Opening files for input and output
        Scanner in = new Scanner(new FileReader("nocow.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("nocow.out")));
        int N=in.nextInt();
        int K=in.nextInt();
        int ignore= 19;
        int length;
        String Correct=in.nextLine(); 
       
        //Reads in input
        String[] Input=new String[N];
        String[] Adjectives=new String[N];
        for(int u=0;u<N;u++)
        {
           Input[u]=in.nextLine();
           length=Input[u].length()-5;
           Adjectives[u]="";
            for(int o=ignore;o<length;o++)
            {
                Adjectives[u]+= Input[u].charAt(o);
            }
        }
        int numWords=1;
        for(int u=0;u<Adjectives[0].length();u++)
        {
            if(Adjectives[0].charAt(u)==' ')
                numWords++;
        }
        String[] MaxCombos= new String[(int)(Math.pow(N,numWords))];
        int lineNum=0;
        int c=0;
        int x=0;
        while(x<(int)(Math.pow(N,numWords)))
        {
            for(int u=0;u<N;u++)
            {
              String[] temp=  Adjectives[lineNum%N].split(" ");
              MaxCombos[x]+= temp[u]+" ";
              x++;
              lineNum++;
            }
            
            c++;
        }
        Arrays.sort(MaxCombos);
        for(int u=0;u<(int)(Math.pow(N,numWords));u++)
        {
            System.out.println(u+" "+MaxCombos[u]);
        }
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
}
