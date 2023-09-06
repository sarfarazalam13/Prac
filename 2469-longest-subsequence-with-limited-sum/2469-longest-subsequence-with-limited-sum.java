class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int ans[]=new int[queries.length];
        Arrays.sort(nums); 
     
        int sum=0,count=0;
        for(int i=0;i<queries.length;i++)
        {
           
           for(int j=0;j<nums.length;j++)
           {
             sum+=nums[j];
              if(sum <= queries[i]){
                    count++;
                }
                else{
                    break;
                }
           }

                ans[i] = count;
            count = 0;
            sum = 0;
           
        }
        return ans;
    }
}