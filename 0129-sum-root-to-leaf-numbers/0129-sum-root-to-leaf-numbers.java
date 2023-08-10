/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int helper(TreeNode root, int numSoFar) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return numSoFar * 10 + root.val;

        numSoFar = numSoFar * 10 + root.val;

        return helper(root.left, numSoFar) + helper(root.right, numSoFar);
    }
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
}