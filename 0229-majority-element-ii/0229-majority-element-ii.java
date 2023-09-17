 class Solution {
    public List<Integer> majorityElement(int[] nums) {
        return takeMyKnees(nums);
    }

    public List<Integer> takeMyKnees(int[] nums) {
        List<Integer> list = new ArrayList();

        quickSort(nums, 0, nums.length - 1, list);

        return list;
    }

    public void quickSort(int[] nums, int lo, int hi, List<Integer> ans) {
        if (hi - lo + 1 <= nums.length / 3) {
            return;
        }

        int left = lo;
        int right = hi;
        int i = lo + 1;

        while (right >= i) {
            if (nums[left] > nums[i]) {
                swap(nums, left, i);
                i++;
                left++;
            } else if (nums[left] < nums[i]) {
                if (nums[i] > nums[right]) {
                    swap(nums, i, right);
                }
                right--;
            } else {
                i++;
            }
        }

        if (right - left >= nums.length / 3) {
            ans.add(nums[left]);
        }

        quickSort(nums, lo, left - 1, ans);
        quickSort(nums, right + 1, hi, ans);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
 }