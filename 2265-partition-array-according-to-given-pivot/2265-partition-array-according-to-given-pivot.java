class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < pivot){
                for(int j = i; j > 0 && nums[j - 1] >= pivot; j--){
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                }
            }
            if(nums[i] == pivot){
                for(int j = i; j > 0 && nums[j - 1] > pivot; j--){
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                }
            }
        }
        return nums;
    }
}