class Solution {
  public List<List<Integer>> permute(int[] nums) {
    return permute(nums, 0);
  }

  private static List<List<Integer>> permute(int[] nums, int index) {
    int n = nums.length;
    List<List<Integer>> result = new LinkedList<>();
    if (index == n - 1) {
      List<Integer> list = new LinkedList<>();
      list.add(nums[index]);
      result.add(list);

      return result;
    }

    index++;
    List<List<Integer>> sub = permute(nums, index);
    for (List<Integer> list : sub) {
      for (int i = 0; i <= list.size(); i++) {
        List<Integer> one = new LinkedList<>(list);
        one.add(i, nums[index - 1]);
        result.add(one);
      }
    }

    return result;
  }
}