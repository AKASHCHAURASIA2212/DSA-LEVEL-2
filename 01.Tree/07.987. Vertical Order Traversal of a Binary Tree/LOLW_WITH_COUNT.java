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
     TreeNode root;
        int vl ;
        
        public Pair(TreeNode x,int l)
        {
            root=x;
            vl=l;
        }
    }
    
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        
        Queue<Pair> qu = new LinkedList<>();
        
        qu.add(new Pair(root,0));
        
        int minlevel = Integer.MAX_VALUE;
        int maxlevel = Integer.MIN_VALUE;
        
        while(qu.size()>0)
        {
            int size = qu.size();
            
            while(size-->0)
            {
                // remove 
                Pair rem = qu.remove();
                int level = rem.vl;
                // mark*
                if(minlevel>level)
                {
                    minlevel=level;
                }
                // work*
                if(maxlevel<level)
                {
                    maxlevel = level;
                }
                if(!hm.containsKey(level))
                {
                    List<Integer> li = new ArrayList<>();
                    
                    li.add(rem.root.val);
                    
                    hm.put(level,li);
                }
                else
                {
                    List<Integer> li = hm.get(level);
                    li.add(rem.root.val);
                    
                    hm.put(level,li);
                }
                
                // add neighbour
                
                if(rem.root.left!=null)
                {
                    qu.add(new Pair(rem.root.left,rem.vl-1));
                }
                
                if(rem.root.right!=null)
                {
                    qu.add(new Pair(rem.root.right,rem.vl+1));
                }
                
                
            }
        }
        
            List<List<Integer>> list = new ArrayList<>();
            for(int i=minlevel;i<=maxlevel;i++)
            {
                list.add(hm.get(i));
            }
            
            return list ;
    }
}