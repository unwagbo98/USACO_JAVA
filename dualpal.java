/*
PROG: dualpal
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   26 Oct 2013
// PROLEM ID        :   Dual Palindromes
// DESCRIPTION      :   A program  that reads two numbers (N and S)
//                      and then finds and prints (in base 10) the first N numbers 
//                      strictly greater than S that are palindromic when written in 
//                      two or more number bases (2 <= base <= 10).
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
public class dualpal
{
    private static char[] digits = {'0','1','2','3','4','5','6','7','8','9','A','B','C',
        'D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        BufferedReader in = new BufferedReader(new FileReader("dualpal.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        //Reads in input
        String input = in.readLine();
        StringTokenizer tk= new StringTokenizer(input);
        int N= Integer.parseInt((tk.nextToken())); 
        int S= Integer.parseInt((tk.nextToken()));
        int count=0;
        String[] temp= new String[9];
        String tempString= new String();
        S+=1;
        //Repeat the check untill N is reached
        while(count<N)
        {
            //Array of possible palindromes
            for(int Base=2;Base<11;Base++)
            {
                temp[Base-2]=solve(S, Base);
            }
            int counter=0;
            for(int u=0;u<9;u++)
            {
                tempString="";
                //reverses the string
                for(int g=0;g<temp[u].length();g++)
                {
                    tempString+=temp[u].charAt(temp[u].length()-1-g);
                }
                //checks for palindrome
                if(temp[u].equals(tempString))
                    counter++;
                
            }
            if(counter>1)
            {
                out.println(S);
                count++;
            }
            S++;
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

