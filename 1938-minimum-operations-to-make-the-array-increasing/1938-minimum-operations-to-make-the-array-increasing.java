class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        int dep   = nums[0];
        for(int a = 0; a < nums.length-1; a++){
            if(dep>=nums[a+1]){
                dep++;
                count += dep-nums[a+1];
            }else{
                dep = nums[a+1];
            }
        }
        return count;
    }
}