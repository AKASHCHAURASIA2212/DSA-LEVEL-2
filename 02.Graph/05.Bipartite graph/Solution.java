class Solution {
    class pair{
        int vtx;
        int clr;
        public pair(int vtx,int clr){
            this.vtx=vtx;
            this.clr=clr;
        }
    }
    
    public boolean treverse(int[][] graph,int[] visited,int v)
    {
        Queue<pair> qu = new LinkedList<>();
        qu.add(new pair(v,1));
        
        while(qu.size()>0)
        {

           // remove 
           pair rem = qu.remove();
           
            //mark*
            if(visited[rem.vtx]!=0)
            {
              int oc = visited[rem.vtx];
                int nc = rem.clr;
                if(oc==nc)
                {
                    continue;
                }
                else
                {
                    return false;
                }
            }
            
            visited[rem.vtx]=rem.clr;
            
            for(int nbr : graph[rem.vtx])
            {
                if(visited[nbr]==0)
                {
                    qu.add(new pair(nbr,rem.clr * -1));
                }
            }
            
        }
        
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        int[] visited  = new int[n];
        
        for(int v=0;v<n;v++)
        {
            if(visited[v]==0)
            {
               boolean isBip=treverse(graph,visited,v);
                if(!isBip)
                {
                   return false;
                }
            }
        }
        
        return true;
        
    }
}