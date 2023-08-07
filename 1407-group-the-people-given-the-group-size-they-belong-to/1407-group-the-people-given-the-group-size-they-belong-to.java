class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        
    HashMap<Integer,ArrayList<Integer>>mp=new HashMap<>();
    List<List<Integer>>ans=new ArrayList<>();


    for(int i=0;i<groupSizes.length;i++){

    if(!mp.containsKey(groupSizes[i])){
        mp.put(groupSizes[i],new ArrayList<Integer>());
    }
    mp.get(groupSizes[i]).add(i);

    }

    for(int s:mp.keySet()){

    int size=mp.get(s).size()/s;
    for(int i=0;i<size;i++){

    int start=0;

    List<Integer>temp=new ArrayList<>();

    for(;start<s;start++){

    temp.add(mp.get(s).get(start));

    }

    ans.add(temp);

    }


    }

    return ans;

    }
} 