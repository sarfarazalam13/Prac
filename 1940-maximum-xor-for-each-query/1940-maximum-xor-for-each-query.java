class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n=nums.length;
        int res[]=new int[n];
        int ans=0;
        for(int i:nums)ans^=i;
        int maxor=(int)Math.pow(2,maximumBit)-1;
        for(int i=0;i<n;i++)
        {
            res[i]=ans^maxor;
            ans^=nums[n-i-1];
        }
        return res;
    }
}