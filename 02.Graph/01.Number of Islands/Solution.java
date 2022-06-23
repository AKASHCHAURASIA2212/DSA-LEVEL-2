class Solution {
    
    // static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    
    public void jump(char[][] grid ,int i,int j,boolean[][] vis)
    {
        if(i<0 || j>=grid[0].length || i>=grid.length || j<0 || grid[i][j]=='0')
        {
           return;
        }
        else if(vis[i][j]==true)
        {
            return;
        }
        
        vis[i][j]=true;
        jump(grid,i-1,j,vis);
        jump(grid,i,j+1,vis);
        jump(grid,i+1,j,vis);
        jump(grid,i,j-1,vis);
     
    }
    public int numIslands(char[][] grid) {
        
        int count=0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i = 0 ;i<grid.length;i++){

         for(int j = 0;j<grid[0].length;j++)
         {

              if(grid[i][j]=='1' && vis[i][j]==false)
              {
                jump(grid,i,j,vis);
                  count++;
              }
         }
        }
        return count;
    }
}