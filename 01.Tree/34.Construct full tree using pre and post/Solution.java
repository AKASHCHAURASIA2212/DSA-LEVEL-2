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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer,Integer> hm = new HashMap<>() ;
        int n = preorder.length;
        for(int i=0;i<n;i++){
            hm.put(postorder[i],i);
        }
        
        TreeNode root = Helper(0,n-1,0,n-1,preorder,hm);
        return root;
    }
    
    public TreeNode Helper(int prelo,int prehi,int postlo ,int posthi ,int[] pre ,HashMap<Integer,Integer> hm)
    {
        if(prelo>prehi || postlo>posthi){
            return null;
        }
        
        TreeNode node = new TreeNode();
        node.val = pre[prelo];
        
        if(prelo+1<=prehi){
          int srcidx = hm.get(pre[prelo+1]);
        int lhs = srcidx - postlo + 1 ;
        node.left = Helper( prelo+1 , prelo+lhs,postlo,srcidx,pre,hm);
        
        node.right = Helper( prelo+lhs+1 , prehi ,srcidx+1,posthi-1,pre,hm);
        
        }
        return node ;
    }
}