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
    
    public List<List<Integer>> LevelOrder(TreeNode node,List<List<Integer>> list) 
  {
         List<Integer> li = new ArrayList<>();

      Queue<TreeNode> qu = new LinkedList<>();
      Stack<Integer> st = new Stack<>();
      qu.add(node);
      
      while(qu.size()>0)
      {
          int size = qu.size();
          while(size-->0)
          {
              TreeNode temp = qu.remove();
              st.add(temp.val);
              
               if(temp.right!=null)
              {
                  qu.add(temp.right);
              }
              
              if(temp.left!=null)
              {
                  qu.add(temp.left);
              }
          }
          if(qu.size()!=0)
          {
              st.add(null);
          }
         
      }
      
        System.out.println(st);
      while(st.size()>0)
      {
          if(st.peek()==null)
          {
              list.add(li);
              List<Integer> newli = new ArrayList<>();
              li = newli;
              st.pop();
          }
          else
          {
             li.add(st.pop());
          }
      }
        
        if(li.size()!=0)
        {
            list.add(li);
        }
        // System.out.println(li);
      
      return list;
      
  }
  
//           public List<List<Integer>> LevelOrder(TreeNode node,List<List<Integer>> list) 
//     {
        

//         Queue<TreeNode> qu = new LinkedList<>();
//         qu.add(node);
      
//         while(qu.size()>0)
//         {
//             int size = qu.size();
//              List<Integer> li = new ArrayList<>();
//             while(size-->0)
//             {
              
//                 TreeNode temp = qu.remove();
//                 li.add(temp.val);
              
//                  if(temp.right!=null)
//                 {
//                     qu.add(temp.right);
//                 }
              
//                 if(temp.left!=null)
//                 {
//                     qu.add(temp.left);
//                 }
//             }
//             list.add(li);
//         }
        
//           System.out.println(list);
      
//         return list;
      
//     }
  
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
      
      List<List<Integer>> list = new ArrayList<>();
      
      if(root==null)
      {
        return list;
      }
      
      return LevelOrder(root,list);
//         List<List<Integer>> myAns = new ArrayList<>();
      
//         while(lot.size()>0)
//         {
//             myAns.add(lot.remove(lot.size()-1));
//         }
      
//         return myAns;
      
      
  }
}