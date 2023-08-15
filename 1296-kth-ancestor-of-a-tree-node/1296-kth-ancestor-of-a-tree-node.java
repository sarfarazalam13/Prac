class TreeAncestor {
    
  int MAX_ROWS = 16;
  int table[][];

  public TreeAncestor(int n, int[] parent) {
    table = new int[MAX_ROWS][n];
    for (int i = 0; i < n; i++) {
      table[0][i] = parent[i];
    }
    for (int i = 1; i < MAX_ROWS; i++) {
      for (int j = 0; j < n; j++) {
        if (table[i - 1][j] == -1) table[i][j] = -1; else table[i][j] =
          table[i - 1][table[i - 1][j]];
      }
    }
  }

  public int getKthAncestor(int node, int k) {
    int j = node;
    int ans = 0;
    for (int i = 15; i >= 0; i--) {
      if (j == -1) return -1;
      int mask = 1 << i;
      if ((mask & k) != 0) {
        j = table[i][j];
      }
    }
    return j;
  }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */