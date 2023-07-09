class Solution {
    public int minimumOperations(int[] nums) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int num:nums)
        {pq.offer(num);}
        int temp=-1;
        int res=0;
        for(int i=0;i<nums.length;i++)
        {
            int p=pq.poll();
            if(p==0||p==temp)
            {
                continue;
            }
            temp=p;
            res++;
        }
        return res;
    }
}