import java.util.*;
public class Main{

    public static int dir[][] ={{0,1},{1,1},{1,0}};
    public static String dirN[]  ={"H","D","V"};
    public static void mazePath(int sr,int sc,int dr,int dc,ArrayList<String> AL, String asf)
    {
        if(sr<0 || sc<0 || sr>dr || sc>dc)
        {
            return ;
        }

        ArrayList<String> recAns = new ArrayList<>();
       if(sr==dr && sc==dc)
       {
          System.out.println(asf);
          AL.add(asf);
        
       }

     // horizontal move
     if(sc+1<=dc)
     {
     mazePath(sr,sc+1,dr,dc,AL,asf+"H");
     }
     
     //vertical move
     if(sr+1<=dr)
     {
        mazePath(sr+1,sc,dr,dc,AL,asf+"V");
     }
      
     if(sr+1<=dr && sc+1<=dc)
     {
      mazePath(sr+1,sc+1,dr,dc,AL,asf+"D");
     }
     
    }
    public static void main(String[] args)
    {
        // Scanner sc = new Scanner(System.in);
        int n = 3;//sc.next();
        int m = 4;// sc.next();
        // int[][] arr = new int[n][m];
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<m;j++)
        //     {
        //         arr[i][j]=sc.next();
        //     }
        // }
        ArrayList<String> AL = new ArrayList<>();
        String asf = "";
         mazePath(0,0,n-1,m-1,AL,asf);

        System.out.println(AL+" "+AL.size());

    }
}