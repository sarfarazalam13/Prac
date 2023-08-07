 
class Solution {
    List<String> res = new ArrayList<>();
    public int sumRootToLeaf(TreeNode root) {
        _sum(root, "");
        int count = 0;
        for(String s : res){
            System.out.println(s);
            count+=Integer.parseInt(s, 2);
        }
        
        return count;
    }
    private void _sum(TreeNode root, String str){
        if(root == null){
            
            return;
        }
        if(root.left == null && root.right == null) {
            str += root.val;
            res.add(str);
            return;
        }
        str += ""+ root.val;
        _sum(root.left, str);
        _sum(root.right, str);
        return;
    }
}