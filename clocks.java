/*
PROG: clocks
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   22 Nov 2013
// PROLEM ID        :   Clocks
// DESCRIPTION      :   A program that will find a minimal sequence of moves 
//                      to return all the dials to 12 o'clock. 
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
import java.lang.*;
public class clocks
{
    public static void main (String[] args) throws IOException
    {

         //Opening files for input and output
        Scanner in = new Scanner(new FileReader("clocks.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("clocks.out")));
        
        int[] Clocks= new int[9];
        String Input=new String();
        int four= 4;
        for(int u=0;u<9;++u)
        {
            Clocks[u]=in.nextInt();
        }
        boolean test;
        //Get all possible combinations
        String combo=new String();
        int x=0;
        for(int N9=0;N9<4;++N9)
        {
            for(int N8=0;N8<4;++N8)
            {
                for(int N7=0;N7<4;++N7)
                {
                    for(int N6=0;N6<4;++N6)
                    {
                        for(int N5=0;N5<4;++N5)
                        {
                            for(int N4=0;N4<4;++N4)
                            {
                                for(int N3=0;N3<4;++N3)
                                {
                                    for(int N2=0;N2<4;++N2)
                                    {
                                        for(int N1=0;N1<4;++N1)
                                        {
                                            StringBuilder sb = new StringBuilder();
                                            for(int u=0;u<N1;++u)
                                            {
                                                sb.append("1");
                                            }
                                            for(int g=0;g<N2;++g)
                                            {
                                                sb.append("2");
                                            }
                                            for(int o=0;o<N3;++o)
                                            {
                                                sb.append("3");
                                            }
                                            for(int c=0;c<N4;++c)
                                            {
                                                sb.append("4");
                                            }
                                            for(int h=0;h<N5;++h)
                                            {
                                                sb.append("5");
                                            }
                                            for(int u=0;u<N6;++u)
                                            {
                                                sb.append("6");
                                            }
                                            for(int k=0;k<N7;++k)
                                            {
                                                sb.append("7");
                                            }
                                            for(int w=0;w<N8;++w)
                                            {
                                                sb.append("8");
                                            }
                                            for(int u=0;u<N9;++u)
                                            {
                                                sb.append("9");
                                            }
                                            combo=sb.toString();
                                            int[] tempClocks=new int[9];
                                            for(int u=0;u<9;++u)
                                            {
                                                tempClocks[u]=Clocks[u];
                                            }
                                            //Too lazy to think, Hard code dail outcomes
                                            int length=combo.length();
                                            for(int u=0;u<length;++u)
                                            {
                                                switch (combo.charAt(u))
                                                {
                                                    case '1':
                                                    {
                                                        tempClocks[0]+=3; //A
                                                        tempClocks[1]+=3; //B
                                                        tempClocks[3]+=3; //D
                                                        tempClocks[4]+=3; //E
                                                        break;
                                                    }
                                                    case '2':
                                                    {
                                                        tempClocks[0]+=3; //A
                                                        tempClocks[1]+=3; //B
                                                        tempClocks[2]+=3; //C
                                                        break;
                                                    }
                                                    case '3':
                                                    {
                                                        tempClocks[1]+=3; //B
                                                        tempClocks[2]+=3; //C
                                                        tempClocks[4]+=3; //E
                                                        tempClocks[5]+=3; //F
                                                        break;
                                                    }
                                                    case '4':
                                                    {
                                                        tempClocks[0]+=3; //A
                                                        tempClocks[3]+=3; //D
                                                        tempClocks[6]+=3; //G
                                                        break;
                                                    }
                                                    case '5':
                                                    {
                                                        tempClocks[1]+=3; //B
                                                        tempClocks[3]+=3; //D
                                                        tempClocks[4]+=3; //E
                                                        tempClocks[5]+=3; //F
                                                        tempClocks[7]+=3; //H
                                                        break;
                                                    }
                                                    case '6':
                                                    {
                                                        tempClocks[2]+=3; //C
                                                        tempClocks[5]+=3; //F
                                                        tempClocks[8]+=3; //I
                                                        break;
                                                    }
                                                    case '7':
                                                    {
                                                        tempClocks[3]+=3; //D
                                                        tempClocks[4]+=3; //E
                                                        tempClocks[6]+=3; //G
                                                        tempClocks[7]+=3; //H
                                                        break;
                                                    }
                                                    case '8':
                                                    {
                                                        tempClocks[6]+=3; //G
                                                        tempClocks[7]+=3; //H
                                                        tempClocks[8]+=3; //I
                                                        break;
                                                    }
                                                    case '9':
                                                    {
                                                        tempClocks[4]+=3; //E
                                                        tempClocks[5]+=3; //F
                                                        tempClocks[7]+=3; //H
                                                        tempClocks[8]+=3; //I
                                                        break;
                                                    }
                                                }
                                            }
                                            //Check if all clocks are 12
                                            int y=0;
                                            test=true;
                                            while(test && y<9)
                                            {
                                                if(tempClocks[y]%12!=0)
                                                {
                                                    test=false;
                                                    break;
                                                }
                                                ++y;
                                            }
                                            if(test && length>0)
                                            {
                                                //Output
                                                for(int u=0;u<length-1;++u)
                                                {
                                                    out.print(combo.charAt(u)+" "); 
                                                }
                                                out.print(combo.charAt(length-1));
                                                out.println();
                                                out.close();
                                                System.exit(0);
                                            }                                            
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
}