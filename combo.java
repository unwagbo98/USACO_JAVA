/*
PROG: combo
ID: unwagbo
LANG: JAVA
*/
// NAME             :   Ugo Nwagbo
// GROUP            :   APCS    
// LAST MODIFIED    :   5 Nov 2013
// PROLEM ID        :   Claf flac
// DESCRIPTION      :   A program that will Find the largest palindrome 
//                      in a string no more than 20,000 characters long.
// SOURCES/HELP     :   USACO Websites, Mr. H, Lewis Loftus

import java.io.*;
import java.util.*;
import java.lang.*;
public class combo
{
    public static void main (String[] args) throws IOException, NullPointerException
    {
         //Opening files for input and output
        Scanner in = new Scanner(new FileReader("combo.in"));
        //RandomAccessFile in = new RandomAccessFile ("ride.in", "r");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
        int N=in.nextInt();
        //Reads in input
        int[] FarmerCombo=new int[3];
        int[] MasterCombo=new int[3];
        for(int u=0;u<3;u++)
        {
           FarmerCombo[u]=in.nextInt();
        }
          for(int u=0;u<3;u++)
        {
            MasterCombo[u]=in.nextInt();
        }
        //All farmer codes
        int[][] AllFarmer= new int[125][3];
        int[] first={((FarmerCombo[0]-2)%N),((FarmerCombo[0]-1)%N),((FarmerCombo[0])%N),((FarmerCombo[0]+1)%N),((FarmerCombo[0]+2)%N)};
        int[] second={(((FarmerCombo[1]-2)%N)),((FarmerCombo[1]-1)%N),((FarmerCombo[1])%N),((FarmerCombo[1]+1)%N),((FarmerCombo[1]+2)%N)};
        int[] third={((FarmerCombo[2]-2)%N),((FarmerCombo[2]-1)%N),((FarmerCombo[2])%N),((FarmerCombo[2]+1)%N),((FarmerCombo[2]+2)%N)};
        int x=0;
        for(int u=0;u<5;u++)
        {
            for(int g=0;u<5;u++)
            {
                for(int o=0;u<5;u++)
                {
                    AllFarmer[x][0]=first[u];
                    AllFarmer[x][1]=first[g];
                    AllFarmer[x][2]=first[o];
                    x++;
                }
            }
        }
        
        //All Master codes
        int[][] AllMaster= new int[125][3];
        int[] firstM={(MasterCombo[0]-2)%N,(MasterCombo[0]-1)%N,(MasterCombo[0])%N,(MasterCombo[0]+1)%N,(MasterCombo[0]+2)%N};
        int[] secondM={(MasterCombo[1]-2)%N,(MasterCombo[1]-1)%N,(MasterCombo[1])%N,(MasterCombo[1]+1)%N,(MasterCombo[1]+2)%N};
        int[] thirdM={(MasterCombo[2]-2)%N,(MasterCombo[2]-1)%N,(MasterCombo[2])%N,(MasterCombo[2]+1)%N,(MasterCombo[2]+2)%N};
        x=0;
        for(int u=0;u<5;u++)
        {
            for(int g=0;u<5;u++)
            {
                for(int o=0;u<5;u++)
                {
                    AllMaster[x][0]=firstM[u];
                    AllMaster[x][1]=firstM[g];
                    AllMaster[x][2]=firstM[o];
                    x++;
                }
            }
        }
        //Get unique Farmer combos
        boolean test=true;
        int[][] UniqueFarmer= new int[125][3];
        int UF_SIZE=0;
        for(int u=0;u<124;u++)
        {
            for(int g=u+1;g<125;g++)
            {
              if((AllFarmer[u][0]==AllFarmer[g][0])&&(AllFarmer[u][1]==AllFarmer[g][1])&&(AllFarmer[u][2]==AllFarmer[g][2]))
              {
                  test=false;
                  break;
              }
            }
            if(test)
            {
              UniqueFarmer[UF_SIZE][0]=AllFarmer[u][0];
              UniqueFarmer[UF_SIZE][1]=AllFarmer[u][1];
              UniqueFarmer[UF_SIZE][2]=AllFarmer[u][2];
              UF_SIZE++;
            }
        }
        UniqueFarmer[UF_SIZE-1][0]=AllFarmer[124][0];
        UniqueFarmer[UF_SIZE-1][0]=AllFarmer[124][1];
        UniqueFarmer[UF_SIZE-1][0]=AllFarmer[124][2];
        //Get unique Master combos
        test=true;
        int[][] UniqueMaster= new int[125][3];
        int UM_SIZE=0;
        for(int u=0;u<124;u++)
        {
            for(int g=u+1;g<125;g++)
            {
              if((AllMaster[u][0]==AllMaster[g][0])&&(AllMaster[u][1]==AllMaster[g][1])&&(AllMaster[u][2]==AllMaster[g][2]))
              {
                  test=false;
                  break;
              }
            }
            if(test)
            {
              UniqueMaster[UM_SIZE][0]=AllMaster[u][0];
              UniqueMaster[UM_SIZE][1]=AllMaster[u][1];
              UniqueMaster[UM_SIZE][2]=AllMaster[u][2];
              UM_SIZE++;
            }
        }
        UniqueMaster[UM_SIZE-1][0]=AllMaster[124][0];
        UniqueMaster[UM_SIZE-1][0]=AllMaster[124][1];
        UniqueMaster[UM_SIZE-1][0]=AllMaster[124][2];
        int counter=UM_SIZE+UF_SIZE;
        for(int u=0;u<UF_SIZE;u++)
        {
            for(int g=0;g<UM_SIZE;g++)
            {
                if((UniqueFarmer[u][0]==UniqueMaster[g][0])&&(UniqueFarmer[u][1]==UniqueMaster[g][1])&&(UniqueFarmer[u][2]==UniqueMaster[g][2]))
                {
                    counter--; 
                    break;
                }
            }
        }
        
            out.println(counter);
       
        
        //Ensures Program ends properly
        out.close();
        System.exit(0);
    }
}
