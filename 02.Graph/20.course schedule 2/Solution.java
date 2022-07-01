class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] tsort = new int[numCourses];
        int[] indeg = new int[numCourses];
        
        for(int[] arr : prerequisites)
        {
            indeg[arr[0]]++;
        }
        
        Queue<Integer> qu = new LinkedList<>();
        
        for(int v=0;v<numCourses;v++){

           if(indeg[v]==0)
           {
               qu.add(v);
           }
        }
        
        int idx=0;
        
        while(qu.size()>0)
        {
            int v = qu.remove();
            tsort[idx]=v;
            idx++;
            
            for(int[] arr : prerequisites )
            {
                if(arr[1]==v)
                {
                    indeg[arr[0]]--;
                    
                    if(indeg[arr[0]]==0)
                    {
                        qu.add(arr[0]);
                    }
                }
            }
        }
        
        System.out.println("idx-->"+idx);
        if(idx<numCourses)
        {
            return new int[0];
        }
        
        return tsort;
    }
}