class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        
        List<List<Integer>> listOLists = new ArrayList<>();
        for(int i=0;i<groupSizes.length;i++){
            if(groupSizes[i]!=0){
                List<Integer> l1=new ArrayList<>();
                int size=groupSizes[i];
                int s=size;
                for(int j=i;j<groupSizes.length;j++){
                    if(size==0)
                        break;
                    if(groupSizes[j]==s){
                        size--;
                        l1.add(j);
                        groupSizes[j]=0;
                    }
                }
                listOLists.add(l1);
            } 
        }
        return listOLists;
    }
}