/*
PROG: packrec
ID: unwagbo1
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   22 Mar 2014
// PROLEM ID        :   Packing Rectangles
// DESCRIPTION      :   A program to find the smallest enclosing (new) rectangle 
//                      into which these four may be fitted without overlapping.
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
import java.lang.*;
public class packrec
{
    public static int[][] Input=new int[4][2];
    public static int area= 10001;
    public static boolean[] side=new boolean[201];
    public static boolean[][] rect=new boolean[201][5000];
    public static void main (String[] args) throws IOException
    {
        //Opening files for input and output
        Scanner in = new Scanner(new FileReader("packrec.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("packrec.out")));
       
        //Reads in input
        int[] bx1= new int[2];
        int[] bx2= new int[2];
        int[] bx3= new int[2];
        int[] bx4= new int[2];
        int[] sbx1= new int[2];
        int[] sbx2= new int[2];
        int[] sbx3= new int[2];
        int[] sbx4= new int[2];
        bx1[0]=in.nextInt();
        bx1[1]=in.nextInt();
        bx2[0]=in.nextInt();
        bx2[1]=in.nextInt();
        bx3[0]=in.nextInt();
        bx3[1]=in.nextInt();
        bx4[0]=in.nextInt();
        bx4[1]=in.nextInt();
        
        sbx1[0]=bx1[1];
        sbx1[1]=bx1[0];
        sbx2[0]=bx2[1];
        sbx2[1]=bx2[0];
        sbx3[0]=bx3[1];
        sbx3[1]=bx3[0];
        sbx4[0]=bx4[1];
        sbx4[1]=bx4[0];
        
        
                
        for(int u=0; u<2; u++ )
        {
            for(int g=0; g<2; g++ )
            {
                for(int o=0; o<2; o++ )
                {
                    for(int c=0; c<2; c++ )
                    {
                        int[] b1= new int[2];
                        int[] b2= new int[2];
                        int[] b3= new int[2];
                        int[] b4= new int[2];
                        
                        
                        if(u==0)
                            b1=bx1.clone();
                        else
                            b1=sbx1.clone();
                            
                        if(g==0)
                            b2=bx2.clone();
                        else
                            b2=sbx2.clone();
                        
                        if(o==0)
                            b3=bx3.clone();
                        else
                            b3=sbx3.clone();
                        
                        if(c==0)
                            b4=bx4.clone();
                        else
                            b4=sbx4.clone(); 
                            
                        //Layout 1    
                        layout1(b1, b2, b3, b4);
                        layout1(b1, b2, b4, b3);
                        layout1(b1, b3, b2, b4);
                        layout1(b1, b3, b4, b2);
                        layout1(b1, b4, b2, b3);
                        layout1(b1, b4, b3, b2);
                        layout1(b2, b1, b4, b3);
                        layout1(b2, b1, b3, b4);
                        layout1(b2, b3, b4, b1);
                        layout1(b2, b3, b1, b4);
                        layout1(b2, b4, b3, b1);
                        layout1(b2, b4, b1, b3);
                        layout1(b3, b1, b2, b4);
                        layout1(b3, b1, b4, b2);
                        layout1(b3, b2, b1, b4);
                        layout1(b3, b2, b4, b1);
                        layout1(b3, b4, b1, b2);
                        layout1(b3, b4, b2, b1);
                        layout1(b4, b1, b3, b2);
                        layout1(b4, b1, b2, b3);
                        layout1(b4, b2, b3, b1);
                        layout1(b4, b2, b1, b3);
                        layout1(b4, b3, b2, b1);
                        layout1(b4, b3, b1, b2);  
                        
                        //Layout2
                        layout2(b1, b2, b3, b4);
                        layout2(b1, b2, b4, b3);
                        layout2(b1, b3, b2, b4);
                        layout2(b1, b3, b4, b2);
                        layout2(b1, b4, b2, b3);
                        layout2(b1, b4, b3, b2);
                        layout2(b2, b1, b4, b3);
                        layout2(b2, b1, b3, b4);
                        layout2(b2, b3, b4, b1);
                        layout2(b2, b3, b1, b4);
                        layout2(b2, b4, b3, b1);
                        layout2(b2, b4, b1, b3);
                        layout2(b3, b1, b2, b4);
                        layout2(b3, b1, b4, b2);
                        layout2(b3, b2, b1, b4);
                        layout2(b3, b2, b4, b1);
                        layout2(b3, b4, b1, b2);
                        layout2(b3, b4, b2, b1);
                        layout2(b4, b1, b3, b2);
                        layout2(b4, b1, b2, b3);
                        layout2(b4, b2, b3, b1);
                        layout2(b4, b2, b1, b3);
                        layout2(b4, b3, b2, b1);
                        layout2(b4, b3, b1, b2);
                        
                        //Layout3
                        layout3(b1, b2, b3, b4);
                        layout3(b1, b2, b4, b3);
                        layout3(b1, b3, b2, b4);
                        layout3(b1, b3, b4, b2);
                        layout3(b1, b4, b2, b3);
                        layout3(b1, b4, b3, b2);
                        layout3(b2, b1, b4, b3);
                        layout3(b2, b1, b3, b4);
                        layout3(b2, b3, b4, b1);
                        layout3(b2, b3, b1, b4);
                        layout3(b2, b4, b3, b1);
                        layout3(b2, b4, b1, b3);
                        layout3(b3, b1, b2, b4);
                        layout3(b3, b1, b4, b2);
                        layout3(b3, b2, b1, b4);
                        layout3(b3, b2, b4, b1);
                        layout3(b3, b4, b1, b2);
                        layout3(b3, b4, b2, b1);
                        layout3(b4, b1, b3, b2);
                        layout3(b4, b1, b2, b3);
                        layout3(b4, b2, b3, b1);
                        layout3(b4, b2, b1, b3);
                        layout3(b4, b3, b2, b1);
                        layout3(b4, b3, b1, b2);
                        
                        //Layout4
                        layout4(b1, b2, b3, b4);
                        layout4(b1, b2, b4, b3);
                        layout4(b1, b3, b2, b4);
                        layout4(b1, b3, b4, b2);
                        layout4(b1, b4, b2, b3);
                        layout4(b1, b4, b3, b2);
                        layout4(b2, b1, b4, b3);
                        layout4(b2, b1, b3, b4);
                        layout4(b2, b3, b4, b1);
                        layout4(b2, b3, b1, b4);
                        layout4(b2, b4, b3, b1);
                        layout4(b2, b4, b1, b3);
                        layout4(b3, b1, b2, b4);
                        layout4(b3, b1, b4, b2);
                        layout4(b3, b2, b1, b4);
                        layout4(b3, b2, b4, b1);
                        layout4(b3, b4, b1, b2);
                        layout4(b3, b4, b2, b1);
                        layout4(b4, b1, b3, b2);
                        layout4(b4, b1, b2, b3);
                        layout4(b4, b2, b3, b1);
                        layout4(b4, b2, b1, b3);
                        layout4(b4, b3, b2, b1);
                        layout4(b4, b3, b1, b2);
                        
                        //Layout5
                        layout5(b1, b2, b3, b4);
                        layout5(b1, b2, b4, b3);
                        layout5(b1, b3, b2, b4);
                        layout5(b1, b3, b4, b2);
                        layout5(b1, b4, b2, b3);
                        layout5(b1, b4, b3, b2);
                        layout5(b2, b1, b4, b3);
                        layout5(b2, b1, b3, b4);
                        layout5(b2, b3, b4, b1);
                        layout5(b2, b3, b1, b4);
                        layout5(b2, b4, b3, b1);
                        layout5(b2, b4, b1, b3);
                        layout5(b3, b1, b2, b4);
                        layout5(b3, b1, b4, b2);
                        layout5(b3, b2, b1, b4);
                        layout5(b3, b2, b4, b1);
                        layout5(b3, b4, b1, b2);
                        layout5(b3, b4, b2, b1);
                        layout5(b4, b1, b3, b2);
                        layout5(b4, b1, b2, b3);
                        layout5(b4, b2, b3, b1);
                        layout5(b4, b2, b1, b3);
                        layout5(b4, b3, b2, b1);
                        layout5(b4, b3, b1, b2);
                        
                        //Layout6
                        layout6(b1, b2, b3, b4);
                        layout6(b1, b2, b4, b3);
                        layout6(b1, b3, b2, b4);
                        layout6(b1, b3, b4, b2);
                        layout6(b1, b4, b2, b3);
                        layout6(b1, b4, b3, b2);
                        layout6(b2, b1, b4, b3);
                        layout6(b2, b1, b3, b4);
                        layout6(b2, b3, b4, b1);
                        layout6(b2, b3, b1, b4);
                        layout6(b2, b4, b3, b1);
                        layout6(b2, b4, b1, b3);
                        layout6(b3, b1, b2, b4);
                        layout6(b3, b1, b4, b2);
                        layout6(b3, b2, b1, b4);
                        layout6(b3, b2, b4, b1);
                        layout6(b3, b4, b1, b2);
                        layout6(b3, b4, b2, b1);
                        layout6(b4, b1, b3, b2);
                        layout6(b4, b1, b2, b3);
                        layout6(b4, b2, b3, b1);
                        layout6(b4, b2, b1, b3);
                        layout6(b4, b3, b2, b1);
                        layout6(b4, b3, b1, b2);
                    }
                }
            }
        }
        out.println(area);
        boolean test=true;
        for(int h=0;h<=Math.sqrt(area);h++)
        {
            for(int w=0;w<=area/2;w++)
            {
                if(rect[h][w] && (h*w)==area)
                {
                    test=false;
                    out.println(h+" "+w);
                }   
            }
        }
        if(test)
        for(int u=1;u<=Math.sqrt(area);u++)
        {
            if(area%u==0 && side[u] && side[area/u])
                out.println(u+" "+(area/u));
        }
        
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
    
    public static void layout1(int[]box1, int[]box2, int[]box3, int[]box4)
    {
        int[] height= {box1[0],box2[0],box3[0],box4[0]};
        Arrays.sort(height);
        side[height[3]]=true;
        side[box1[1]+box2[1]+box3[1]+box4[1]]=true;
        int h= height[3];
        int w=box1[1]+box2[1]+box3[1]+box4[1];
        rect[h][w]=true;
        area=Math.min(area,h*w);
    }
    public static void layout2(int[]box1, int[]box2, int[]box3, int[]box4)
    {
        int[] height= {box1[0],box2[0],box3[0]};
        Arrays.sort(height);
        side[height[2]+box4[1]]=true;
        side[Math.max(box1[1]+box2[1]+box3[1],box4[0])]=true;
        int h=height[2]+box4[1];
        int w= Math.max(box1[1]+box2[1]+box3[1],box4[0]);
        rect[h][w]=true;
        area=Math.min(area,h*w);
    }
    public static void layout3(int[]box1, int[]box2, int[]box3, int[]box4)
    {
        int[] height= {box1[0],box2[0]};
        Arrays.sort(height);
        side[Math.max(height[1]+box4[1],box3[0])]=true;
        side[Math.max(box1[1]+box2[1]+box3[1],box4[0]+box3[1])]=true;
        int h=Math.max(height[1]+box4[1],box3[0]);
        int w=Math.max(box1[1]+box2[1]+box3[1],box4[0]+box3[1]);
        rect[h][w]=true;
        area=Math.min(area,h*w);
    }
    public static void layout4(int[] box1, int[]box2, int[]box3, int[]box4)
    {
        int[] height= {box1[0],box4[0]};
        Arrays.sort(height);
        side[Math.max(height[1],box2[0]+box3[0])]=true;
        side[Math.max(box1[1]+box2[1]+box4[1],box1[1]+box3[1]+box4[1])]=true;
        int h=Math.max(height[1],box2[0]+box3[0]);
        int w=Math.max(box1[1]+box2[1]+box4[1],box1[1]+box3[1]+box4[1]);
        rect[h][w]=true;
        area=Math.min(area,h*w);
    }
    public static void layout5(int[] box1, int[]box2, int[]box3, int[]box4)
    {
        int[] height= {box3[0],box4[0]};
        Arrays.sort(height);
        side[Math.max(height[1],box2[0]+box1[0])]=true;
        side[Math.max(box1[1]+box3[1]+box4[1],box2[1]+box3[1]+box4[1])]=true;
        int h=Math.max(height[1],box2[0]+box1[0]);
        int w=Math.max(box1[1]+box3[1]+box4[1],box2[1]+box3[1]+box4[1]);
        rect[h][w]=true;
        area=Math.min(area,h*w);
    }
    public static void layout6(int[] box1, int[]box2, int[]box3, int[]box4)
    {
        side[Math.max(box1[0]+box2[0],box3[0]+box4[0])]=true;
        int h= Math.max(box1[0]+box2[0],box3[0]+box4[0]);
        int w=0;
        if(box2[0] >= box3[0] + box4[0])
        {
            side[Math.max(box1[1], Math.max(box2[1]+box3[1],box2[1]+box4[1]))]=true;
            w=Math.max(box1[1], Math.max(box2[1]+box3[1],box2[1]+box4[1]));
        }    
        else if (box2[0] > box4[0] && box2[0] < box3[0]+box4[0])
        {
            side[Math.max(Math.max(box1[1]+box3[1], box3[1]+box2[1]),box2[1]+box4[1])]=true;
            w=Math.max(Math.max(box1[1]+box3[1], box3[1]+box2[1]),box2[1]+box4[1]);
        }    
        else if( box2[0] < box4[0] && box4[0] < box1[0]+box2[0])
        {
            side[Math.max(Math.max(box1[1]+box3[1], box1[1]+box4[1]), box2[1]+box4[1])]= true;
            w=Math.max(Math.max(box1[1]+box3[1], box1[1]+box4[1]), box2[1]+box4[1]);
        }    
        else if (box4[0] >=box1[0]+box2[0])
        {
            side[Math.max(Math.max(box1[1]+box4[1], box2[1]+box4[1]), box3[1])]= true;
            w=Math.max(Math.max(box1[1]+box4[1], box2[1]+box4[1]), box3[1]);
        }    
        else
        {
            side[Math.max(box1[1]+box3[1], box2[1]+box4[1])]=true;
            w=Math.max(box1[1]+box3[1], box2[1]+box4[1]);
        }
        rect[h][w]=true;
        area=Math.min(area,h*w);  
    }
}

