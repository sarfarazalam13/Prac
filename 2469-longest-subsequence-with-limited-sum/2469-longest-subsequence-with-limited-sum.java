class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;
        Arrays.sort(nums);
        int prefixSum[] = new int[n];
        prefixSum[0] = nums[0];
        for(int i = 1;i < n;i++)
            prefixSum[i] = prefixSum[i-1] + nums[i];
        int result[] = new int[m];
        for(int i = 0;i < m;i++) {
            int query = queries[i];
            int index = Arrays.binarySearch(prefixSum, query);
            if(index < 0)
                result[i] = -(index+1);
            else
                result[i] = index+1; 
        }
        return result;
    }
}