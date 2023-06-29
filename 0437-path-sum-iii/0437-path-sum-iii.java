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
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)
        {
            return 0;
        }
        return summ(root,targetSum)+pathSum(root.left,targetSum)+pathSum(root.right,targetSum);
    }
    private int summ(TreeNode root,long sum)
    {
        if(root==null)
        {
            return 0;
        }
         return(sum - root.val == 0 ? 1:0) +  summ(root.left, sum - root.val) +  summ(root.right, sum - root.val);
    }
}