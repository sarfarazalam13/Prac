class Solution {
    public List<String> buildArray(int[] arr, int n) {
        List<String>ans=new ArrayList<>();
        int count=0;
        for(int i=1;i<=n;i++)
        {
            if(count==arr.length)
            {
                break;
            }
            ans.add("Push");
            if (arr[count++] != i) {
                ans.add("Pop");
                count--;
            }


        }
        return ans;
    }
}