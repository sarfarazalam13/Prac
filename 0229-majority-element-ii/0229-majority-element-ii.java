class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer>ans=new ArrayList<>();
        int ele1=Integer.MIN_VALUE,ele2=Integer.MIN_VALUE,cnt1=0,cnt2=0;
        for(int i=0;i<nums.length;i++)
        {
            if(cnt1==0 && ele2!=nums[i])
            {
                cnt1=1;
                ele1=nums[i];
            }
            else if(cnt2==0 && ele1!=nums[i])
            {
                cnt2=1;
                ele2=nums[i];
            }
            else if(nums[i]==ele1)cnt1++;
            else if(nums[i]==ele2)cnt2++;
            else
            {
               cnt1--;
               cnt2--;
            }
        }
       cnt1=cnt2=0;
       for(int i=0;i<nums.length;i++)
       {
           if(ele1==nums[i])cnt1++;
           if(ele2==nums[i])cnt2++;
       }
       int min=(int)(nums.length/3)+1;
       if(cnt1>=min)ans.add(ele1);
       if(cnt2>=min)ans.add(ele2);
       Collections.sort(ans);
        return ans; 
    }
}