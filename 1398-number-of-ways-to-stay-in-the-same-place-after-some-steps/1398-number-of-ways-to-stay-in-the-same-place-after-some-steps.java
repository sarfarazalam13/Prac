class Solution {
    public int numWays(int s, int l) {
        if(l==1)return 1;
        final int mod = 1_000_000_007;
        l--;
        if(l>s/2)l=s/2;
        int[] dp = new int[l+1];
        int[] tt = new int[l+1];
        dp[0]=1;

        for(int x=0; x<s; x++){
            tt[0]=dp[1];
            for(int i=1; i<tt.length-1; i++)tt[i] = (dp[i-1]+dp[i+1])%mod;
            tt[tt.length-1]=dp[tt.length-2];

            for(int i=0; i<dp.length; i++)dp[i] = (dp[i]+tt[i])%mod;
        }
        
        return dp[0];
    }
}