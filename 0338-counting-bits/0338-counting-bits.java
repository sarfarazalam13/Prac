class Solution {
    public static int[] countBits(int n) {
        int[] result = new int[n+1];
        count(result, 1, 1, n+1);
        return result;
    }

    protected static void count(int[] result, int count, int i, int n) {
        if (i >= n) {
            return;
        }
        result[i] = count;
        count(result, count, i*2, n);
        count(result, count+1, i*2 + 1, n);
    }
}