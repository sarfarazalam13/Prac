class Solution {
    public void sortColors(int[] nums) {
        int i=0,j=0,k=nums.length-1;
        while(j<=k)
        {
            if(nums[j]==0)
            {
                swap(nums,i,j);
                i++;
                j++;

            }
            else if(nums[j]==1)
            {
              j++;
            }
            else
            {
                swap(nums,j,k);
                k--;
            }
        }
        
    }
    void swap(int[] n,int x,int y)
    {
        int temp=n[x];
        n[x]=n[y];
        n[y]=temp;
    }
}

/*
class Solution {
    public void sortColors(int[] nums) {
        //dutch flag
         int i=0,j=0,k=nums.length-1;
         while(j<=k)
         {
             if(nums[j]==0)
             {
                 
                 swap(nums,j,i);
                 j++;
                 i++;
             }
             else if(nums[j]==1)
             {
                 j++;
             }
             else
             {
                     
                 swap(nums,j,k);
                 k--;
                 
             }
         }
        
    }
    void swap(int arr[],int x,int y)
    {
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
}

}*/