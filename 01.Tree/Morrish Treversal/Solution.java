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
// morris treversl
 // steps 
 //  1. if node.left == null
 //      1.1 print node
 //      1.2go to right
 //  2.if node.left != null 
 //      2.1 left is not processed
 //      2.2 iop.right = node and go to left 
 //      2.3 if left is procssed
 //      2.4 iop.right = null ,print and go to right 
 class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> val = new ArrayList<>();
        TreeNode curr = root ;
        
        while(curr!=null)
        {
           if(curr.left==null)
           {
               val.add(curr.val);
               curr=curr.right;
           }
            else
            {
                
                TreeNode iop = curr.left;
                while(iop.right!=null && iop.right!=curr)
                    iop=iop.right;
                
                if(iop.right==null)
                {
                    iop.right=curr;
                    curr = curr.left;
                }
                else
                {
                    iop.right=null;
                    val.add(curr.val);
                    curr=curr.right ;
                }
            }
        }
        
        return val ;
    }
}