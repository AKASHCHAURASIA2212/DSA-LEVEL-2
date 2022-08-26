class Solution {
    int MOD = 1000000007;
    public int countHousePlacements(int n) {
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
        tot = (tot*tot) % MOD ;
        
        return (int)tot;
    }
}