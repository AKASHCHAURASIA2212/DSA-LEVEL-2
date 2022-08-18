
public class Solution {
   
    public class Node{
        Node left;
        Node right;
        int val ;

        Public Node(Node le,Node ri,int data)
        {
            left=le;
            right=ri;
            val = data;
        }
    }
    public static void PreOrder(Node root)
    {
        if(root==null)
        {
            return;
        }
        System.out.println(root.data);

        PreOrder(root.left);
        PreOrder(root.right);
    }

    public static void InOrder(Node root)
    {
        if(root==null)
        {
            return;
        }
       
        InOrder(root.left);
        System.out.println(root.data);
        InOrder(root.right);
    }

    public static void PostOrder(Node root)
    {
        if(root==null)
        {
            return;
        }
       
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.println(root.data);
    }
}
