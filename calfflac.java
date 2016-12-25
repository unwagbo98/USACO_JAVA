/*
PROG: calfflac
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   5 Nov 2013
// PROLEM ID        :   Claf flac
// DESCRIPTION      :   A program that will Find the largest palindrome 
//						in a string no more than 20,000 characters long.
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
import java.lang.*;
public class calfflac
{
    public static void main (String[] args) throws IOException, NullPointerException
    {
         //Opening files for input and output
        Scanner in = new Scanner(new FileReader("calfflac.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("calfflac.out")));
        //Reads in input
        String Input=new String();
		while(in.hasNextLine())
        {
            Input += in.nextLine()+"$";
        }
        String Sentence = Input.toUpperCase();
        int N= Input.length();
        int[] counter= new int[N];
        int[][] difference= new int[N][2];
        for(int u=1;u<N-1;u++)
        {
            // g goes backwards, o goes forwards 
            int g=u;
            int o=u+1;
            counter[u]=0;
            if(Sentence.charAt(u)>'@' && Sentence.charAt(u)<'[' )
            {
                while(o<N &&!(Sentence.charAt(o)>'@' && Sentence.charAt(o)<'[' ))
                {
                    o++;
                }
				//Even Length
                if(o<N && Sentence.charAt(u)==Sentence.charAt(o)) 
                {
                    while(o<N && g>-1 &&Sentence.charAt(g)==Sentence.charAt(o))
                    {
                        difference[u][0]=o;
                        difference[u][1]=g;
                        g-=1;
                        o++;
                        counter[u]+=2;
                        while(o<N && !(Sentence.charAt(o)>'@' && Sentence.charAt(o)<'[' ))
                        {
                            o++;
                        }
                        while(g>-1 && !(Sentence.charAt(g)>'@' && Sentence.charAt(g)<'[' ))
                        {
                            g-=1;
                        }
                    }
                }
				//Odd Length
                else
                {
                    counter[u]=1;
					g-=1;
                    while(o<N && !(Sentence.charAt(o)>'@' && Sentence.charAt(o)<'[' ))
                    {
                        o++;
                    }
                    while(g>-1 && !(Sentence.charAt(g)>'@' && Sentence.charAt(g)<'[' ))
                    {
                        g-=1;
                    }
                    while(o<N && g>-1 &&Sentence.charAt(g)==Sentence.charAt(o))
                    {
                        difference[u][0]=o;
                        difference[u][1]=g;
                        g-=1;
                        o++;
                        counter[u]+=2;
                        while(o<N && !(Sentence.charAt(o)>'@' && Sentence.charAt(o)<'[' ))
                        {
                            o++;
                        }
                        while(g>-1 && !(Sentence.charAt(g)>'@' && Sentence.charAt(g)<'[' ))
                        {
                            g-=1;
                        }
                    }
                }
            }
        }
        
        //Find Max Counter
        counter[0]=0;
        counter[N-1]=0;
        difference[0][0]=0;
        difference[N-1][0]=0;
        difference[0][1]=0;
        difference[N-1][1]=0;
        int maxCounter=0;
        for(int u=0;u<N;u++)
        {
            if(maxCounter<counter[u])
                maxCounter=counter[u];
        }
        //Prints Results
        boolean test= false;
        if(maxCounter%2==0)
            test=true;
        out.println(maxCounter);        
        for(int u=0;u<N;u++)
        {
            if(counter[u]==maxCounter)
            {
                if(test)
                {
                    for(int g=difference[u][1];g<difference[u][0]+1;g++)
                    {
                        if(Input.charAt(g)=='$')
                            out.print("\n");
                        else
                            out.print(Input.charAt(g));
                    }
                    out.print("\n");
                    break;
                }
                else
                {
                    for(int g=difference[u][1];g<difference[u][0]+1;g++)
                    {
                        if(Input.charAt(g)=='$')
                            out.print("\n");
                        else
                            out.print(Input.charAt(g));
                    }
                    out.print("\n");
                    break;
                }
            }
        }
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
}
