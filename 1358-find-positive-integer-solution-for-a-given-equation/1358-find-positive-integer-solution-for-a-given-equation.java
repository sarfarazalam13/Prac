 

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 1, j = z,k = 1000;
        while(k --> 0 && i >= 1 && j >= 1) {
            if(customfunction.f(i, j) == z) {
                ans.add(Arrays.asList(i, j));
                i++;
            }
            else if(customfunction.f(i, j) > z) {
                j--;
            }
            else{
                i++;  }
        }
        return ans;
    }
}