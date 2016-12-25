/*
PROG: namenum
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
import java.lang.*;
public class namenum
{
    public static void main (String[] args) throws IOException, NullPointerException
    {
        String[] Names= new String[5000];
        int N=0;
        String Temp=new String();
         //Opening files for input and output
        BufferedReader in = new BufferedReader(new FileReader("namenum.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        String Input = in.readLine();
        BufferedReader dict = new BufferedReader(new FileReader("dict.txt"));
            for(int u=0;u<5000;u++)
            {
                Temp= dict.readLine();
                if(Temp==null)
                {
                    u=5000;
                   
                }
                    
                else if(Temp.length()== Input.length())
                {
                    Names[N]= Temp;
                    N++;
                }
                    
            }
        //Reads in input
        String[] NumList = new String[N];
        for(int u=0; u<N;u++)
        {
            NumList[u]=Names[u];
        }
       
        for(int u=0;u<N;u++)
        {
            for(int g=0;g<Input.length();g++)
            {
                if((Names[u].charAt(g)=='A')||(Names[u].charAt(g)=='B')||(Names[u].charAt(g)=='C'))
                {
                    NumList[u]= NumList[u].replace((NumList[u].charAt(g)),'2');
                }
               else if((Names[u].charAt(g)=='D')||(Names[u].charAt(g)=='E')||(Names[u].charAt(g)=='F'))
                {
                    NumList[u]= NumList[u].replace((NumList[u].charAt(g)),'3');
                }
                else if((Names[u].charAt(g)=='G')||(Names[u].charAt(g)=='H')||(Names[u].charAt(g)=='I'))
                {
                    NumList[u]= NumList[u].replace((NumList[u].charAt(g)),'4');
                }
                else if((Names[u].charAt(g)=='J')||(Names[u].charAt(g)=='K')||(Names[u].charAt(g)=='L'))
                {
                    NumList[u]= NumList[u].replace((NumList[u].charAt(g)),'5');
                }
                else if((Names[u].charAt(g)=='M')||(Names[u].charAt(g)=='N')||(Names[u].charAt(g)=='O'))
                {
                    NumList[u]= NumList[u].replace((NumList[u].charAt(g)),'6');
                }
                else if((Names[u].charAt(g)=='P')||(Names[u].charAt(g)=='R')||(Names[u].charAt(g)=='S'))
                {
                    NumList[u]= NumList[u].replace((NumList[u].charAt(g)),'7');
                }
                else if((Names[u].charAt(g)=='T')||(Names[u].charAt(g)=='U')||(Names[u].charAt(g)=='V'))
                {
                    NumList[u]= NumList[u].replace((NumList[u].charAt(g)),'8');
                }
                else if((Names[u].charAt(g)=='W')||(Names[u].charAt(g)=='X')||(Names[u].charAt(g)=='Y'))
                {
                    NumList[u]= NumList[u].replace((NumList[u].charAt(g)),'9');
                }
                    
            }
        }
        int counter=0;
        for(int u=0;u<N;u++)
        {
            if(NumList[u].equals(Input))
            {
                counter++;
                break;
            }
        }
        //Prints Results
        if(counter==0)
            out.println("NONE");
        else
            for(int u=0;u<N;u++)
            {
                if(NumList[u].equals(Input))
                   out.println(Names[u]);
            }  
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
}
