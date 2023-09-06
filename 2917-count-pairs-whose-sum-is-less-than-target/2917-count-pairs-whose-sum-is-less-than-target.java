class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int pairs = 0;
        int n = nums.size();

        for(int i=0; i<n-1; i++){
            int a = nums.get(i);

            for(int j=i+1; j<n; j++){
                int b = nums.get(j);

                if((a+b) < target) pairs++;
            }
        }

        return pairs;
    }
}