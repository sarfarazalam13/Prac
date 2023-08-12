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
    int max=Integer.MIN_VALUE;
    Map<Integer,Integer> map=new HashMap<>();
    List<Integer> list=new ArrayList<>();
    public int[] findFrequentTreeSum(TreeNode root) {
       dfs(root);    
       
       
       int[] arr=new int[list.size()];
       int j=0;
       for(int i:list){
           arr[j++]=i;
       }
       return arr;


    }
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);
        int sum=left+right+root.val;
        int new_val=map.getOrDefault(sum,0)+1;
        map.put(sum,new_val);
        if(new_val>max){
            max=new_val;
            list.clear();
            list.add(sum);
        }
        else if(new_val==max){
            list.add(sum);
        }
        return sum;
    }
}