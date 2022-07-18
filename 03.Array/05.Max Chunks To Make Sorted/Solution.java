class Solution {
    public int maxChunksToSorted(int[] arr) {
        if(arr.length==0)
        {
            return 0 ;
        }
        
        int count = 0 ;
        int n = arr.length;
        int max = Integer.MIN_VALUE ;
        for(int i=0;i<n;i++)
        {
            max = Math.max(max,arr[i]) ;
            
            if(max==i)
            {
                count++;
            }
            
        }
        return count ; 
    }
}