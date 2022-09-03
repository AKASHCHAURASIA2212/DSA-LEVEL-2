class Solution {
    int[] node ;
    int[] edge ;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        node = new int[n] ;
        edge = new int[n] ;
        int[] ans = new int[n];
        
        HashSet<Integer>[] graph = new HashSet[n];
        for(int i=0 ;i<n;i++){
            graph[i] = new HashSet<>();
        }
        
        for(int i=0;i<edges.length;i++){
            int src = edges[i][0];
            int dst = edges[i][1];
            graph[src].add(dst);
            graph[dst].add(src);  
        }
        
        helper1(graph,node,edge,0,-1);
        helper2(graph,node,edge,0,-1);
        return edge ;
    }
    public void helper1(HashSet<Integer>[] graph, int[] node ,int[] edge,int src,int par)
    {
        for(int nbr : graph[src])
        {
             if(nbr!=par){
                helper1(graph,node,edge,nbr,src);
                 node[src]+= node[nbr]; 
                 edge[src] += node[nbr]+edge[nbr] ; 
             }
        }
        node[src]++;
        
    }
    public void helper2(HashSet<Integer>[] graph, int[] node ,int[] edge,int src,int par){
        
        for(int nbr : graph[src])
        {
             if(nbr!=par){
                 edge[nbr] = edge[src] + (node.length-node[nbr]) - node[nbr] ;
                helper2(graph,node,edge,nbr,src);

             }
        }

        
    }
}