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
    
    class Pair{
        int node;
        int coin;
        public Pair(int node,int coin) {
            this.node=node;
            this.coin=coin;
        }
        public Pair(){}
    }
    int ans = 0 ;
    public Pair helper(TreeNode root){
        if(root==null){
            return new Pair(0,0); 
        }
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        
        Pair MyPair = new Pair();
        MyPair.node = left.node + right.node + 1 ;
        MyPair.coin = left.coin + right.coin + root.val ;
        
        ans += Math.abs( MyPair.coin - MyPair.node );
        
        return MyPair ;
        
    }
    public int distributeCoins(TreeNode root) {
         helper(root);
        return ans ;
    }
}