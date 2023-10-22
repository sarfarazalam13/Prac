class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int start = k - 1, end = k + 1, min = nums[k];
        while (start >= 0 && nums[start] >= min) start--;
        while (end < n && nums[end] >= min) end++;
        int max = min * (end - start - 1);
        while (start >= 0 || end < n) {
            if (start < 0 || end < n && nums[end] >= nums[start]) {
                min = nums[end];
                while (end < n && nums[end] >= min) end++;
                max = Math.max(max, min * (end - start - 1));
            }
            else {
                min = nums[start];
                while (start >= 0 && nums[start] >= min) start--;
                max = Math.max(max, min * (end - start - 1));
            }
        }
        return max;
    }
}