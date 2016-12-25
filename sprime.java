/*
PROG: sprime
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   22 Mar 2014
// PROLEM ID        :   Superprime Rib
// DESCRIPTION      :   A program that accepts a number N 1 <=N<=8 of ribs 
//                      and prints all the superprimes of that length. 
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
public class sprime
{
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        Scanner in = new Scanner(new FileReader("sprime.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
       
        int[] first={2,3,5,7};
        int[] other={1,3,7,9};
        //Reads in input
        int N= in.nextInt();
        int min= (int)Math.pow(10,N-1)+1;
        int max= (int)Math.pow(10,N);
        String temp;
        if(N==1)
        for(int u=0;u<4;u++)
        {
            out.println(first[u]);
        }
        if(N==2)
        for(int d1=0;d1<4;d1++)
        {
            for(int d2=0;d2<4;d2++)
            {
                boolean ftest=true;
                temp=""+first[d1]+other[d2];
                String temp2="";
                int temp3,temp4;
                for(int g=0;g<N;g++)
                {
                    boolean test=false;
                    temp2+=temp.charAt(g);
                    temp3=Integer.parseInt(temp2);
                    temp4=(int)Math.sqrt(temp3);
                    if(temp3==1)
                    {
                        test=true;
                    }
                    for(int o=2; o<=temp4;o++)
                    {
                        if(temp3%o==0)
                        {
                            test=true;
                            break;
                        }    
                    }
                    if(test)
                    {
                        ftest=false;
                        break;
                    }
                    
                }
                if(ftest)
                {
                    out.println(temp);
                }
            }
        }
        
        if(N==3)
        for(int d1=0;d1<4;d1++)
        {
            for(int d2=0;d2<4;d2++)
            {
                for(int d3=0;d3<4;d3++)
                {
                    boolean ftest=true;
                    temp=""+first[d1]+other[d2]+other[d3];
                    String temp2="";
                    int temp3,temp4;
                    for(int g=0;g<N;g++)
                    {
                        boolean test=false;
                        temp2+=temp.charAt(g);
                        temp3=Integer.parseInt(temp2);
                        temp4=(int)Math.sqrt(temp3);
                        if(temp3==1)
                        {
                            test=true;
                        }
                        for(int o=2; o<=temp4;o++)
                        {
                            if(temp3%o==0)
                            {
                                test=true;
                                break;
                            }    
                        }
                        if(test)
                        {
                            ftest=false;
                            break;
                        }
                        
                    }
                    if(ftest)
                    {
                        out.println(temp);
                    }
                }
            }
        }
        if(N==4)
        for(int d1=0;d1<4;d1++)
        {
            for(int d2=0;d2<4;d2++)
            {
                for(int d3=0;d3<4;d3++)
                {
                    for(int d4=0;d4<4;d4++)
                    {
                        boolean ftest=true;
                        temp=""+first[d1]+other[d2]+other[d3]+other[d4];
                        String temp2="";
                        int temp3,temp4;
                        for(int g=0;g<N;g++)
                        {
                            boolean test=false;
                            temp2+=temp.charAt(g);
                            temp3=Integer.parseInt(temp2);
                            temp4=(int)Math.sqrt(temp3);
                            if(temp3==1)
                            {
                                test=true;
                            }
                            for(int o=2; o<=temp4;o++)
                            {
                                if(temp3%o==0)
                                {
                                    test=true;
                                    break;
                                }    
                            }
                            if(test)
                            {
                                ftest=false;
                                break;
                            }
                            
                        }
                        if(ftest)
                        {
                            out.println(temp);
                        }
                    }
                }
            }
        }
        if(N==5)
        for(int d1=0;d1<4;d1++)
        {
            for(int d2=0;d2<4;d2++)
            {
                for(int d3=0;d3<4;d3++)
                {
                    for(int d4=0;d4<4;d4++)
                    {
                        for(int d5=0;d5<4;d5++)
                        {
                            boolean ftest=true;
                            temp=""+first[d1]+other[d2]+other[d3]+other[d4]+other[d5];
                            String temp2="";
                            int temp3,temp4;
                            for(int g=0;g<N;g++)
                            {
                                boolean test=false;
                                temp2+=temp.charAt(g);
                                temp3=Integer.parseInt(temp2);
                                temp4=(int)Math.sqrt(temp3);
                                if(temp3==1)
                                {
                                    test=true;
                                }
                                for(int o=2; o<=temp4;o++)
                                {
                                    if(temp3%o==0)
                                    {
                                        test=true;
                                        break;
                                    }    
                                }
                                if(test)
                                {
                                    ftest=false;
                                    break;
                                }
                                
                            }
                            if(ftest)
                            {
                                out.println(temp);
                            }
                        }
                    }
                }
            }
        }
        if(N==6)
        for(int d1=0;d1<4;d1++)
        {
            for(int d2=0;d2<4;d2++)
            {
                for(int d3=0;d3<4;d3++)
                {
                    for(int d4=0;d4<4;d4++)
                    {
                        for(int d5=0;d5<4;d5++)
                        {
                            for(int d6=0;d6<4;d6++)
                            {
                                boolean ftest=true;
                                temp=""+first[d1]+other[d2]+other[d3]+other[d4]+other[d5]+other[d6];
                                String temp2="";
                                int temp3,temp4;
                                for(int g=0;g<N;g++)
                                {
                                    boolean test=false;
                                    temp2+=temp.charAt(g);
                                    temp3=Integer.parseInt(temp2);
                                    temp4=(int)Math.sqrt(temp3);
                                    if(temp3==1)
                                    {
                                        test=true;
                                    }
                                    for(int o=2; o<=temp4;o++)
                                    {
                                        if(temp3%o==0)
                                        {
                                            test=true;
                                            break;
                                        }    
                                    }
                                    if(test)
                                    {
                                        ftest=false;
                                        break;
                                    }
                                    
                                }
                                if(ftest)
                                {
                                    out.println(temp);
                                }
                            }
                        }
                    }
                }
            }
        }
        if(N==7)
        for(int d1=0;d1<4;d1++)
        {
            for(int d2=0;d2<4;d2++)
            {
                for(int d3=0;d3<4;d3++)
                {
                    for(int d4=0;d4<4;d4++)
                    {
                        for(int d5=0;d5<4;d5++)
                        {
                            for(int d6=0;d6<4;d6++)
                            {
                                for(int d7=0;d7<4;d7++)
                                {
                                    boolean ftest=true;
                                    temp=""+first[d1]+other[d2]+other[d3]+other[d4]+other[d5]+other[d6]+other[d7];
                                    String temp2="";
                                    int temp3,temp4;
                                    for(int g=0;g<N;g++)
                                    {
                                        boolean test=false;
                                        temp2+=temp.charAt(g);
                                        temp3=Integer.parseInt(temp2);
                                        temp4=(int)Math.sqrt(temp3);
                                        if(temp3==1)
                                        {
                                            test=true;
                                        }
                                        for(int o=2; o<=temp4;o++)
                                        {
                                            if(temp3%o==0)
                                            {
                                                test=true;
                                                break;
                                            }    
                                        }
                                        if(test)
                                        {
                                            ftest=false;
                                            break;
                                        }
                                        
                                    }
                                    if(ftest)
                                    {
                                        out.println(temp);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if(N==8)
        for(int d1=0;d1<4;d1++)
        {
            for(int d2=0;d2<4;d2++)
            {
                for(int d3=0;d3<4;d3++)
                {
                    for(int d4=0;d4<4;d4++)
                    {
                        for(int d5=0;d5<4;d5++)
                        {
                            for(int d6=0;d6<4;d6++)
                            {
                                for(int d7=0;d7<4;d7++)
                                {
                                    for(int d8=0;d8<4;d8++)
                                    {
                                        boolean ftest=true;
                                        temp=""+first[d1]+other[d2]+other[d3]+other[d4]+other[d5]+other[d6]+other[d7]+other[d8];
                                        String temp2="";
                                        int temp3,temp4;
                                        for(int g=0;g<N;g++)
                                        {
                                            boolean test=false;
                                            temp2+=temp.charAt(g);
                                            temp3=Integer.parseInt(temp2);
                                            temp4=(int)Math.sqrt(temp3);
                                            if(temp3==1)
                                            {
                                                test=true;
                                            }
                                            for(int o=2; o<=temp4;o++)
                                            {
                                                if(temp3%o==0)
                                                {
                                                    test=true;
                                                    break;
                                                }    
                                            }
                                            if(test)
                                            {
                                                ftest=false;
                                                break;
                                            }
                                            
                                        }
                                        if(ftest)
                                        {
                                            out.println(temp);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
       /* for(int u=min;u<max;u+=2)
        {
            
            boolean ftest=true;
            String temp =""+u;
            String temp2="";
            int temp3,temp4;
            for(int g=0;g<N;g++)
            {
                boolean test=false;
                temp2+=temp.charAt(g);
                temp3=Integer.parseInt(temp2);
                temp4=(int)Math.sqrt(temp3);
                if(temp3==1)
                {
                    test=true;
                }
                for(int o=2; o<=temp4;o++)
                {
                    if(temp3%o==0)
                    {
                        test=true;
                        break;
                    }    
                }
                if(test)
                {
                    ftest=false;
                    break;
                }
                
            }
            if(ftest)
            {
                out.println(u);
            }
        }*/
       
        
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
}

