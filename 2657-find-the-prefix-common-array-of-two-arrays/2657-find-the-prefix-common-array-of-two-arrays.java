class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int cur=0, ans[]=new int[A.length],seen[]=new int[A.length+1];

        for(int i=0;i<A.length;i++)
        {
         if (++seen[A[i]] == 2)
                cur++;
            if (++seen[B[i]] == 2)
                cur++;
            ans[i] = cur;  

        }
        return ans;
    }
}