class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        res = new ArrayList<>();
        traverse(root, 0);
        return res;
    }

    private void traverse(TreeNode root, int index) {
        if (root == null) {
            return;
        }
        if (index >= res.size()) {
            res.add(new LinkedList<>());
        }

        var curr = (LinkedList<Integer>) res.get(index);
        if (index % 2 == 0) {
            curr.add(root.val);
        } else {
            curr.addFirst(root.val);
        }

        traverse(root.left, index + 1);
        traverse(root.right, index + 1);
    }
}
 
