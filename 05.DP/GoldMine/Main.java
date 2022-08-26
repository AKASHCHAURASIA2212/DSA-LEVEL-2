public class Main {
    
}
import java.io.*;
import java.util.*;

public class Main {
    
    public static void Goldmine(int[][] arr)
    {
        for(int j = arr[0].length-2;j>=0;j--)
        {
            for(int i=0;i<arr.length;i++)
            {
                if(i==0)
                {
                    
                    int d2 = arr[i][j+1] ;
                    int d3 = arr[i+1][j+1];
                    arr[i][j] = Math.max(d2,d3) + arr[i][j];
                }
                else if(i==arr.length-1)
                {           
                    int d2 = arr[i][j+1];
                    int d1 = arr[i-1][j+1] ;
                    arr[i][j] = Math.max(d2,d1)+ arr[i][j];
                }
                else
                {
                    int d1 = arr[i-1][j+1];
                    int d2 = arr[i][j+1] ;
                    int d3 = arr[i+1][j+1];
                   arr[i][j] = Math.max(d1,Math.max(d2,d3))+ arr[i][j];

                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int goldmine[][] = new int[n][m];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                goldmine[i][j]=sc.nextInt();
            }
        }
        Goldmine(goldmine);
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<m;j++)
        //     {
        //         System.out.print(goldmine[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
        int max =0;
        for(int i=0;i<n;i++)
        {
            max = Math.max(max,goldmine[i][0]);
        }
        
        System.out.print(max);
    }

}