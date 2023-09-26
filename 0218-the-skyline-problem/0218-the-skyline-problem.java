class Solution {
    class Node {
        int index;
        int height;
        Node(int index, int height){
            this.index = index;
            this.height = height;
        }
    }
    class sortBy implements Comparator<Node> {
        public int compare(Node a, Node b){
            if(a.index-b.index>0){
                return 1;
            } else if(a.index==b.index){
                return a.height-b.height;
            }
            return a.index-b.index;
        }
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Node> list = new ArrayList<Node>();
        int height = 0;
        for(int i=0; i<buildings.length; i++){
            list.add(new Node(buildings[i][0], -1*buildings[i][2]));
            list.add(new Node(buildings[i][1], buildings[i][2]));
        }
        Collections.sort(list, new sortBy());
        List<Integer> byHeight = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while(list.size()>0){
            Node temp = list.remove(0);
            if(temp.height<0) {
                byHeight.add(temp.height*-1);
                if(temp.height*-1>height){
                    height = temp.height*-1;
                    List<Integer> ans = new ArrayList<Integer>();
                    ans.add(temp.index);
                    ans.add(temp.height*-1);
                    result.add(ans);
                } 
            } else {
                byHeight.remove(byHeight.indexOf(temp.height));
                if(temp.height==height){
                    int newHeight = byHeight.size()>0 ? byHeight.get(biggest(byHeight)) : 0;
                    if(newHeight!=height){
                        List<Integer> ans = new ArrayList<Integer>();
                        ans.add(temp.index);
                        ans.add(newHeight);
                        result.add(ans);
                    }
                    height = newHeight;
                }
            }
        }
        return result;
    }
    public int biggest(List<Integer> list){
        int max = -1, index = -1;
        for(int i=0; i<list.size(); i++){
            if(list.get(i)>max){
                max = list.get(i);
                index = i;
            }
        }
        return index;
    }
}