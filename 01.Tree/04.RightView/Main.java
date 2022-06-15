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
    
    static int hi = -1 ; 
     public void sideView(TreeNode root,List<Integer> li,int myhi)
     {
           if(root==null)
           {
               return;
           }
         
         if(myhi>hi)
         {
            li.add(root.val);
             hi = myhi;
         }
         sideView(root.right,li,myhi+1);
         sideView(root.left,li,myhi+1);
         
         // sideView(root.left,li);
     }
    public List<Integer> rightSideView(TreeNode root) {
        hi=-1;
         List<Integer> li = new ArrayList<>();
        
        if(root==null)
        {
           return li ; 
        }
       
        sideView(root,li,0);
        return li;
    }
}