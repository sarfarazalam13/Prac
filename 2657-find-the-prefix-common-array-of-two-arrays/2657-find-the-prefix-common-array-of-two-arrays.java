class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int len = A.length;
        int[] res = new int[len];
        long numA = 0, numB = 0;

        for (int i = 0; i < len; i++) {
            numA |= 1L << A[i];
            numB |= 1L << B[i];

            long mask = numA & numB;
            res[i] = Long.bitCount(mask);
        }

        return res;
    }
}