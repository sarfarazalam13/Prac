class Solution {
    public int coinChange(int[] coins, int amount) {
        int[]dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int c:coins){
            for(int i=c;i<=amount;i++){
                dp[i]=Math.min(dp[i],dp[i-c]+1);
            }
        }
        return dp[amount]<=amount ? dp[amount] : -1;
    }
}
/*class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins,Comparator.reverseOrder());
        int count=0;
        for(int i=0; i<coins.length;i++)
        {
            if(coins[i]<amount)
            {
                while(coins[i]<amount)
                {
                count++;
                amount=amount-coins[i];
                }
            }
        }
        return count;
    }
}*/