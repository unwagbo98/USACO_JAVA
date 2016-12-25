/*
PROG: ariprog
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   24 Nov 2013
// PROLEM ID        :   Arithmetic Progressions
// DESCRIPTION      :   A program that finds all arithmetic progressions 
//                      of length n in the set S of bisquares.
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
import java.lang.*;
public class ariprog
{
    public static void main (String[] args) throws IOException, NullPointerException
    {
         //Opening files for input and output
        Scanner in = new Scanner(new FileReader("ariprog.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
        
        int N=in.nextInt();
        int M=in.nextInt();
        int size=M+1;
        int[] biSquare= new int[(size*size)+(size*size)];
        //Get All biSquares in Range
        for(int u:biSquare)
        {
            biSquare[u]=0;
        }
        for(int p=0;p<size;++p)
        {
            for(int q=0;q<size;++q)
            {
                biSquare[(p*p)+(q*q)]=(p*p)+(q*q);
            }
        }
        
        //Test all sequences
        int maxAdd=biSquare[(M*M)+(M*M)]/(N-1);
        boolean finalTest=true;
        int numSequences=(M*M)+(M*M);
        for(int g=1;g<=maxAdd;++g)
        {
            
            for(int u=0;u<numSequences;++u)
            {
                if(biSquare[u]!=u)
                    continue;
                int position=u;
                int counter=0;
                if(biSquare[u]+((N-1)*g)>biSquare[numSequences])
                    break;
                for(int o=0;o<N;++o)
                {
                    if(biSquare[position+(o*g)]==position+(o*g))
                    {
                        counter++;
                    }
                    else
                        break;
                }
                if(counter >= N)
                {
                    finalTest=false;
                    out.println(biSquare[u]+" "+g);
                }
            }
        }
        //Output
        if(finalTest)
            out.println("NONE");
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
}