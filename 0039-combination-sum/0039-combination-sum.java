class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        helper(0,candidates, target,ans,ds);
        return ans;
    }
    public void helper(int index,int arr[],int remain,List<List<Integer>> ans,List<Integer> ds){
        if(index==arr.length){
            if(remain==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[index]<=remain){
            ds.add(arr[index]);
            helper(index,arr,remain-arr[index],ans,ds);
            ds.remove(ds.size()-1);
        }
        helper(index+1,arr,remain,ans,ds);
    }
}