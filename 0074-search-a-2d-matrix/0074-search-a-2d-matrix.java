class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int l=0;
        int m=matrix.length;
        int n=matrix[0].length;;
        int r=m*n;
        while(l<r)
        {
            int mid=l+(r-l)/2;
            int i=mid/n;
            int j=mid%n;
            if(matrix[i][j]<target)
            {
                l=mid+1;
            }
            else if(matrix[i][j]==target)
            {
                return true;
            }
            else
            {
                r=mid;
            }

        }
        return false;
                
    }
}