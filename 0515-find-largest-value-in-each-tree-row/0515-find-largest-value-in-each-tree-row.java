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

import java.util.AbstractList; 
class Solution {
    private List<Integer> res; 
    public List<Integer> largestValues(TreeNode root) {
        return new AbstractList<Integer>() {
            @Override 
            public Integer get(int index) {
                init(); 
                return res.get(index); 
            }
            @Override 
            public int size() {
                init(); 
                return res.size(); 
            }
            protected void init() {
                if (res != null)
                    return; 
                res = new ArrayList<Integer>(); 
                dfsHelper(root, -1); 
            }
        }; 
    }
    private void dfsHelper(TreeNode root, int parentDepth) {
        if (root == null)
            return; 
        ++parentDepth;
        if (res.size() == parentDepth) {
            res.add(root.val); 
        } else {
            res.set(parentDepth, Math.max(root.val, res.get(parentDepth)));
        }
        dfsHelper(root.left, parentDepth); 
        dfsHelper(root.right, parentDepth); 
    }
}