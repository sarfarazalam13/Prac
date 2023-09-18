class Solution {
    public int countQuadruplets(int[] nums) {

        // Map<Integer, Integer> diffMap = new HashMap();

        int[] diffArr = new int[201];
        
        int result = 0;

        for(int b = nums.length - 3; b > 0; b--) {
            int c = b + 1;
            int d = c + 1;

            while(d < nums.length) {
                int diff = nums[d++] - nums[c];
                // diffMap.put(diff, diffMap.getOrDefault(diff, 0) + 1);

                if(diff > 0)
                    diffArr[diff]++;
            }

            int a = b - 1;

            while(a >= 0) {
                // result += diffMap.getOrDefault(nums[a--] + nums[b], 0);
                result += diffArr[nums[a--] + nums[b]];
            }
        }

        return result;
        
    }
}