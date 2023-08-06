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
class FindElements {
    TreeNode root;
    Set<Integer> set = new HashSet<>();
    public FindElements(TreeNode root) {
        this.root = root;
        if(root != null){ root.val = 0; set.add(root.val); }
        recover(root,set);
    }
    
    public boolean find(int target) {
      return set.contains(target);
    }

    private void recover(TreeNode root, Set<Integer> set){
        if(root.left != null){
            root.left.val = 2 * root.val + 1;
            set.add(root.left.val);
            recover(root.left, set);
        }
       if(root.right != null){
            root.right.val = 2 * root.val + 2;
            set.add(root.right.val);
            recover(root.right, set);
       } 
    }
}
/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */