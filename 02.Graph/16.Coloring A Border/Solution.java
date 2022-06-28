class Solution {
    
    // public boolean treverse(int i,int j,int orgclr,int[][] grid) {
    //     if(isBorder(grid,i+1,j,orgclr))
    //     {
    //         return true;
    //     }
    //     else if(isBorder(grid,i-1,j,orgclr))
    //     {
    //         return true;
    //     }
    //     else if(isBorder(grid,i,j+1,orgclr))
    //     {
    //         return true;
    //     }
    //     else if(isBorder(grid,i,j-1,orgclr))
    //     {
    //         return true;
    //     }
    //     else{
    //       return false;
    //     }
// }
    
    public boolean isBorder(int i,int j,int orgclr,int[][] grid) {
      if(i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1) {
             return true;
        }
        else if(grid[i+1][j]!=orgclr)
        {
            return true;
        }
        else if(grid[i-1][j]!=orgclr)
        {
            return true;
        }
        else if(grid[i][j+1]!=orgclr)
        {
            return true;
        }
        else if(grid[i][j-1]!=orgclr)
        {
            return true;
        }
        
        return false;
}
    
    public class Pair{
        int i;
        int j;
        boolean border;
        public Pair(int i,int j,boolean border) {
            this.i=i;
            this.j=j;
            this.border=border;
        }
    }
    
    public void addNB(int i,int j,int orgclr,Queue<Pair> qu ,int[][] grid,boolean[][] vis) {
       if(i<0 || j<0 || i>=grid.length || j>=grid[0].length ||vis[i][j]==true || grid[i][j]!=orgclr) {
           return;
       }
        
        qu.add(new Pair(i,j,false));
    }
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int orgclr = grid[row][col];
        
        Queue<Pair> qu = new LinkedList<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        qu.add(new Pair(row,col,false));
        
        ArrayList<Pair> al = new ArrayList<>();
        
        while(qu.size()>0)
        {
           Pair rem = qu.remove();
            
            if(vis[rem.i][rem.j])
            {
                continue;
            }
            vis[rem.i][rem.j]=true;
            
            boolean border = isBorder(rem.i,rem.j,orgclr,grid);
            rem.border = border;
            
            if(border)
            {
               al.add(rem);  
            }
           
            
            addNB(rem.i+1,rem.j,orgclr,qu,grid,vis);
            addNB(rem.i-1,rem.j,orgclr,qu,grid,vis);
            addNB(rem.i,rem.j+1,orgclr,qu,grid,vis);
            addNB(rem.i,rem.j-1,orgclr,qu,grid,vis);
         
        }
        
        for(Pair ele : al)
        {
                grid[ele.i][ele.j]=color; 
        }
        
        return grid;
    }
}