/*
PROG: pprime
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   22 Mar 2014
// PROLEM ID        :   Prime Palindromes
// DESCRIPTION      :   A program that finds all prime palindromes in the range of 
//                      two supplied numbers a and b (5 <= a < b <= 100,000,000); 
//                      both a and b are considered to be within the range.
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
public class pprime
{
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        Scanner in = new Scanner(new FileReader("pprime.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
       
        //Reads in input
        int a= in.nextInt();
        int b= in.nextInt();
        int minLength=(""+a).length();
        int maxLength=(""+b).length();
        boolean test;
        for(int u=minLength;u<=maxLength;u++)
        {
            String temp;
            int temp2,temp3;
            //1 
            if(u==1)
            for(int g=1 ; g<9;g+=2)
            {
                if(g>=a && g<=b)
                    out.println(g);
            }
            //2
            if(u==2)
            for(int g=1 ; g<10;g+=2)
            {
                test=true;
                temp=""+g+g;
                temp2=Integer.parseInt(temp);
                temp3=(int)Math.sqrt(temp2);
                if(temp2>=a && temp2<=b)
                {
                    for(int x=3;x<=temp3;x++)
                    {
                        if(temp2%x==0)
                        {
                            test=false;
                        }
                    }
                    if(test)
                        out.println(temp2);
                } 
            }
            //3
            if(u==3)
            for(int d1=1 ; d1<10;d1+=2)
            {
                for(int d2=0 ; d2<10; d2++)
                {
                    test=true;
                    temp=""+d1+d2+d1;
                    temp2=Integer.parseInt(temp);
                    temp3=(int)Math.sqrt(temp2);
                    if(temp2>=a && temp2<=b)                 
                    {                     
                        for(int x=3;x<=temp3;x++)                     
                        {                         
                            if(temp2%x==0)                         
                            {                             
                                test=false;                      
                            }                     
                        }                     
                        if(test)                         
                        out.println(temp2);                 
                    } 
                }
            }
            //4
            if(u==4)
            for(int d1=1 ; d1<10;d1+=2)
            {
                for(int d2=0 ; d2<10; d2++)
                {
                    test=true;
                    temp=""+d1+d2+d2+d1;
                    temp2=Integer.parseInt(temp);
                    temp3=(int)Math.sqrt(temp2);
                    if(temp2>=a && temp2<=b)                 
                    {                     
                        for(int x=3;x<=temp3;x++)                     
                        {                         
                            if(temp2%x==0)                         
                            {                             
                                test=false;                         
                            }                     
                        }                     
                        if(test)                         
                        out.println(temp2);                 
                    } 
                }
            }
            //5
            if(u==5)
            for(int d1=1 ; d1<10;d1+=2)
            {
                for(int d2=0 ; d2<10; d2++)
                {
                     for(int d3=0 ; d3<10; d3++)
                    {
                        test=true;
                        temp=""+d1+d2+d3+d2+d1;
                        temp2=Integer.parseInt(temp);
                        temp3=(int)Math.sqrt(temp2);
                        if(temp2>=a && temp2<=b)                 
                        {                     
                            for(int x=3;x<=temp3;x++)                     
                            {                         
                                if(temp2%x==0)  
                                {
                                    test=false;    
                                }      
                            }    
                            if(test)   
                            out.println(temp2); 
                        } 
                    }
                }
            }
            //6
            if(u==6)
            for(int d1=1 ; d1<10;d1+=2)
            {
                for(int d2=0 ; d2<10; d2++)
                {
                    for(int d3=0 ; d3<10; d3++)
                    {
                        test=true;
                        temp=""+d1+d2+d3+d3+d2+d1;
                        temp2=Integer.parseInt(temp);
                        temp3=(int)Math.sqrt(temp2);
                        if(temp2>=a && temp2<=b)   
                        {                 
                            for(int x=3;x<=temp3;x++) 
                            { 
                                if(temp2%x==0)  
                                {
                                    test=false; 
                                }   
                            } 
                            if(test) 
                            out.println(temp2);  
                        } 
                    }
                }
            }
            //7
            if(u==7)
            for(int d1=1 ; d1<10;d1+=2)
            {
                for(int d2=0 ; d2<10; d2++)
                {
                    for(int d3=0 ; d3<10; d3++)
                    {
                        for(int d4=0 ; d4<10; d4++)
                        {
                            test=true;
                            temp=""+d1+d2+d3+d4+d3+d2+d1;
                            temp2=Integer.parseInt(temp);
                            temp3=(int)Math.sqrt(temp2);
                            if(temp2>=a && temp2<=b) 
                            {
                                for(int x=3;x<=temp3;x++)  
                                {
                                    if(temp2%x==0)  
                                    {
                                        test=false; 
                                    }
                                }
                                if(test)    
                                out.println(temp2); 
                            } 
                        }
                    }
                }
            }
            //8
            if(u==8)
            for(int d1=1 ; d1<10;d1+=2)
            {
                for(int d2=0 ; d2<10; d2++)
                {
                    for(int d3=0 ; d3<10; d3++)
                    {
                        for(int d4=0 ; d4<10; d4++)
                        {
                            test=true;
                            temp=""+d1+d2+d3+d4+d4+d3+d2+d1;
                            temp2=Integer.parseInt(temp);
                            temp3=(int)Math.sqrt(temp2);
                            if(temp2>=a && temp2<=b) 
                            {
                                for(int x=3;x<=temp3;x++) 
                                { 
                                    if(temp2%x==0)  
                                    {
                                        test=false;
                                    }
                                }
                                if(test) 
                                out.println(temp2); 
                            } 
                        }
                    }
                }
            }
        }
        /*if(a%2==0)
        {
            for(int g= a+1; a<=b; g+=2)
            {
                boolean test=true;
                int temp2= (int)(Math.sqrt(g));
                for(int o=3;o<=temp2;o++)
                {
                    if(g%o==0)
                    {
                        test=false;
                        break;
                    }
                }
                if(test)
                    out.println(g);
            }
        }
        else
        {
            for(int g= a; g<=b; g+=2)
            {
                if(!(palin[g]))
                    continue;
                boolean test=true;
                int temp2= (int)(Math.sqrt(g));
                for(int o=3;o<=temp2;o++)
                {
                    if(g%o==0)
                    {
                        test=false;
                        break;
                    }
                }
                if(test)
                    out.println(g);
            }
        }*/
        
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
}

