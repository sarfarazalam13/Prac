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
    public TreeNode createBinaryTree(int[][] descriptions) {
        TreeNode [] nodes=new TreeNode[100001];
        int []count=new int[100001];
        for(int []arr:descriptions){
            int par=arr[0];
            int chi=arr[1];
            boolean isl=(arr[2]==1);
            if(nodes[par]==null){
                nodes[par]=new TreeNode(par);
            }
            if(nodes[chi]==null){
                nodes[chi]=new TreeNode(chi);
            }
            TreeNode parent=nodes[par];
            TreeNode children=nodes[chi];
            if(isl){
                parent.left=children;
            }
            else{
                parent.right=children;
            }
            count[chi]=-1;
            if(count[par]>=0){
                count[par]=1;
            }
        }
        for(int i=1;i<=100001;i++){
            if(count[i]==1)return nodes[i];
        }
        return null;
    }
}