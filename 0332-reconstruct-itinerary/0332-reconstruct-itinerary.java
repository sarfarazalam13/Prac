class Solution {
    // Since the answer has to be sorted lexicographically, we will sort the inputs and the first valid answer we get will be the final answer
    
    public List<String> findItinerary(List<List<String>> tickets) {
        // asnwer will have a size of tickets+1
        LinkedList<String> ans =new LinkedList<>(); // because we will need the insert at begining function.

        // We will use hashmap to store the adjacency list
        // we will use a priority queue for sorting 
        HashMap<String,PriorityQueue<String>> adj=new HashMap<>();

        // Initializing
        for(List<String> ticket:tickets){
            String u=ticket.get(0);
            String v=ticket.get(1);

            adj.putIfAbsent(u,new PriorityQueue<String>());
            adj.get(u).add(v);
        }

        // Starting location will always be JFK
        // Ending can be anything

        // We will start computing from jfk and for every destination we go to we remove that link from our adj list
        // if an answer cannot be formed we will backtrack and add that link again

        dfs("JFK",adj,ans);
        return ans;
    }
    public void dfs(String src,HashMap<String,PriorityQueue<String>> adj,LinkedList<String> ans){
        PriorityQueue<String> temp=adj.get(src);

        while(temp!=null && temp.size()>0){
            String s=temp.poll();
            dfs(s,adj,ans);
        }
        ans.addFirst(src);
        return;
    }
}