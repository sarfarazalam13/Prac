class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
        
        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{i, 0});
        }
        
        for (int i = 0; i < k - 1; i++) {
            int[] cur = minHeap.poll();
            int row = cur[0];
            int col = cur[1];
            if (col < n - 1) {
                minHeap.offer(new int[]{row, col + 1});
            }
        }
        
        int[] kthSmallestElement = minHeap.poll();
        return matrix[kthSmallestElement[0]][kthSmallestElement[1]];
    }
}
