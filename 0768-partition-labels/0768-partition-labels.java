class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer>list=new ArrayList<>();
        char []arr=s.toCharArray();
        int temp=0;
        int []vis=new int[26];
        int lastVal=0;
        for(int i=0;i<arr.length;i++)
        {
            char ch=arr[i];
            vis[ch-'a']=1;
            temp=s.lastIndexOf(ch);
            
            while(i<=temp)
            {
                if(vis[arr[i]-'a']==1)
                {
                    i++;
                    continue;
                }
                ch=arr[i];
                vis[ch-'a']=1;
                temp=Math.max(s.lastIndexOf(ch),temp);
                //System.out.println(temp);
                i++;
            }

            list.add(i-lastVal);
            lastVal=i;
            i--;
        }
        return list;
    }
}