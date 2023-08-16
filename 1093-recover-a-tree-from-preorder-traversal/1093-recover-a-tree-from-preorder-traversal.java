class Solution {
    public TreeNode recoverFromPreorder(String S) {
        
        if (S == null || S == "") {
            return null;
        }
        return recover(S.toCharArray(), new int[]{0}, 0);
    }
    
    public TreeNode recover(char[] arr, int[] index, int level) {
        int count = 0;
        int start = index[0];
        
        while (start < arr.length && arr[start] == '-') {
            start++;
            count++;
        }
        if (count != level) {
            return null;
        }
        int num = 0;
        while (start < arr.length && arr[start] != '-') {
            int temp = arr[start] - '0';
            num = num * 10 + temp;
            start++;
        }
        TreeNode root = new TreeNode(num);
        index[0] = start; 
        root.left = recover(arr, index, level + 1);
        root.right = recover(arr, index, level + 1);
        return root;
    }
}