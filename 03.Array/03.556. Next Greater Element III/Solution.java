class Solution {
    public int nextGreaterElement(int n) {
        
        int idx1 = -1 ;
        int idx2 = -1 ;
        char[] arr = (n+"").toCharArray();
        
        for(int i = arr.length-2;i>=0;i--)
        {
            if(arr[i]<arr[i+1])
            {
                idx1 = i  ;
                break ;
            }
        }
        if(idx1==-1)
        {
            return -1 ;
        }
        for(int i = arr.length-1;i>=0;i--)
        {
            if(arr[i]>arr[idx1])
            {
                idx2 = i  ;
                break ;
            }
        }
        System.out.println(idx1+" "+idx2);
        // System.out.println(arr[idx1]+" "+arr[idx2]);
        char temp = arr[idx1];
        arr[idx1]=arr[idx2];
        arr[idx2] = temp ;
        
        int j = arr.length-1 ; 
        idx1 = idx1+1;
        int i=idx1 ;
        while(i<j)
        {
         temp = arr[i];
        arr[i]=arr[j];
        arr[j] = temp ;
            i++;
            j--;
        }
        
        String str = new String(arr);
        
        long num = Long.parseLong(str);
        
        if(num>Integer.MAX_VALUE || num<Integer.MIN_VALUE)
        {
            return -1 ;
        }
        
        return (int)num ;
    }
}