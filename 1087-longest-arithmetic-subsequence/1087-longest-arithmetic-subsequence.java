class Solution {
    public int longestArithSeqLength(int[] nums) {
        int numsLength = 0, limit = 500, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        for (int k = 0; k <= max - min; k++) {
            if (k * numsLength > max - min) break;

            int[] first = new int[limit + 1], second = new int[limit + 1];
            for (int num : nums) {
                first[num] = (num + k <= limit) ? (first[num + k] + 1) : 1;
                second[num] = (num - k >= 0) ? (second[num - k] + 1) : 1;
                numsLength = Math.max(numsLength, Math.max(first[num], second[num]));
            }
        }
        return numsLength;
    }
}