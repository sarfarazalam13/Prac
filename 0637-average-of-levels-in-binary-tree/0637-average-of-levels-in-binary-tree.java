class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int levelSize = q.size(); // Number of nodes in the current level
            double levelSum = 0.0; // Sum of values of nodes in the current level

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = q.poll();
                levelSum += curr.val;

                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }

            double levelAvg = levelSum / levelSize; // Calculate average for the current level
            ans.add(levelAvg);
        }

        return ans;
    }
}
