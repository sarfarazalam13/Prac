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
    public int maxAncestorDiff(TreeNode root) {
     int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE; 
     return md(root,max,min);      
    }
    int md(TreeNode root,int max,int min)
    {
        if(root==null)
        {
            return max-min;
        }
        max=Math.max(max,root.val);
        min=Math.min(min,root.val);

        int l=md(root.left,max,min);
        int r=md(root.right,max,min);
        return Math.max(l, r);
    }
}