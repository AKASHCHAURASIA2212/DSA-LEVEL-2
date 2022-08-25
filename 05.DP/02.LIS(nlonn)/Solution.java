public class Solution {
    public int lengthOfLIS(int[] nums) {
        int tails[] = new int[nums.length];
        
        tails[0]=nums[0];
         int len=1;
        
        for(int i=1;i<nums.length;i++)
        {
             if(nums[i]>tails[len-1])
             {
                 len++;
                 tails[len-1]=nums[i];
             }
            else
            {
                int idx = Arrays.binarySearch(tails,0,len-1,nums[i]);
                if(idx<0)
                {
                    idx=-idx;
                    idx=idx-1;
                }
                
                tails[idx]=nums[i];
            }
        }
       
        return len ;
    }
}
