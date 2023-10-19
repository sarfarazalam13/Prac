class Solution {
    public int minEatingSpeed(int[] piles, int h) {
    //     int low=1;
    //     int high=findMax(arr);

    //     while(low<=high){
    //        int mid=(low+high)/2;
    //         int totalhr=totalHr(arr,mid);
    //         if(totalhr<=h){
    //             high=mid-1;
    //         }else{
    //             low=mid+1;
    //         }
    //     }
    //     return low;
        
    // }
    // public int findMax(int[] arr){
    //     int n=arr.length;
    //     int max=Integer.MIN_VALUE;
    //     for(int i=0;i<n;i++){
    //         max=Math.max(max,arr[i]);
            
    //     }
    //     return max;
    // }
    // public int totalHr(int[] arr,int h){
    //     int totalh=0;
    //     int n=arr.length;
    //     for(int i=0;i<n;i++){
    //         totalh += Math.ceil((double)(arr[i]) / (double)(h));
    //     }
    //     return totalh;
     int n = piles.length;
        long s = 0;
        for (int pile : piles) {
            s += pile;
        }

        int left = (int) ((s - 1) / h) + 1;
        int right = (int) ((s - n) / (h - n + 1) + 1);
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            long totalTime = 0;
            for (int pile : piles) {
                totalTime += ((pile - 1) / mid + 1);
            }

            if (totalTime <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}