/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    
    void helper (TreeNode node , StringBuilder sb)
    {
        if(node==null)
        {
            sb.append(".");
            sb.append(" ");
            return;
        }
        
        sb.append(node.val);
        sb.append(" ");
        helper(node.left,sb);
        helper(node.right,sb);
        
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
      if(root==null)
      {
          return "";
      }
      
        StringBuilder sb = new StringBuilder();
        
        helper(root,sb);
        
        System.out.println("--> "+sb);
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    
    public class pair{
       TreeNode root;
        int state;
        
        public pair(TreeNode root,int state)
        {
            this.root=root;
            this.state=state;
        }
         public pair(int state)
        {
            this.state=state;
        }
        
    }
    public TreeNode deserialize(String data) {
       
        if(data.length()==0)
        {
           return null ; 
        }
        
       Stack<pair> st = new Stack<>();
        String[] darray = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(darray[0]));
        st.push(new pair(root,0));
        int i = 1;
        while(st.size()>0 && i<data.length())
        {
            pair peek = st.peek();
            
            if(peek.state==0)
            {
                peek.state++;
                String str = darray[i];
                if(!str.contains("."))
                {
                TreeNode myroot = new TreeNode(Integer.parseInt(darray[i]));
                peek.root.left = myroot;
                st.push(new pair((myroot),0));
                }
              
                i++;

            }
            else if(peek.state==1)
            {
               peek.state++;
                String str = darray[i];
                if(!str.contains("."))
                {
                TreeNode myroot = new TreeNode(Integer.parseInt(darray[i]));
                peek.root.right = myroot;
                st.push(new pair((myroot),0));
                }
              
                i++;
            }
            else
            {
             st.pop();
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));