class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

    int[] inDegree = new int[n];
    int root = -1;

    // If inDegree of any node > 1, return false
    for (final int child : leftChild)
      if (child != -1 && ++inDegree[child] == 2)
        return false;

    for (final int child : rightChild)
      if (child != -1 && ++inDegree[child] == 2)
        return false;

    // Find the root (node with inDegree == 0)
    for (int i = 0; i < n; ++i)
      if (inDegree[i] == 0)
        if (root == -1)
          root = i;
        else
          return false; // Multiple roots

    // didn't find the root
    if (root == -1)
      return false;

    // Perform DFS from the root
        boolean[] visited = new boolean[n];
        if(!dfs(root, leftChild, rightChild, visited)) return false;

        //Return false if there exists any node that cannot be reached from the root.
        for(boolean v: visited) if(!v) return false;
        return true;
    }

    private boolean dfs(int source, int[] leftChild, int[] rightChild, boolean[] visited) {
        visited[source] = true;
        int left = leftChild[source], right = rightChild[source];
        
        if(left >= 0) {
            if(visited[left] || !dfs(left, leftChild, rightChild, visited)) return false;
        }

        if(right >= 0) {
            if(visited[right] || !dfs(right, leftChild, rightChild, visited)) return false;
        }

        return true;
    }
}