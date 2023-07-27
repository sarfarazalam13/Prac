class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        boolean allMultiply = true;

        for (int i = 1; i < coins.length; ++i) {

            if (coins[i] % coins[0] != 0) {
                allMultiply = false;
                break;
            }
        }

        if (allMultiply && (amount % coins[0]) != 0) {
            return -1;
        }

        int minCount = Integer.MAX_VALUE;
        int[] counts = new int[coins.length];
        int i = coins.length - 1;
        int count = amount / coins[i];
        int amount1 = amount - count * coins[i];

        if (amount1 == 0) {
            return count;
        }

        if (coins[0] * (count + 1) == amount) {
            return count + 1;
        }

        if (count == amount / coins[0]) {
            return -1;
        }

        counts[i] = count;
        amount = amount1;

        while (true) {
            if (count >= minCount || i <= 0) {
                count -= counts[i];
                amount += counts[i] * coins[i];

                do {
                    ++i;

                    if (i >= coins.length) {
                        return minCount < Integer.MAX_VALUE ? minCount : -1;
                    }

                } while (counts[i] == 0);
                --counts[i];
                --count;
                amount += coins[i];
            }

            --i;
            counts[i] = 0;

            while (amount >= coins[i]) {
                amount -= coins[i];
                ++counts[i];
            }

            count += counts[i];

            if (amount == 0 && count < minCount) {
                minCount = count;
            }
        }
    }
}

/*class Solution {
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
class Solution {
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