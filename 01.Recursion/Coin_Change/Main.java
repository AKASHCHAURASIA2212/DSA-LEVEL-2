public class Main {
    
    public static int CoinChangePerminf(int[] coin,int target,String asf)
    {
        if(target==0)
        {
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        for(int i=0;i<coin.length;i++)
        {
            if(target-coin[i]>=0)
            {
               count+=CoinChangePerminf(coin, target-coin[i],asf+coin[i]);
            }
        }

        return count;

    }


    public static int CoinChangeCombinf(int[] coin,int idx,int target,String asf)
    {
        if(target==0)
        {
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        for(int i=idx;i<coin.length;i++)
        {
            if(target-coin[i]>=0)
            {
               count+=CoinChangeCombinf(coin,i, target-coin[i],asf+coin[i]);
            }
        }

        return count;

    }


    public static int CoinChangePermsingle(int[] coin,int target,String asf)
    {
        if(target==0)
        {
          System.out.println(asf);
          return 1;
        }
        int count=0;
        for(int i = 0;i<coin.length;i++)
        {
            if(coin[i]>0 && target-coin[i]>=0)
            {
                int val = coin[i];
                coin[i]=-coin[i];
                count+=CoinChangePermsingle(coin,target-val,asf+val);
                coin[i]=val;

            }
        }
        return count;

    }

    public static int CoinChangeCombsingle(int[] coin,int idx,int target,String asf)
    {
        if(target==0)
        {
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        for(int i=idx;i<coin.length;i++)
        {
            if(target-coin[i]>=0)
            {
               count+=CoinChangeCombsingle(coin,i+1, target-coin[i],asf+coin[i]);
            }
        }

        return count;

    }

    public static void coin()
    {
        int [] coin = {2,3,5,7};
        // int ans1 = CoinChangePerminf(coin,10,"");
        // int ans2 = CoinChangeCombinf(coin,0,10,"");
        // int ans3 = CoinChangePermsingle(coin,10,"");
        int ans4 = CoinChangeCombsingle(coin,0,10,"");



    

        System.out.println(ans4);
    }
    public static void main(String[] args)
    {
        coin();
    }
}
