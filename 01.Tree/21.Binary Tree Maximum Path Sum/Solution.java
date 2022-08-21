/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
        
    public  int  maxPath(TreeNode root){
        if(root==null)return 0 ;
        
       int left   = maxPath(root.left);
       int right  = maxPath(root.right);
        
        int left_dash = Math.max(0,left);
        int right_dash = Math.max(0,right);
        
       int mymax = left_dash+right_dash+root.val  ;
        
        if(mymax>max){
          max = mymax ;
        }
        
       int ans = Math.max(left_dash,right_dash)+root.val ;
        
        return ans ; 
    }
    public static int max = Integer.MIN_VALUE ;
    
    public int maxPathSum(TreeNode root) {
        
        max = Integer.MIN_VALUE ;
        
        if(root==null)return 0;
        else if(root.left==null && root.right==null)return root.val ;
        
        maxPath(root);
        
        return max ;
        
    }
}