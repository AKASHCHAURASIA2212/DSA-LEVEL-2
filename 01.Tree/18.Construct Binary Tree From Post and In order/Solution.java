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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        TreeNode root = construct( 0 , postorder.length-1 , 0 , inorder.length-1 , postorder , hm ) ;
        return root ;
    }
    
    public TreeNode construct(int polo , int pohi , int inlo , int inhi , int[] post ,  HashMap<Integer,Integer> hm)
    {
        // base case
        if(inlo>inhi || polo>pohi){
            return null ;
        }
        
        TreeNode node = new TreeNode();
        node.val = post[pohi];
        
        int idx = hm.get(post[pohi]);
        
        int rhs = inhi-idx ;
        
        // left tree
        // (inlo--idx-1) (polo --- pohi-rhs-1)
        // right tree
        //(idx+1--inhi) (pohi-rhs--pohi-1)
        
        node.left  =  construct( polo , pohi-rhs-1 ,inlo , idx-1, post,hm);
        node.right = construct( pohi-rhs , pohi-1 ,idx+1 ,inhi , post,hm);
        
        return node  ;
    }
}