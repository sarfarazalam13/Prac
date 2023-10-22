class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int low = -1, high = -1, sum = 0;
        for(int val : weights){
            low = Math.max(val, low);
            sum += val;
        }
        high = low * (weights.length / days + Integer.signum(weights.length % days));
        low = Math.max(low, sum / days);

        //apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            if (possible(weights, mid, days)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static boolean possible(int[] weights, int cap, int days) {
        int load = 0;
        for(int val : weights){
            if (load + val > cap){
                days--;
                load = 0;
            }
            load += val;
        }
        return days > 0;
    }
}