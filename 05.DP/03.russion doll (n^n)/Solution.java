public class Solution {
        public int maxEnvelopes(int[][] envelopes) {
        
        Arrays.sort(envelopes,(i,j)->{
            if(i[0]!=j[0]){
                return i[0]-j[0];
            }
            else{
               return  j[1]-i[1];
            }
    });
    
    int lis[] = new int[envelopes.length];
    lis[0]=1;
    
    for(int i=1;i<lis.length;i++)
    {
        int max =  0 ;
       for(int j=0;j<i;j++)
       {
           
           if(envelopes[j][1]<envelopes[i][1])
           {
               max = Math.max(max,lis[j]);
           }
       }
        lis[i]=max + 1 ;
    }
    
    int len =0 ;
    for(int x : lis)
    {
        len = Math.max(len,x);
    }
    
    return len ;
}
}
