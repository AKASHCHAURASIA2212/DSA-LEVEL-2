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
    public List<Integer> preorderTraversal(TreeNode root) {
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
                     val.add(curr.val);
                    iop.right=curr;
                    curr = curr.left;
                }
                else
                {
                    iop.right=null;
                    // val.add(curr.val);
                    curr=curr.right ;
                }
            }
        }
        
        return val ;
    }
}