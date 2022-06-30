// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    public void dfs(int sr,Stack<Integer> st ,boolean[] vis,ArrayList<ArrayList<Integer>> adj)
    {
        vis[sr]=true;
        
        ArrayList<Integer> al = adj.get(sr);
        for(int nbr : al)
        {
            if(vis[nbr]==false)
            {
                dfs(nbr,st,vis,adj);
            }
        }
        
        st.add(sr);
    }
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //step 1 --> dfs from all verteces and add to stack in post-order
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        for(int v=0;v<V;v++)
        {
            if(vis[v]==false)
            {
            dfs(v,st,vis,adj); 
            }
        
        }
        
        // step-2 --> transpose graph(reverse edges of graph)
        
        ArrayList<ArrayList<Integer>> tsp = new ArrayList<ArrayList<Integer>>();
        for(int v=0;v<V;v++)
        {
            tsp.add(new ArrayList<>());
        }
        
        for(int v=0;v<V;v++)
        {
            for(int n : adj.get(v))
            {
                tsp.get(n).add(v);
            }
        }
        
        //step-3--> pop from stack dfs again
        boolean[] vis2 = new boolean[V];
        int count = 0;
        
        while(st.size()>0)
        {
            int vtx = st.pop();
            if(!vis2[vtx])
            {
                dfs2(vtx,vis2,tsp);
                count++;
            }
        }
        
        return count;
    }
    public void dfs2(int v,boolean[] vis2,ArrayList<ArrayList<Integer>> tsp)
    {
        vis2[v]=true;
        ArrayList<Integer> al = tsp.get(v);
        for(int nbr : al)
        {
            if(vis2[nbr]==false)
            {
                dfs2(nbr,vis2,tsp);
            }
        }
    }
}
