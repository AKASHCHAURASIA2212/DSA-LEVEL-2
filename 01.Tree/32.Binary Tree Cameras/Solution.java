// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */



class Solution {
    
    
    public final int CAMERA = 1 ;
    public final int MONITERED = 2 ;
    public final int NOT_MONITERED = 3 ;
    int count=0;
    public int helper(TreeNode root)
    {
        if(root==null)
        {
             return MONITERED ;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        if(left==NOT_MONITERED || right==NOT_MONITERED)
        {
            count++;
            return CAMERA;
        }
        else if(left==CAMERA || right==CAMERA)
        {
            return MONITERED;
        }
        else{
            return NOT_MONITERED ;
        }
    }
        public int minCameraCover(TreeNode root) {
            int c = helper(root);
        
            if(c==NOT_MONITERED)
            {
                  return ++count ;
            }
            
            return count ;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // class Solution {
        
    //     // 1--> c
    //     // 0--> m
    //     // -1 --> nm ;
    //     public int treecam(TreeNode root) {
    //         if(root==null)
    //         {
    //             return 0 ;
    //         }
            
    //         int left = treecam(root.left);
    //         int right = treecam(root.right);
            
    //         if(left==0 && right==0)
    //         {
    //             return -1 ;
    //         }
    //         else if(left==-1 || right==-1)
    //         {
    //             cam++;
    //             return 1;
    //         }
    //         else if(left==1 || right==0)
    //         {
    //             return 0 ;
    //         }
    //         else if(right==1 || left==0)
    //         {
    //             return 0 ;
    //         }
            
    //         return -2;
    //     }
        
    //      // 1--> c
    //     // 0--> m
    //     // -1 --> nm ;
    //     int cam=0;
    //         public int minCameraCover(TreeNode root) {
    //         if(root==null)
    //         {
    //             return 0 ;
    //         }
    //         else if(root.left==null  && root.right==null)
    //         {
    //             return 1;
    //         }
            
    //         int left = treecam(root.left);
    //         int right = treecam(root.right);
            
    //         if(left==0 && right==0)
    //         {
    //             cam++;
    //             return cam;
    //         }
    //         else if(left==-1 || right==-1)
    //         {
    //             cam++;
    //             return cam;
    //         }
    //         else if(left==1 || right==0)
    //         {
    //             return cam;
    //         }
    //         else if(right==1 || left==0)
    //         {
    //             return cam;
    //         }
    //        return -2;
    //     }
    // }