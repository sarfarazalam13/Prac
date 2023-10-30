class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l=0,h=nums.length-1;
        int arr[]=new int[2];
        arr[0]=-1;
        arr[1]=-1;
        while(l<h)
        {
            int sum=nums[l]+nums[h];
            if(sum==target)
            {
                arr[0]=l+1;
                arr[1]=h+1;
                return arr;
            }
           else if(sum<target)
            {
                l++;
            }
            else
            {
                h--;
            }

        }
        return arr;
    }
}