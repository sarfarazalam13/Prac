class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
          int max=0;
          int c=0;
          for(int i=0; i<nums.length; i++)
          {
              if(nums[i]==0)
              {
                  if(max<c)
                     max=c;

                     c=0;
              }
              else{
                  c++;
              }
          } 
          return max >c ? max:c; 
    }
}