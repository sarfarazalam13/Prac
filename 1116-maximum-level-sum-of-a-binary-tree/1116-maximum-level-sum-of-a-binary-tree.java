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
    
    int n = 10001;
    int res = 0;
    int[] levelSum = new int[n];    
    int level = 0;
    public int maxLevelSum(TreeNode root) {
            
        dfs(root, 1);
        int max = Integer.MIN_VALUE;
        int maxInd = 0;
        for(int i = 1; i <= level; i++){
            if(levelSum[i] > max){
                max = levelSum[i];
                maxInd = i;
            }
            
        }
        return maxInd;
    }
    void dfs(TreeNode root, int lvl){
        if(root == null) return;
        levelSum[lvl] += root.val;
        level = Math.max(level, lvl);
        dfs(root.left, lvl+1);
        dfs(root.right, lvl+1);
        
    }
}