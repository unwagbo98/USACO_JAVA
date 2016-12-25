/*
PROG: crypt1
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   4 Nov 2013
// PROLEM ID        :   Prime Cryptarithm
// DESCRIPTION      :   A program that will find all solutions to the cryptarithm 
//						for any subset of digits from the set {1,2,3,4,5,6,7,8,9}.
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
import java.lang.*;
public class crypt1
{
    public static void main (String[] args) throws IOException, NullPointerException
    {
        String[] Names= new String[5000];
        int N=0;
        String Temp=new String();
         //Opening files for input and output
        BufferedReader in = new BufferedReader(new FileReader("crypt1.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
		N=Integer.parseInt(in.readLine());
		String[] Digits= new String[N];
		int counter=0;
		StringTokenizer tk = new StringTokenizer(in.readLine());
		
		for(int u=0;u<N;++u)
		{
			Digits[u]=tk.nextToken();
		}
		Arrays.sort(Digits);
		//Get top Number
		String[] Top= new String[N*N*N];
		int c=0;
		for(int u=0;u<N;++u)
		{
			for(int g=0;g<N;++g)
			{
				for(int o=0;o<N;++o)
				{
					Top[c]=Digits[u]+Digits[g]+Digits[o];
					c++;
				}
			}
		}
		//Get middle Number
		String[] Middle= new String[N*N];
		c=0;
		for(int u=0;u<N;++u)
		{
			for(int g=0;g<N;++g)
			{
				Middle[c]=Digits[u]+Digits[g];
				c++;
			}
		}
		//Get bottom Number
		int[] Bottom= new int[N*N*N*N];
		c=0;
		for(int u=0;u<N;++u)
		{
			for(int g=0;g<N;++g)
			{
				for(int o=0;o<N;++o)
				{
					for(int h=0;h<N;++h)
					{
						Bottom[c]=Integer.parseInt(Digits[u]+Digits[g]+Digits[o]+Digits[h]);
						c++;
					}
				}
			}
		}
		
		//Get Answer
		int temp;
		int pp1, pp2;
		boolean[] test={false,false};
		for(int u=0;u<(N*N*N);++u)
		{
			for(int g=0;g<(N*N);++g)
			{
				test[0]=false;
				test[1]=false;
				pp1=((Integer.parseInt(Top[u]))*(Middle[g].charAt(0)-'0'));
				pp2=((Integer.parseInt(Top[u]))*(Middle[g].charAt(1)-'0'));				
				if(pp2<1000&&((Integer.parseInt(Top[u]))*Integer.parseInt(Middle[g]))<10000)
				{
					for(int o=0;o<N*N*N;++o)
					{
						
						if(pp1==Integer.parseInt(Top[o]))
						{
							test[0]=true;
						}	
						if(pp2==Integer.parseInt(Top[o]))
						{
							test[1]=true;
						}
						if(test[0]&&test[1])
						{
							break;
						}	
					}
					if(test[0]&&test[1])
					{
						temp=(((Integer.parseInt(Top[u]))*(Middle[g].charAt(1)-'0'))+(10*(Integer.parseInt(Top[u]))*(Middle[g].charAt(0)-'0'))); 
						for(int h=0;h<N*N*N*N;++h)
						{
							if(temp==Bottom[h])
							{
								counter++;
								break;
							}	
						}
					}
				}
			}
		}
			
		//Output
		out.println(counter);
		//Ensures Program ends properly
		out.close();
		System.exit(0);
	}
}