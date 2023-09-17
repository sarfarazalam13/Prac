class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums,0,0);
    }
    int helper(int nums[],int idx,int xor)
    {
        if(idx==nums.length)
        {
            return xor;
        }
        int in=helper(nums,idx+1,xor^nums[idx]);
        int nin=helper(nums,idx+1,xor);
        return in+nin;
    }
}