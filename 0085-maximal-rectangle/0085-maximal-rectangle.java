class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length < 1) return 0;
        int[] bars = new int[matrix[0].length];
        add(bars, matrix[0]);
        int maxArea = largestRectangleArea(bars);
        for (int y = 1; y < matrix.length; y++) {
            add(bars, matrix[y]);
            maxArea = Math.max(maxArea, largestRectangleArea(bars));
        }
        return maxArea;
    }

    private void add(int[] c1, char[] c2) {
        for (int i = 0; i < c2.length; i++)
            if (c2[i] == '1') c1[i]++;
            else c1[i] = 0;
    }

    public int largestRectangleArea(int[] heights) {
        int[] stack = new int[heights.length];
        int p = -1, i = 0, max = 0;
        while (i <= heights.length) {
            // NB: this doesn't run when i == heights.length
            // if stack is empty or current height > top of stack, i.e. heights no longer strictly increasing
            if (p == -1 || (i < heights.length && heights[i] > heights[stack[p]])) stack[++p] = i++;
            else { // right - left -1
            // if stack is empty, prev is obv -1
                max = Math.max(max, heights[stack[p]] * (i - (p > 0 ? stack[p-1] : -1) - 1));
                p--; //pop the stack
            }
        }
        return max;
    }
}