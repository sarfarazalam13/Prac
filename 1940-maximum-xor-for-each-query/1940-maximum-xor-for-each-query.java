class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int temp = (1<<maximumBit) - 1;
        int n = nums.length;
        int x=0;
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            x ^= nums[i];
            ans[n-i-1] = x^temp;
        }
        return ans;
    }
}