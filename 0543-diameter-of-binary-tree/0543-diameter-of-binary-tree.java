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

    public int diameterOfBinaryTree(TreeNode root) {
        int d[]=new int[1];
        diam(root,d);
        return d[0];
    }
    int diam(TreeNode root,int d[])
    {
        if(root==null)
        {
            return 0;
        }
        int l=diam(root.left,d);
        int r=diam(root.right,d);
        d[0]=Math.max(l+r,d[0]);
        return 1+Math.max(l,r);
    }
}