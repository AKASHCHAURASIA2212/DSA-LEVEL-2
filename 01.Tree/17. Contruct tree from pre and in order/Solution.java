import java.util.HashMap;

//  Definition for a binary tree node.
  public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
        this.left = left;
        this.right = right;
     }
  }
 
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            int val = inorder[i];
            hm.put(val,i);
        }
        TreeNode root = construct(0,preorder.length-1,0,inorder.length-1,preorder,hm);
        return root ;
    }
    
    public TreeNode construct(int plo,int phi,int ilo,int ihi,int[] pre, HashMap<Integer,Integer> hm )
    {
        if(plo>phi || ilo>ihi)
        {
           return null ;
        }
        // base case 
        int preval = pre[plo];
        
        int idx = hm.get(preval) ;
        
        int size = idx - ilo ;
        
        TreeNode node = new TreeNode();
        
        node.val = preval;
        
        node.left = construct(plo+1 ,plo+size , ilo, idx-1 , pre , hm  ) ;
        
        node.right =construct( plo+1+size, phi , idx+1, ihi , pre ,hm ) ;

            return node ;
    }
}