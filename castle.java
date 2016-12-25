/*
PROG: castle
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   2 Jul 2014
// PROLEM ID        :   The Castle
// DESCRIPTION      :   A program to help Farmer John find the room count and sizes
//                      in his castle.
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
import java.lang.*;

public class castle
{
    private static int[] allRooms;
    private static int[][] cast;
    private static int[][] travCast;
    private static boolean[][] searched;
    private static int M;
    private static int N;
    private static int numRooms=0,area=0,tempArea=0;
    public static void main (String[] args) throws IOException, NullPointerException
    {
         //Opening files for input and output
        Scanner in = new Scanner(new FileReader("castle.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
        
        M= in.nextInt();
        N= in.nextInt();
        cast= new int[M][N];
        travCast= new int [M][N];
        searched= new boolean[M][N];
        int room =0;
        allRooms= new int[M*N];
        for(int u=0;u<(M*N);u++)
        {
            allRooms[u]=0;
        }
        for(int u=0;u<N;u++)
        {
            for(int g=0;g<M;g++)
            {
                cast[g][u]=in.nextInt();
                searched[g][u]=false;
            }
        }
        for(int u=0;u<N;u++)
        {
            for(int g=0;g<M;g++)
            {
                if(!searched[g][u])
                {
                    room++;
                    tempArea=0;
                    traverse(g,u,room);
                    area= Math.max(area, tempArea);
                }   
            }
        }
        
        int maxSize=0, temp=0,Xco=0,Yco=0;
        char dir='N';
        //Largest joined room
        //iterate through painted array 
        for(int g=0;g<M;g++)
        {
            for(int u=N-1;u>=0;u--)
            {
                if(u-1>0 && travCast[g][u] != travCast[g][u-1])
                {
                    temp= allRooms[travCast[g][u]-1] + allRooms[travCast[g][u-1]-1]; 
                    if(temp > maxSize)
                    {
                        maxSize=temp;
                        Xco=g+1;
                        Yco=u+1;
                        dir='N';
                    }
                }
                
                if(g<M-1 && travCast[g][u] != travCast[g+1][u])
                {
                   temp= allRooms[travCast[g][u]-1] + allRooms[travCast[g+1][u]-1];
                   if(temp > maxSize)
                   {
                        maxSize=temp;
                        Xco=g+1;
                        Yco=u+1;
                        dir='E';
                   }
                }
            }
        }
        
        

        //Outputs
        out.println(room);
        out.println(area);
        out.println(maxSize);
        out.println(Yco+" "+Xco+" "+dir);
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
    
    private static void traverse(int col, int row, int room)
    {
       
        if(searched[col][row])
            return;
       
       searched[col][row]=true;
       travCast[col][row]=room;
       tempArea++;
       allRooms[room-1]++;
       int c= cast[col][row];
       
       if(c==15)
        return;
       //Go West
       if(c%2==0)
       {
           traverse(col-1,row,room);
       }
       
       //Go East
       if(!(c==4 || c==5 || c==6 || c==7 || c>11))
       {
           traverse(col+1,row,room);
       }
       
       //Go South
       if(c<8)
       {
           traverse(col,row+1,room);
       }
       
       //Go North
       if(!(c==2 || c==3 || c==6 || c==7 || c==10 || c==11 || c==14 ))
       {
           traverse(col,row-1,room);
       }
       
    }
}