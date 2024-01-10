class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int min = 1;
        int max = 1000000000;
        while (min < max) {
            int mid = (max + min) / 2;
            if (isMidPossible(nums, maxOperations, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    public boolean isMidPossible(int[] nums, int maxOperations, int mid) {
        int result = 0;
        for (int i : nums) {
            // compression - make use of divide property to implicitly check modulo case
            result += (i - 1) / mid;
            if (result > maxOperations) {
                // short-circuiting
                return false;
            }
        }
        return true;
    }
}