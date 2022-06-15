// class Solution {
//     public class pair{

    
//       int x ;
//         inty;
//         int d;
//         public pair(int x,int y,int d)
//         {
//             this.x=x;
//             this.y=y;
//             this.d=d;
//         }
//     }
//     public int maxDistance(int[][] grid) {
        
//     }
// }

class Solution {
    
    public class pair{
       int x;
         int y;
         int d;
         
         public pair(int x,int y,int d){
            
             this.x=x;
             this.y=y;
             this.d=d;
         }
     }
     public int maxDistance(int[][] mat) {
         
         int n = mat.length;
         int m = mat[0].length;
         int maxlevel =0;
         
         Queue<pair> qu = new LinkedList<>();
         for(int i=0;i<n;i++)
         {
             for(int j=0;j<m;j++){
 
                if(mat[i][j]==1)
                {
                    qu.add(new pair(i,j,0));
                }
             }
         }
         boolean[][] vis = new boolean[n][m];
         int[][] ans = new int[n][m];
         while(qu.size()>0)
         {
             pair rem = qu.remove();
             // vis[rem.x][rem.y]=true;
             // mat[rem.x][rem.y]=rem.d;
             
             if(vis[rem.x][rem.y])
             {
                continue;
             }
             
             vis[rem.x][rem.y]=true;
             ans[rem.x][rem.y]=rem.d;
             
             if(maxlevel<rem.d)
             {
                 maxlevel=rem.d;
             }
             
             addN(rem.x-1,rem.y,rem.d+1,vis,qu);
             addN(rem.x+1,rem.y,rem.d+1,vis,qu);
             addN(rem.x,rem.y-1,rem.d+1,vis,qu);
             addN(rem.x,rem.y+1,rem.d+1,vis,qu);   
         }
         
         return maxlevel==0?-1:maxlevel;
     }
         
         public void addN(int x,int y,int d,boolean[][] vis,Queue<pair> qu)
         {
            if(x<0 || y<0 || x>=vis.length || y>=vis[0].length || vis[x][y]==true)
            {
                return;
            }
             qu.add(new pair(x,y,d));
         }
         
     
 }