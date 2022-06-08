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
 * Approch//
 * 1-create queue of treenode
 * 2-create stack of list<integer>
 * 3-now just follow step remove(queue),add(stack),addchildren(queue)
 * 4-after completion stack contain all the node of tree in reverse order
 * 5-just pop and add it to list<list<Integer>> and return it
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode node) {
        
      List<List<Integer>> list = new ArrayList<>();
        
        if(node==null)
        {
           return list;
        }
      Queue<TreeNode> qu = new LinkedList<>();
      Stack<List<Integer>> st = new Stack<>();
      qu.add(node);
      qu.add(null);
      
      while(qu.size()>0)
      {
          int size = qu.size();
          List<Integer> mylist = new ArrayList<>();
          while(size-->0)
          {
              TreeNode temp = qu.remove();
               
              if(temp!=null)
              {
                  mylist.add(temp.val);

                  if(temp.left!=null)
                  {
                      qu.add(temp.left);
                  }
                  
                  if(temp.right!=null)
                  {
                      qu.add(temp.right);
                  }

                  
              }
              else{
                  st.add(mylist);
                  if(qu.size()>0)
                  {
                    qu.add(null);
                  }
              }
         
          } 
    }
        
    // System.out.println(st);
      while(st.size()>0)
      {
          List<Integer> li = st.pop();
              list.add(li);
      }
        
    
        // System.out.println(li);
      
      return list;
  }
    
}