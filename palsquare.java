/*
PROG: palsquare
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   26 Oct 2013
// PROLEM ID        :   Palindromic Squares(unsing Mod)
// DESCRIPTION      :   A program that will find palindromes in different bases 
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
public class palsquare
{
    private static char[] digits = {'0','1','2','3','4','5','6','7','8','9','A','B','C',
        'D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        BufferedReader in = new BufferedReader(new FileReader("palsquare.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
       
        //Reads in input
        int Base= Integer.parseInt(in.readLine());
        int N= 300; 
        int Square;
        String bSquare= new String();
        String temp= new String();
        String output= new String();
        //Repeat the check for all 300 numbers
        for(int u=1; u <=N;u++)
        {
            temp="";
            Square= u*u;
            bSquare=solve(Square, Base);
            //Make a reverse string of bSquare
            for(int g=0;g<bSquare.length();g++)
            {
                temp+=bSquare.charAt(bSquare.length()-1-g);
            }
            output= solve(u, Base);
            //checks for palindromes   
            if(bSquare.equals(temp))
            out.println(output.toUpperCase()+" "+bSquare.toUpperCase()); 
        }

        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
    
    public static String solve(int num, int base)
    {
        String ans ="";
        int max=20;
        for(int u=20; u>=0;u--)
        {
            if(Math.pow(base,u)<=num)
            {
                max=u;
                break;
            }
           
        }
        
        for(int u=max;u>=0;u--)
        {
            ans+="0";
        }
        int tempNum=num;
        char[] tempDigits;
        for(int x= max; x>=0;x--)
        {
            if(Math.pow(base,x)<=tempNum)
            {
                int digit= (int)(tempNum/Math.pow(base,x));
                tempDigits=ans.toCharArray();
                tempDigits[max-x]=digits[digit];
                ans= String.valueOf(tempDigits);
                tempNum =tempNum% (int)Math.pow(base,x);
            }
        }
        return ans;
    }
}

