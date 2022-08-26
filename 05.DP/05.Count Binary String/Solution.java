//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            long ans = new Solution().countStrings(n);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java


    class Solution {
    int MOD = 1000000007;
    public long countStrings(int n) {
        long one = 1 ;
        long zero = 1 ;
        for(int i=1;i<n;i++)
        {
            long z = one%MOD ;
            long nz = (one+zero)%MOD ;
            one = nz ;
            zero = z ;
        }
        long tot = (one+zero)%MOD;
        return tot;
    }
    
}
   
