class Solution {
    public int maxArea(int[] height) {
        
        if(height.length==0)
        {
            return 0;
        }
        
        // brute force gives O(n ^ 2 ) 
//         int max= Integer.MIN_VALUE ; 
        
//         int hi = height.length-1 ;
        
//         for(int i=0;i<height.length;i++)
//         {
//             for(int j=i+1;j<height.length;j++)
//             {
//                 int mymax = (j-i) * Math.min(height[i],height[j]);
                
//                 if(mymax>max)
//                 {
//                     max = mymax ; 
//                 }
//             }
//         }
        
//         // right to left
//         for(int i=height.length-1;i>=0 ;i--)
//         {
            
//             int mymax = hi * Math.min(height[0],height[i]);
//             System.out.println("R-->L"+mymax);
//             if(mymax> max)
//             {
//                 max = mymax ; 
//             }
//             hi--;
//         }
        
//         hi = height.length-1 ;
//         // left to right
//         for(int i=0;i<height.length;i++)
//         {
//             int mymax = hi * Math.min(height[height.length-1],height[i]);
//             System.out.println("L-->R"+mymax);
//             if(mymax> max)
//             {
//                 max = mymax ; 
//             }
//             hi--;
//         }
        
//         // two pointer  * towards center
        
//         int i=0;
//         int j=height.length-1;
//         while(i<=j)
//         {
        
//             int mymax = (j-i) * Math.min(height[i],height[j]);
//                 System.out.println("R<-->L"+mymax);
//             if(mymax>max)
//             {
//                 max=mymax;
//             }
//             i++;
//             j--;
//         }
        
        // method 2 optimize
        int n= height.length;
        int ans= Integer.MIN_VALUE ;
        int start=0, end=n-1;
        
        while(start<end){
            int area= Math.min(height[start], height[end]) * (end-start);
            ans = Math.max(ans, area);
            
            if(height[start] > height[end])
                end--;
            else
                start++;
        }
        
        return ans;
    }
}