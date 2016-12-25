/*
PROG: gift1
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   26 Oct 2013
// PROLEM ID        :   Greedy Gift Givers
// DESCRIPTION      :   A program to determine how much more (or less) 
//                      each person in the group gives than they receive. 
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
public class gift1
{
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        BufferedReader in = new BufferedReader(new FileReader("gift1.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
       
        //Reads in input
        int N= Integer.parseInt(in.readLine());
        int[] Balance = new int[N];
        String[] Names= new String[N];
        for(int u=0; u<N;u++)
        {
            Names[u]=in.readLine();
        }
        String Giver=new String();
        String Reciever=new String();
        String temp=new String();
        String[] Split=new String[2];
        int Amount, S;
        for(int u=0; u<N;u++)
        {
            Giver=in.readLine();
            temp=in.readLine();
            Split=temp.split("\\s+");
            Amount=Integer.parseInt(Split[0]);
            S=Integer.parseInt(Split[1]);
            for(int g=0;g<N;g++)
            {
                if((Giver.equals(Names[g]))&& (S!=0))
                    Balance[g]-=Amount-(Amount%S);
            
            }
            for(int g=0;g<S;g++)
            {
                Reciever=in.readLine();
                for(int o=0;o<N;o++)
                {
                    if((Reciever.equals(Names[o]))&& (S!=0))
                        Balance[o]+=(Amount/S);
                
                }
            }
        }
        for(int u=0; u<N;u++)
        {
            out.println(Names[u]+" "+Balance[u]);
        }
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
}

