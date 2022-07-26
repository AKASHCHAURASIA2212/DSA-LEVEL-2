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
    
    public class Pair implements Comparable<Pair> {
       TreeNode root ; 
       int h ;
       int v ;
        
        public Pair(TreeNode x , int h ,int v)
        {
            root = x ;
            this.h = h;
            this.v=v;
        }
        
        // this - other means increasing
        // other - this means decreasing
        public int compareTo(Pair other){
            if(this.v == other.v){
                return this.root.val - other.root.val;
            } else {
                return this.v - other.v;
            }
        }
        
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        Queue<Pair> qu = new LinkedList<>();
        HashMap<Integer,ArrayList<Pair>> hm = new HashMap<>();
        // here we put horizontal = 0 and vertical = 1 
        qu.add(new Pair(root,0,1));
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        while(qu.size()>0)
        {
            Pair rem = qu.remove();
            
            if(rem.h<min)
            {
                min=rem.h;
            }
            
            if(rem.h>max)
            {
                max=rem.h;
            }
            
            if(!hm.containsKey(rem.h))
            {
               ArrayList<Pair> al = new ArrayList<>();
                al.add(rem);
                hm.put(rem.h,al);
            }
            else
            {
                ArrayList<Pair> al = hm.get(rem.h);
                al.add(rem);
                hm.put(rem.h,al);
            }
            
            if(rem.root.left!=null)
            {
                qu.add(new Pair(rem.root.left , rem.h-1,rem.v+1));
            }
            
            if(rem.root.right!=null)
            {
                qu.add(new Pair(rem.root.right , rem.h+1,rem.v+1));
            }
        }
        
        List<List<Integer>>  list = new ArrayList<>();
        
        for(int i=min;i<=max;i++)
        {
            ArrayList<Pair> unsort = hm.get(i);  
            
            Collections.sort(unsort);
            
            ArrayList<Integer> al = new ArrayList<>();
            for(Pair temp: unsort){
                al.add(temp.root.val);
            }
            list.add(al);
        }
        
        return list ;
        
    }
}