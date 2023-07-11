class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        findDistance(root, target, k, 0, ans);

        return ans; 
    }

    private int findDistance(TreeNode root, TreeNode target, int k, int level, List<Integer> ans){
        if(root == null){
            return -1;
        }


        if(root.val == target.val){
            findKDistanceNodes(root, k, ans);
            return level;
        }

        int dist = findDistance(root.left, target, k, level + 1, ans);

        if(dist != -1){

            int diff = k - (dist - level);
            if(diff == 0) ans.add(root.val);
            else if(diff > 0){
                findKDistanceNodes(root.right, diff - 1, ans);
            }

        }
        else{
            dist = findDistance(root.right, target, k, level + 1, ans);

            if(dist != -1){

                int diff = k - (dist - level);
              
                if(diff == 0) ans.add(root.val);
                else if(diff > 0){
                    findKDistanceNodes(root.left, diff - 1, ans);
                }

            }

        }

        return dist;
    }



    private void findKDistanceNodes(TreeNode root, int dist, List<Integer> ans){

        if(root == null) return;

        if(dist == 0){
            ans.add(root.val);
            return;
        }

        findKDistanceNodes(root.left, dist - 1, ans);
        findKDistanceNodes(root.right, dist - 1, ans);
    }
}