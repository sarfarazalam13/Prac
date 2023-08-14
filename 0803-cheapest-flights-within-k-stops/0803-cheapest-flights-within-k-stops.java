class Tuple{
    int node;
    int dist;
    int stop;

    Tuple(int node,int dist,int stop){
        this.node = node;
        this.dist = dist;
        this.stop = stop;
    }
}

class Pair{
    int node;
    int wt;

    Pair(int node,int wt){
        this.node = node;
        this.wt = wt;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int dist[] = new int[n];
        Arrays.fill(dist,(int)1e9);
        dist[src] = 0;

        List<List<Pair>> adj = new ArrayList<List<Pair>>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }

        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        Queue<Tuple> queue = new PriorityQueue<Tuple>((x,y) -> x.stop - y.stop);
        queue.add(new Tuple(src,0,0));

        while(!queue.isEmpty()){
            Tuple tuple = queue.poll();
            
            for(Pair p : adj.get(tuple.node)){
                if( (tuple.dist + p.wt < dist[p.node])  && tuple.stop<=k){
                    dist[p.node] = tuple.dist + p.wt;
                    queue.add(new Tuple(p.node,dist[p.node],tuple.stop+1));
                }
            }

        }

        return dist[dst] == (int)1e9 ? -1 : dist[dst];
    }
}