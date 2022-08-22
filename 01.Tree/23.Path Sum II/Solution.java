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
    
    public void path(TreeNode root , int tar ,List<Integer> l1){
        if(root==null){
            return ;
        }
        
        if(root.left==null && root.right==null && tar-root.val==0){
            l1.add(root.val);
            list.add(l1);
            return ;
        }
        
        List<Integer> l2 = new ArrayList<Integer>(l1);
        int ntar = tar-root.val ;
        if(root.left!=null){
            l1.add(root.val);
        path(root.left,ntar,l1);
        }
        if(root.right!=null){
            l2.add(root.val);
        path(root.right,ntar,l2);
        }
    }
    
    List<List<Integer>> list ;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        list  = new ArrayList<>();
        if(root==null)return list;
        
        path(root,targetSum,new ArrayList<>());
        return list ;
    }
}