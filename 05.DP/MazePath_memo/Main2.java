public class Main2 {

    public static boolean inRange(int sr,int sc,int dr,int dc)
    {
        if(sr>=dr || sc>=dc)
        {
            return false;
        }

        return true;
    }

    public static int mazePath01(int sr,int sc,int dr,int dc,int[][] dir,String[] dirN,String asf)
    {
          if(sr==dr&& sc==dc)
          {
              System.out.println(asf);
              return 1;
          }

          int count = 0 ;
         
          
              for(int d=0;d<dir.length;d++)
              {
                  int row = sr+dir[d][0];
                  int col = sc+dir[d][1];
                  if(inRange(row,col,dr+1,dc+1))
                  {
                      count+=mazePath01(row,col,dr,dc,dir,dirN,asf+dirN[d]);
                  }

              }
              return count;
          
    }

    
    public static int mazePath02(int sr,int sc,int dr,int dc,int[][] dir,String[] dirN,String asf)
    {
          if(sr==dr&& sc==dc)
          {
              System.out.println(asf);
              return 1;
          }

          int count = 0 ;
         
          
            for(int d=0;d<dir.length;d++)
            {
                for(int jump=1;jump<=Math.max(dr,dc);jump++)
                {
                    int row = sr+(dir[d][0]*jump);
                    int col = sc+(dir[d][1]*jump);
                    if(inRange(row,col,dr+1,dc+1))
                    {
                        count+=mazePath02(row,col,dr,dc,dir,dirN,asf+dirN[d]+jump);
                    }
                }
            }
              return count;
          
    }

    public static void mazePath()
    {
        int n = 3;
        int m = 4;
        String[] dirN = {"H","D","V"};
        int[][] dir = {{0,1},{1,1},{1,0}};
        
        int ans =  mazePath02(0,0,n-1,m-1,dir,dirN,"");
        System.out.println(ans);
    }
    public static void main(String[] args)
    {
        mazePath();
    }
}
