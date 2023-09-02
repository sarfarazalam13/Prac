class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;
}

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            insert(root, word);
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1] + 1;
            TrieNode node = root;
            for (int j = i; j < n; j++) {
                int c = s.charAt(j) - 'a';
                if (node.children[c] == null) break;
                node = node.children[c];
                if (node.isWord) {
                    dp[i] = Math.min(dp[i], dp[j + 1]);
                }
            }
        }
        return dp[0];
    }

    private void insert(TrieNode root, String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) {
                node.children[i] = new TrieNode();
            }
            node = node.children[i];
        }
        node.isWord = true;
    }
}