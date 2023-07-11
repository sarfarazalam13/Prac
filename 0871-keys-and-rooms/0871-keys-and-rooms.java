class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] vis=new boolean[n];
        int visitedN=0;
        visit(rooms,0,vis);
        for(int i=0; i<n; i++){
            if(vis[i]) visitedN++;
        }
        if(visitedN == n) return true;
        else return false;
    }
    void visit(List<List<Integer>> rooms, int i, boolean [] visited) {
        if(visited[i]) return;


        visited[i] = true;

        List<Integer> keys = rooms.get(i);
        for(Integer next : keys){
            visit(rooms, next, visited);
        }
}
}