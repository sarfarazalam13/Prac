class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<=nums.length/2;i++)
        {
            max=Math.max(max,nums[i]+nums[n-i-1]);
        }
        return max;
    }
}