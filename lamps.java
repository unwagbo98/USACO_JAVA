/*
PROG: lamps
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   7 Jul 2014
// PROLEM ID        :   Party lampss
// DESCRIPTION      :   A program to determine all the possible final configurations of the N lamps that 
//                      are consistent with the given information, without repetitions.
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
import java.lang.*;

public class lamps
{
    private static int N, C, numOn=0, numOff=0;
    private static int[] on, off;
    private static boolean[][][][] searched;
    private static boolean finalTest;
    private static ArrayList<String> list;
    
    public static void main (String[] args) throws IOException, NullPointerException
    {
         //Opening files for input and output
        Scanner in = new Scanner(new FileReader("lamps.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));
        
        N=in.nextInt();
        C= in.nextInt();
        searched = new boolean[2][2][2][2];
        int temp=in.nextInt();
        list = new ArrayList<String>();
        on= new int[N];
        off= new int[N];
        finalTest=false;
        while(temp!=-1)
        {
            on[numOn]=temp;
            numOn++;
            temp=in.nextInt();
        }
        temp=in.nextInt();
        while(temp!=-1)
        {
            off[numOff]=temp;
            numOff++;
            temp=in.nextInt();
        }
        
        int[] digits={1,1,1,1,1,1};
        
        for(int s1=0;s1<2;s1++)
        {
            for(int s2=0;s2<2;s2++)
            {
                for(int s3=0;s3<2;s3++)
                {
                    for(int s4=0;s4<2;s4++)
                    {
                        solve(digits,s1,s2,s3,s4);
                    }
                }
            }
        }
        
        if(finalTest)
        {
            Set<String> set= new TreeSet<String>(list);
            
            Iterator it= set.iterator();
            
            while(it.hasNext())
            {
                String ans= it.next()+"";
                for(int u=0;u<N;u++)
                {
                    out.print(ans.charAt(u%6));
                }
                out.println();
            }
        }
        else
        {
            out.println("IMPOSSIBLE");
        }
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
    
    private static void solve(int[] digits,int s1,int s2,int s3,int s4)
    {
        if(searched[s1][s2][s3][s4])
        {
            return;
        }
        else
        {
            searched[s1][s2][s3][s4]=true;
        }
        
        if(s1+s2+s3+s4>C)
        {
            return;
        }
        
        
        //Switch 1
        if(s1==1)
            for(int u=0;u<6;u++)
            {
                if(digits[u]==0)
                {
                    digits[u]=1;
                }
                else
                {
                    digits[u]=0;
                }
            }
        
        //switch 2
        if(s2==1)
            for(int u=0;u<6;u+=2)
            {
                if(digits[u]==0)
                {
                    digits[u]=1;
                }
                else
                {
                    digits[u]=0;
                }
            }
        
        //switch 3
        if(s3==1)
            for(int u=1;u<6;u+=2)
            {
                if(digits[u]==0)
                {
                    digits[u]=1;
                }
                else
                {
                    digits[u]=0;
                }
            }
        
        //switch 4
        if(s4==1)
            for(int u=0;u<6;u+=3)
            {
                if(digits[u]==0)
                {
                    digits[u]=1;
                }
                else
                {
                    digits[u]=0;
                }
            }
            
        boolean test=true;
        for(int u=0;u<numOn;u++)
        {
            if(digits[(on[u]-1)%6]==0)
            {
                test=false;
                break;
            }
        }
        for(int u=0;u<numOff;u++)
        {
            if(digits[(off[u]-1)%6]==1)
            {
                test=false;
                break;
            }
        }
        if(test)
        {
            list.add(""+digits[0]+digits[1]+digits[2]+digits[3]+digits[4]+digits[5]);
            finalTest=true;
        }
    }

}
