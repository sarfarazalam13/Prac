class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        char[] c = boxes.toCharArray();

        int right = 0;
        int rc = 0;
        for(int i = 0; i < n; i++) {

            if(c[i] == '1') {
                right += i;
                rc++;
            }
        }
        int left = 0;
        int lc = 0;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = right + left;
            if(c[i] == '1') {
                rc--;
                lc++;
            }
            right -= rc;
            left += lc;
        }

        return ans;
    }
}