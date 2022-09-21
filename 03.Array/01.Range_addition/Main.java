import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static int[] getModifiedArray(int length, int[][] queries) {
        // write your code here
        int[] ans = new int[length];
        for(int i=0;i<queries.length;i++){
            int li = queries[i][0];
            int hi = queries[i][1];
            int val= queries[i][2];
            
            for(int j =li;j<=hi;j++){
                ans[j]+=val;
            }
        }
        return ans;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int length = scn.nextInt();

        int nq = scn.nextInt();
        
        int[][] queries = new int[nq][3];

        for(int q = 0; q < nq; q++) {
            queries[q][0] = scn.nextInt();
            queries[q][1] = scn.nextInt();
            queries[q][2] = scn.nextInt();
        }


        int[] res = getModifiedArray(length, queries);

        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}