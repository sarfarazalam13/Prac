class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        countSort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        
        for (int i=0; i<arr.length-1; i++) {
            min = Math.min(min, arr[i+1]-arr[i]);
        }
        
        for (int i=0; i<arr.length-1; i++) {
            int diff = arr[i+1]-arr[i];
            if (diff==min) {
                res.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }
        
        return res;
    }
    
    private void countSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int num:nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        
        boolean[] values = new boolean[max-min+1];
        
        for (int num:nums) {
            values[num-min]=true;
        }
        
        int idx=0;
        for (int i=0; i<values.length; i++) {
            if (values[i]) {
                nums[idx++]=min;
            }
            min++;
        }
    }
}