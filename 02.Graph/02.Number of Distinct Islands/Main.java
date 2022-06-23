import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int m = Integer.parseInt(st[1]);

    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(numDistinctIslands(arr));

  }

  public static StringBuilder psf = new StringBuilder();

  public static void treverse(int[][]arr, int i,int j,StringBuilder str,boolean[][] vis, HashMap<StringBuilder,Integer> hm)
  {
       if(i<0 || j< 0 || i>=arr.length || j>=arr[0].length)
       {
           return;
       }
       else if(vis[i][j]==true)
       {
           return;
       }
       else if(arr[i][j]==0)
       {
           return;
       }
       
       vis[i][j]=true;
       
      treverse(arr,i+1,j,str.append("D"),vis,hm);
      treverse(arr,i,j+1,str.append("L"),vis,hm);
      treverse(arr,i-1,j,str.append("T"),vis,hm);
      treverse(arr,i,j-1,str.append("R"),vis,hm);
  }
  
  public static void findPath(int[][]arr, int i,int j,StringBuilder str,boolean[][] vis, HashMap<StringBuilder,Integer> hm)
  {
      
      treverse(arr,i+1,j,str.append("D"),vis,hm);
      treverse(arr,i,j+1,str.append("L"),vis,hm);
      treverse(arr,i-1,j,str.append("T"),vis,hm);
      treverse(arr,i,j-1,str.append("R"),vis,hm);
      
      if(!hm.containsKey(str))
      {
          hm.put(str,1);
      }
  }
  public static int numDistinctIslands(int[][] arr) {
    //write your code here
    HashMap<StringBuilder,Integer> hm = new HashMap<>();
    
    boolean[][] vis = new boolean[arr.length][arr[0].length];
    
    for(int i=0;i<arr.length;i++)
    {
        for(int j=0;j<arr[0].length;j++)
        {
            if(arr[i][j]==1 && vis[i][j]==false)
            {
                
                findPath(arr,i,j,psf.append("0"),vis,hm);
                psf = new StringBuilder();
            }
        }
    }
    
    return hm.size();
  }
}