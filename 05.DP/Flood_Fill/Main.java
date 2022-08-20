import java.util.Arrays;

public class Main {

    public static int mazePath01(int sr,int sc,int dr,int dc,int[][] dir,String[] dirN,String asf,boolean[][] vis)
    {
          if(sr==dr&& sc==dc)
          {
              System.out.println(asf);
              return 1;
          }

          int count = 0 ;
         
              vis[sr][sc]=true;
              for(int d=0;d<dir.length;d++)
              {
                  int row = sr+dir[d][0];
                  int col = sc+dir[d][1];
                  if(inRange(row,col,dr+1,dc+1) && !vis[row][col])
                  {
                      count+=mazePath01(row,col,dr,dc,dir,dirN,asf+dirN[d],vis);
                  }

              }
              vis[sr][sc]=false;
              return count;
          
    }

    public static void flood()
    {
        int n = 3;
        int m = 3;
        boolean[][] vis = new boolean[3][4];
        String[] dirN = {"A","B","C","D","E","F","G","H"};
        int[][] dir = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        
        int ans =  mazePath01(0,0,n-1,m-1,dir,dirN,"",vis);
        System.out.println(ans);
    }

    public static boolean inRange(int sr,int sc,int dr,int dc)
    {
        if(sr<0 || sr>=dr || sc>=dc || sc<0)
        {
            return false;
        }

        return true;
    }

   
    // public static int floodfill(int sr,int sc,int dr,int dc,String asf,boolean[][] vis)
    // {
    //       if(sr==dr&&sc==dc)
    //       {
    //           System.out.println(asf);
    //           return 1;
    //       }

    //       int count = 0 ;
          

    // }
    public static void main(String[] args)
    {
        flood();
    }
}
