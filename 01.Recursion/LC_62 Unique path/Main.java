public class Main {
    class Solution {
        public static int mazetreversal(int sr,int sc,int dr,int dc,int[][] dp)
        {
            if(sr==dr && sc==dc)
            {
                return dp[sr][sc]=1;
            }
            
            if(dp[sr][sc]!=0)
            {
                return dp[sr][sc];
            }
            //horzontal
            int count=0;
              if(sc+1<=dc)
            {
                count+=mazetreversal(sr,sc+1,dr,dc,dp);
            }
            if(sr+1<=dr)
            {
               count+= mazetreversal(sr+1,sc,dr,dc,dp);
            }
          
            
            return dp[sr][sc]=count;
        }
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            int ans = mazetreversal(0,0,m-1,n-1,dp);
            System.out.println(dp[0][0]);
            return ans;
        }
    }
}
