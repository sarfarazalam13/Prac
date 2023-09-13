class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] LtoR = new int[n];//LtoR(Left to right)
        int[] RtoL = new int[n];//RtoL(Right to left)
        for(int i=0; i<n; i++){
            LtoR[i]=RtoL[i]=1;// assign each element value as 1
        }
        for(int i=1; i<n;i++){
            if(ratings[i]>ratings[i-1]){
                LtoR[i]=LtoR[i-1]+1;
            }
        }
        for(int i=n-2; i>=0; i--){
            if(ratings[i]>ratings[i+1]){
                RtoL[i]=RtoL[i+1]+1;
            }
        }
        int[] ans = new int[n];
        int sum =0;
        for(int i=0; i<n; i++){
            ans[i] = Math.max(LtoR[i],RtoL[i]);
            sum += ans[i];
        }
        return sum;
    }
}