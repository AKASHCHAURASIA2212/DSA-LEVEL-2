public class Main {
    public static String comp = ""; 
    public static String floodfill(int sr,int sc,int dr,int dc,int[][] dir,String[] dirN,String asf,boolean[][]vis)
    {
        if(sr==dr&&sc==dc)
        {
           if(comp.length()==0)
           {
               comp=asf;
           }
           
           if(asf.length()<=comp.length())
           {
               comp=asf;
           }

           return comp;
        }
          String recans = "";
        vis[sr][sc]=true;
        for(int d = 0 ; d<dir.length;d++)
        {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if(inRange(r,c,dr+1,dc+1) && !vis[r][c])
            {
                recans = floodfill(r, c, dr, dc, dir, dirN, asf+dirN[d],vis) ;
            }
        }
        vis[sr][sc]=false;

        return recans;
    }

    public static boolean inRange(int sr,int sc,int dr,int dc)
    {
        if(sr>=dr || sc>=dc || sr<0 || sc<0)
        {
            return false;
        }
        return true;
    }
    public static void flood()
    {
        int m = 2 ; 
        int n = 6 ; 
        int[][] dirc = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        String[] dirN = {"A","B","C","D","E","F","G","H"};
        boolean[][] vis = new boolean[m][n];
        String  ans = floodfill(0,0,m-1,n-1,dirc,dirN,"",vis);
        System.out.println(ans);;
    }
    public static void main(String[] args)
    {
        flood();
    }
}
