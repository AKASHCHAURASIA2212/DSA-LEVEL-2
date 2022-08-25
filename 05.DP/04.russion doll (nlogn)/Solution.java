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
    int len=1;
    int tails[] = new int[envelopes.length];
    tails[0]=envelopes[0][1];
    
    for(int i=1;i<tails.length;i++)
    {
      if(tails[len-1]<envelopes[i][1])
      {
          len++;
          tails[len-1]=envelopes[i][1];
      }
        else
        {
            int idx = Arrays.binarySearch(tails,0,len-1,envelopes[i][1]);
            if(idx<0)
            {
                idx=-idx;
                idx=idx-1;
            }
            tails[idx]=envelopes[i][1];
        }
    }

    return len ;
}
}
