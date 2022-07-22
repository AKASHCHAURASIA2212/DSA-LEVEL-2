class Solution {
    public int[] sortedSquares(int[] nums) {
        // method 1 
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
        
//         for(int i=0;i<nums.length;i++)
//         {
//             pq.add(nums[i]*nums[i]);
//         }
        
//         for(int i = 0 ; i < nums.length ;i++ )
//         {
//             nums[i] = pq.remove();
//         }
        
//         return nums;
        
        // method 2 optimize
        int n = nums.length;
        int left = 0 ;
        int right = n-1 ;
        int[] ans = new int[n];
        
        for(int i = n-1 ; i>=0 ; i--)
        {
            if(Math.abs(nums[left])>nums[right])
            {
                ans[i]=nums[left]*nums[left];
                left++;
            }
            else{
                ans[i]=nums[right]*nums[right];
                right--;
            }
        }
        return ans;
    }
}