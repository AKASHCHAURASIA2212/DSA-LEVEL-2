public class Main {
    class Solution {
        public static int mazetreversal(int sr,int sc,int dr,int dc,int[][] dp,int[][] arr)
      {
          if(sr==dr && sc==dc && arr[sr][sc]!=1)
          {
              return dp[sr][sc]=1;
          }
          
          if(dp[sr][sc]!=0 && arr[sr][sc]!=1)
          {
              return dp[sr][sc];
          }
          //horzontal
          int count=0;
            if(sc+1<=dc && arr[sr][sc+1]!=1)
          {
              count+=mazetreversal(sr,sc+1,dr,dc,dp,arr);
          }
          if(sr+1<=dr && arr[sr+1][sc]!=1)
          {
             count+= mazetreversal(sr+1,sc,dr,dc,dp,arr);
          }
        
          
          return dp[sr][sc]=count;
      }
      public int uniquePathsWithObstacles(int[][] obstacleGrid) {
          int m = obstacleGrid.length;
          int n = obstacleGrid[0].length;
          int[][] dp = new int[m][n];
          if(n==0 || m==0)
          {
              return 0;
          }
          if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1)
          {
            return 0;
          }
          int ans = mazetreversal(0,0,m-1,n-1,dp,obstacleGrid);
          System.out.println(dp[0][0]);
          return ans;
      }
  }
}
