/*
PROG: transform
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   17 Oct 2013
// PROLEM ID        :   Transformations
// DESCRIPTION      :   A program that will recognize the minimum transformation that 
//                      has been applied to the original pattern 
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
public class transform
{
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        BufferedReader in = new BufferedReader(new FileReader("transform.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        
         StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        //Reads in input
        int N= Integer.parseInt(tokenizer.nextToken());
        char [][] shape= new char[N][N];
        char [][] shape2= new char[N][N];
        String temp = new String();
        for(int u=0;u<N;u++)
        {
           temp= in.readLine(); 
           shape[u]= temp.toCharArray(); 
            
        }
        for(int u=0;u<N;u++)
        {
           temp= in.readLine(); 
           shape2[u]= temp.toCharArray(); 
            
        }
       
      
       int[] checks= new int[6]; 
       int[] TempChecks=new int[N];
       // Test #1 90 degree rotation
       
       for(int u=0;u<N;u++)
        {
            for(int g=0;g<N;g++)
            {
               if(shape[u][g]== shape2[g][N-1-u])
                TempChecks[u]=1;
               else
               {
                   TempChecks[u]=7;
                   g=N;
               }
               
            }   
        }
        
        checks[0]= TempChecks[0];
        for (int u=0;u<TempChecks.length-1;u++) 
        {
            if(checks[0]<TempChecks[u])
                checks[0]=TempChecks[u];
        }
        
        //Test #2 180 degree rotation
        TempChecks=new int[N];
        for(int u=0;u<N;u++)
        {
            for(int g=0;g<N;g++)
            {
               if(shape[u][g]== shape2[N-1-u][N-1-g])
                TempChecks[u]=2;
               else
               {
                   TempChecks[u]=7;
                   g=N;
               }
               
            }   
        }
        
        checks[1]= TempChecks[0];
        for (int u=0;u<TempChecks.length;u++) 
        {
            if(checks[1]<TempChecks[u])
                checks[1]=TempChecks[u];
        }
        
        // Test #3 270 degree rotation
        TempChecks=new int[N];
        for(int u=0;u<N;u++)
        {
            for(int g=0;g<N;g++)
            {
               if(shape[u][g]== shape2[N-1-g][u])
                TempChecks[u]=3;
               else
               {
                   TempChecks[u]=7;
                   g=N;
               }
               
            }   
        }
        
        checks[2]= TempChecks[0];
        for (int u=0;u<TempChecks.length;u++) 
        {
            if(checks[2]<TempChecks[u])
                checks[2]=TempChecks[u];
        }
        // Test #4 Reflection
        TempChecks=new int[N];
        for(int u=0;u<N;u++)
        {
            for(int g=0;g<N;g++)
            {
               if(shape[u][g]== shape2[u][N-1-g])
                TempChecks[u]=4;
               else
               {
                   TempChecks[u]=7;
                   g=N;
               }
               
            }   
        }
        checks[3]= TempChecks[0];
        for (int u=0;u<TempChecks.length;u++) 
        {
            if(checks[3]<TempChecks[u])
                checks[3]=TempChecks[u];
        }
        // Test #5 Reflection Combination
        char[][] ReflectShape= new char[N][N];
        for(int u=0;u<N;u++)
        {
            for(int g=0;g<N;g++)
            {
              ReflectShape[u][g]= shape[u][N-1-g];
            }   
        }
       
        TempChecks=new int[N];
        int[] FiveTempChecks=new int[3];
       // Test #1 90 degree rotation on ReflectShape
       
       for(int u=0;u<N;u++)
        {
            for(int g=0;g<N;g++)
            {
               if(ReflectShape[u][g]== shape2[g][N-1-u])
                TempChecks[u]=5;
               else
               {
                   TempChecks[u]=7;
                   g=N;
               }
               
            }   
        }
        
        FiveTempChecks[0]= TempChecks[0];
        for (int u=0;u<TempChecks.length;u++) 
        {
            if(FiveTempChecks[0]<TempChecks[u])
                FiveTempChecks[0]=TempChecks[u];
        }
        
        //Test #2 180 degree rotation on ReflectShape
       TempChecks=new int[N];
        for(int u=0;u<N;u++)
        {
            for(int g=0;g<N;g++)
            {
               if(ReflectShape[u][g]== shape2[N-1-u][N-1-g])
                TempChecks[u]=5;
               else
               {
                   TempChecks[u]=7;
                   g=N;
               }
               
            }   
        }
        
        FiveTempChecks[1]= TempChecks[0];
        for (int u=0;u<TempChecks.length;u++) 
        {
            if(FiveTempChecks[1]<TempChecks[u])
                FiveTempChecks[1]=TempChecks[u];
        }
        
        // Test #3 270 degree rotation on ReflectShape
        TempChecks=new int[N];
        for(int u=0;u<N;u++)
        {
            for(int g=0;g<N;g++)
            {
               if(ReflectShape[u][g]== shape2[N-1-g][u])
                TempChecks[u]=5;
               else
               {
                   TempChecks[u]=7;
                   g=N;
               }
               
            }   
        }
        
        FiveTempChecks[2]= TempChecks[0];
        for (int u=0;u<TempChecks.length;u++) 
        {
            if(FiveTempChecks[2]<TempChecks[u])
                FiveTempChecks[2]=TempChecks[u];
        }
        

        checks[4]= FiveTempChecks[0];
        for (int u=0;u<FiveTempChecks.length;u++) 
        {
            if(checks[4]>FiveTempChecks[u])
                checks[4]=FiveTempChecks[u];
        }
        
         //Test #6 Same Shape
        TempChecks=new int[N];
        for(int u=0;u<N;u++)
        {
            for(int g=0;g<N;g++)
            {
               if(shape[u][g]== shape2[u][g])
                TempChecks[u]=6;
               else
               {
                   TempChecks[u]=7;
                   g=N;
               }
               
            }   
        }
        
        checks[5]= TempChecks[0];
        for (int u=0;u<TempChecks.length;u++) 
        {
            if(checks[5]<TempChecks[u])
                checks[5]=TempChecks[u];
        } 
        
        //Find lowest test used
        int answer= checks[0];
        for (int u=0;u<checks.length;u++) 
        {
            if(answer>checks[u])
                answer=checks[u];
        } 
        
        
        //Prints Results
        out.println(answer); 
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
}
