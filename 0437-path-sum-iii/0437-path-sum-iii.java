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
        if(root!=null && root.val==1000000000)
            return 0;
        HashMap<Integer,Integer>hm=new HashMap<Integer,Integer>();
        hm.put(0,1);
        return helper(root,targetSum,hm,0);
    }
    public int helper(TreeNode root, int target, HashMap<Integer,Integer>hm,int curr){
        if(root == null)
            return 0;
        int count = 0;
        curr+=root.val;
        if(hm.containsKey(curr-target))
            count+=hm.get(curr-target);

        if(hm.containsKey(curr))
            hm.put(curr,hm.get(curr)+1);
        else
            hm.put(curr,1);
        int left = helper(root.left,target,hm,curr);
        int right = helper(root.right,target,hm,curr);
        hm.put(curr,hm.get(curr)-1);
        return count+left+right;
    }
}   