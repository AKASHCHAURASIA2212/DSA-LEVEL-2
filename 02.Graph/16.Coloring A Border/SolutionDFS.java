class Solution {
    
    public void treverse(int i,int j,int[][] grid,int oc)
    {
            if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!=oc)
            {
                 return;
            }
        grid[i][j] = -oc;
            
        treverse(i+1,j,grid,oc);
        treverse(i-1,j,grid,oc);
        treverse(i,j+1,grid,oc);
        treverse(i,j-1,grid,oc);
        
        if(i>0 && j>0 && i<grid.length-1 && j<grid[0].length-1 && 
           Math.abs(grid[i + 1][j]) == oc &&
           Math.abs(grid[i - 1][j]) == oc &&
           Math.abs(grid[i][j + 1]) == oc &&
           Math.abs(grid[i][j - 1]) == oc)
        {
           grid[i][j]=oc;
        }
    }
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        
        int myclr = grid[row][col];
        
        treverse(row,col,grid,myclr);
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==-myclr)
                {
                    grid[i][j]=color;
                }
            }
        }
        return grid;
    }
}