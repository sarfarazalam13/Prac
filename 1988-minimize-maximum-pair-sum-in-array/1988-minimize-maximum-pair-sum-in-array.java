class Solution {
    public int minPairSum(int[] nums) {
        int max = 0;
        for (int i : nums) {
            if (max < i) max = i;
        }
        int[] c = new int[max+1];
        for (int i : nums) {
            c[i]++;
        }
        for (int i = 1; i <= max; i++) {
            c[i] += c[i-1];
        }
        int[] ops = new int[nums.length];
        for (int i = ops.length-1; i > -1; i--) {
            ops[c[nums[i]]-1] = nums[i];
            c[nums[i]]--;
        }
        int x = 0;
        int f = 0;
        int l = ops.length-1;
        while (f < l) {
            if (ops[f]+ops[l] > x) x = ops[f]+ops[l];
            f++;
            l--;
        }
        return x;
    }
}