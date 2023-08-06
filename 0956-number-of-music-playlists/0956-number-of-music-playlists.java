class Solution {
    private final long MOD = (long)1e9+7;
    public int numMusicPlaylists(int n, int goal, int k) {
        Long[][] dp = new Long[101][101];
        return (int)solve(n, goal, k, dp, 0, 0);
    }

    public long solve(int n, int goal, int k, Long[][] dp, int playListSize, int songs){
        
        // playList is full we cannot add any more song
        if(playListSize == goal) return n == songs ? 1 : 0;

        if(null != dp[playListSize][songs]) return dp[playListSize][songs];

        // scenario -1: if songs - K is negative means we have not yet played enough K unique songs so cannot repeat song
        // otherwise songs - k options we have to repeat so multiply it
        long repeat = (solve(n, goal, k, dp, playListSize + 1, songs) * Math.max(0, songs - k)) % MOD;
        
        //scenario - 2 : select unique song, so now we are left with (n-songs) options to select from so multiply it
        long unique = (solve(n, goal, k, dp, playListSize + 1, songs+1) * (n - songs)) % MOD;
        return dp[playListSize][songs] = (repeat + unique) % MOD;
    }
}