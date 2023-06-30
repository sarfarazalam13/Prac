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
       diameterOfTree(root);
       return max;
        
    }

    int max=0; //also do it via an array of size 1 as it is pass by ref

    int diameterOfTree(TreeNode root)
    {
     if(root==null)
        {
            return 0;
        }
        int lh=diameterOfTree(root.left);
        int rh=diameterOfTree(root.right);
        max=Math.max(max,lh+rh);
        return 1+Math.max(lh,rh);
    }
}