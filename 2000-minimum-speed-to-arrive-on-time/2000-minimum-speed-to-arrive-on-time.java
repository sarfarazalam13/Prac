class Solution {
    int n;
    public int minSpeedOnTime(int[] dist, double hour) {
        n = dist.length;
        if(n-1+1e-7>hour) return -1;
        int l = 1;
        int r = (int)1e7;
        int m = 0;
        while(l<r) {
            m = l + (r-l)/2;
            if(isPossible(dist, hour, m)) {
                r = m;
            } else {
                l = m+1;
            }
        }
        
        return l;
    }
    
    public boolean isPossible(int[] dist, double hour, int s) {
        int h = 0;
        for(int i=0; i<n-1; i++) {
            h += (dist[i]+s-1)/s;
        }
        double dh = h+(1d*dist[n-1])/s;
        return dh<=hour;
    }
}