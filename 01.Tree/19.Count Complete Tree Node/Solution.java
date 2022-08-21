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
    
    public int leftheight(TreeNode root)
    {
        if(root==null)
        {
            return 0 ;
        }
        
       return leftheight(root.left) + 1 ;
        
    }
    
    public int rightheight(TreeNode root)
    {
        if(root==null)
        {
            return 0 ;
        }
        
       return rightheight(root.right) + 1 ;
        
    }
    public int countNodes(TreeNode root) {
        
        if(root==null)
        {
            return 0 ;
        }
        
        int lefthi= leftheight(root.left);
        int righthi = rightheight(root.right);
        
//         System.out.println("left height --> "+ lefthi);
//         System.out.println("right height --> "+ righthi);
        
        
        if(lefthi==righthi)
        {
            return (int)Math.pow(2,lefthi+1)-1 ;
        }
        
        int leftsize = countNodes(root.left);
        int rightsize = countNodes(root.right);
        
        return leftsize+rightsize+1 ;
        
        
    }
}