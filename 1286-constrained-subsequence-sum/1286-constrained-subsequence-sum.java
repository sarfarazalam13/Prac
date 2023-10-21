class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(nums[0]);
        for(int i = 1; i < nums.length; i++){
            dp[i] = nums[i];
            if(i>k && q.getFirst() == dp[i-k-1]){
                q.removeFirst();
            }
            dp[i]=Math.max(dp[i],q.getFirst()+nums[i]);
            while(!q.isEmpty() && (q.getLast()<dp[i])){
                q.removeLast();
            }
            q.addLast(dp[i]);
            max=Math.max(max,dp[i]);
        } 
        return max;
    }
}