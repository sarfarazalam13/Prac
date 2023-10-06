class Solution {
    public int[] rearrangeArray(int[] nums) {
        int ans[]=new int[nums.length];
        int pi=0;
        int ni=1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<0)
            {
                ans[ni]=nums[i];
                ni=ni+2;
            }
            else
            {
                ans[pi]=nums[i];
                pi+=2;
            }
        }
        return ans;
    }
}