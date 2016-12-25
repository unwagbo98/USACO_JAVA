/*
PROG: milk3
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   22 Nov 2013
// PROLEM ID        :   milk3
// DESCRIPTION      :   A program that will find a minimal sequence of moves 
//                      to return all the dials to 12 o'clock. 
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
import java.lang.*;
public class milk3
{
    public static int A,B,C,Max;
    public static boolean[] Solution= new boolean[21];
    public static void main (String[] args) throws IOException
    {

         //Opening files for input and output
        Scanner in = new Scanner(new FileReader("milk3.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
        
        A=in.nextInt();
        B=in.nextInt();
        C=in.nextInt();
        
        Max= 20*20*20;
        /*for(int u=0;u<C;++u)
        {
            Solution[u]=false;
        }*/
        for(int a=0;a<=A;++a)
        {
            for(int b=0;b<=B;++b)
            {
                solve(a,b,C);
            }
        }
        
        for(int u=0;u<=C;++u)
        {
            if(Solution[u])
                out.print(u+" ");
        }
        out.println();
        
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
    public static int x=0;
    //Method finds all possible bucket 
    public static void solve(int Avol,int Bvol,int Cvol)
    {
        System.out.println(x+". "+Avol+" "+Bvol+" "+Cvol);
        ++x;
        if(x>=Max){
            System.out.println(x);
            return;
        }
        //System.out.println(Avol+" "+Bvol+" "+Cvol);
        if (Avol==0)
            Solution[Cvol]=true;
        
        //Pour into the empty bucket
        
        //If two buckets are empty
        if((Avol==0&&Bvol==0)||(Avol==0&&Cvol==0)||(Cvol==0&&Bvol==0))
        {
            //If A is not empty
            if(Avol>0)
            {
              
               
               if(Avol>0)
                    solve((Avol+Bvol-B),Bvol+(Avol-(Avol+Bvol-B)),Cvol);//A Into B
               if(Avol>0)
                    solve((Avol+Cvol-C),Bvol,Cvol+(Avol-(Avol+Cvol-C)));//A Into C
            }
            //If B is not Empty
            if(Bvol>0)
            {
                if(Bvol>0)
                    solve(Avol+(Bvol-(Bvol+Avol-A)),(Bvol+Avol-A),Cvol);//B Into A
                if(Bvol>0)
                    solve(Avol,(Bvol+Cvol-C),Cvol+(Bvol-(Bvol+Cvol-C)));//B Into C
            }
            //If C is not Empty
            if(Cvol>0)
            {
                if(Cvol>0)
                    solve(Avol+(Cvol-(Cvol+Avol-A)),Bvol,(Cvol+Avol-A));//C Into A
                if(Cvol>0)
                    solve(Avol,Bvol+(Cvol-(Cvol+Bvol-B)),(Cvol+Bvol-B));//C Into B
            }
        }
        else
        {
                        //If A is empty
            if(Avol==0)
            {
               if(Bvol>0)
                    solve(Avol+(Bvol-(Bvol+Avol-A)),(Bvol+Avol-A),Cvol);//B Into A
               if(Cvol>0)
                    solve(Avol+(Cvol-(Cvol+Avol-A)),Bvol,(Cvol+Avol-A));//C Into A
               
            }
            //If B Empty
            if(Bvol==0)
            {
                if(Avol>0)
                    solve((Avol+Bvol-B),Bvol+(Avol-(Avol+Bvol-B)),Cvol);//A Into B
                if(Cvol>0)
                    solve(Avol,Bvol+(Cvol-(Cvol+Bvol-B)),(Cvol+Bvol-B));//C Into B
            }
            //If C Empty
            if(Cvol==0)
            {
                if(Avol>0)
                    solve((Avol+Cvol-C),Bvol,Cvol+(Avol-(Avol+Cvol-C)));//A Into C
                if(Bvol>0)
                    solve(Avol,(Bvol+Cvol-C),Cvol+(Bvol-(Bvol+Cvol-C)));//B Into C
            }

        }
    }
}