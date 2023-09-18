class Solution {
    public int[] kWeakestRows(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int [] soldersInRow = new int[rows];
        // now update solders In each Row
        updateSolderCountInRowsBinarySearch(soldersInRow, matrix, 1);
        // below index denotes count of soldiers and value denotes the index in the respective column upto which the row numbers are filled
        // corresponding to number of soldiers...!
        int [] lastIndexFilledInSoldierCnt = new int[cols+1];
        int [] maximumCntSolderColumn = new int[rows];
        Arrays.fill(lastIndexFilledInSoldierCnt , -1);
        for (int r = 0; r < rows; r++) {
            int cnt = soldersInRow[r];
            // cnt represents soldier cnt in row r, and we have to update int index cnt column of matrix
            // i.e., cnt = 0 --> column 0, cnt of soldiers == 0 that column needs to be updated
            // with whatever rows that has cnt = 0.
            int rowNum = lastIndexFilledInSoldierCnt[cnt];
            if(cnt == cols){
                maximumCntSolderColumn[rowNum+1] = r;
                lastIndexFilledInSoldierCnt[cnt]++;
            }else {
                if(cnt<cols) matrix[rowNum+1][cnt] = r;
                lastIndexFilledInSoldierCnt[cnt]++;
            }
        }
        int []ans = new int[k];
        int idx = 0;
        int i = 0;
        for (int c = 0; c < cols; c++) {
            idx = lastIndexFilledInSoldierCnt[c];
            if(idx > -1){
                for (int r = 0; r <= idx; r++) {
                    ans[i] = matrix[r][c];
                    i++;
                    if(i == k) return ans;
                }
            }
        }
        idx = lastIndexFilledInSoldierCnt[cols];
        for (int r = 0; r <= idx; r++) {
            ans[i] = maximumCntSolderColumn[r];
            i++;
            if(i == k) return ans;
        }
        return ans;
    }
    private static void updateSolderCountInRowsBinarySearch
    (int[] soldersInRow, int[][] matrix, int target) {
        for (int r = 0; r < soldersInRow.length; r++) {
            int first = firstIndexUsingBinarySearch
            (matrix[r], target, matrix[0].length);
            int last = lastIndexUsingBinarySearch
            (matrix[r], target, matrix[0].length);
            if(first == -1) soldersInRow[r] = 0;
            else soldersInRow[r] = (last-first+1);
        }
    }
    private static int firstIndexUsingBinarySearch
    (int[] arr, int target, int n) {
        // first index if not found
        // here array is sorted in descending order...!
        int low = 0;
        int high = n-1;
        while (low <= high){
            int mid = low+(high-low)/2;
            if(arr[mid] < target) high = mid-1;
            else if (arr[mid] > target) low = mid+1;
            else { // arr[mid] == target
                if(mid == 0) return 1;
                else if (arr[mid-1] != target) return mid+1;
                else high = mid-1;
            }
        }
        return -1;
    }
    private static int lastIndexUsingBinarySearch
    (int[] arr, int target, int n) {
        // last index if not found
        int low = 0;
        int high = n-1;
        while (low <= high){
            int mid = low+(high-low)/2;
            if(arr[mid] < target) high = mid-1;
            else if (arr[mid] > target) low = mid+1;
            else { // arr[mid] == target
                if(mid == n-1) return n;
                else if (arr[mid+1] != target) return mid+1;
                else low = mid+1;
            }
        }
        return -1;
    }
}