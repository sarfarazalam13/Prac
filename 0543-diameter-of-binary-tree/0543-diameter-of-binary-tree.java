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
    int ans=0;
    public int diameterOfBinaryTree(TreeNode root) {

        diam(root);
        return ans;
    }
    int diam(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int l=diam(root.left);
        int r=diam(root.right);
        ans=Math.max(l+r,ans);
        return Math.max(l,r)+1;

    }
}