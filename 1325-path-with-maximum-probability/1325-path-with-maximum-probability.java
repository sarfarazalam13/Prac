class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double dp[] = new double[n];
        dp[start] = 1.0;
        for (int i = 0; i < n - 1; i++) {
            boolean relaxed = false;
            for (int j = 0; j < edges.length; j++) {
                int e1 = edges[j][0];
                int e2 = edges[j][1];
                double p = succProb[j];
                if (dp[e2] * p > dp[e1]) {
                    dp[e1] = dp[e2] * p;
                    relaxed = true;
                }
                if (dp[e1] * p > dp[e2]) {
                    dp[e2] = dp[e1] * p;
                    relaxed = true;
                }
            }
            if (!relaxed) break;
        }
        return dp[end];
    }
}