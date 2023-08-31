class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        String[] board = new String[n];
        Arrays.fill(board, ".".repeat(n));
        int[] leftrow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];
        solve(0, board, ans, leftrow, upperDiagonal, lowerDiagonal, n);
        return ans;
    }

    private void solve(int col, String[] board, List<List<String>> ans, int[] lr, int[] ud, int[] ld, int n) {
        if (col == n) {
            ans.add(new ArrayList<>(Arrays.asList(board)));
            return;
        }
        for (int row = 0; row < n; row++) {
            if (lr[row] == 0 && ld[row + col] == 0 && ud[n - 1 + col - row] == 0) {
                char[] charArray = board[row].toCharArray();
                charArray[col] = 'Q';
                board[row] = new String(charArray);
                lr[row] = 1;
                ld[row + col] = 1;
                ud[n - 1 + col - row] = 1;
                
                solve(col + 1, board, ans, lr, ud, ld, n);
                
                charArray[col] = '.';
                board[row] = new String(charArray);
                lr[row] = 0;
                ld[row + col] = 0;
                ud[n - 1 + col - row] = 0;
            }
        }
    }
}