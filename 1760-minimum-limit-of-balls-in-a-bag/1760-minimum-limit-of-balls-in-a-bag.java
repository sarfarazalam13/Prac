class Solution {
    boolean check(int[] arr,int m,int o)
    {
        for(int i=0;i<arr.length;i++)
        {
            o-=(arr[i]/m);
            if(arr[i]%m==0)o++;
        }
        return o>=0;
    }
    public int minimumSize(int[] nums, int maxOperations) {
       int l=1,r=Integer.MAX_VALUE,ans=0; 
       while(l<=r)
       {
         int m=l+(r-l)/2;
         if(check(nums,m,maxOperations))
         {
             ans=m;
             r=m-1;
         }
         else
         {
          l=m+1;
         }
       }
       return ans;
    }
}