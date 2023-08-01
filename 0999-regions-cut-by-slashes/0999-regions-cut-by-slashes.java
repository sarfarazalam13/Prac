class Solution {
    static int [] rank;
    static int [] p ;
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int m = n+1;
        rank = new int[m*m];    
        p = new int[m*m];
        int ans = 1;
        
        for(int i=0;i<m*m;i++)
        {
            p[i]=i;
            rank[i]=1;
        }
        for(int i=0;i<m;i++)
        {
            union(0,i);
            union(0,m*m-1-i);
            union(0,m*i);
            union(0,m-1 + m*i);
        }
       for(int i=0;i<n;i++){
        
        char[] arr = grid[i].toCharArray();
        
        for(int j=0;j<n;j++){
           if(arr[j]=='/'){
             int p1 = m*(i+1) + j;
             int p2 = m*(i) + j+1;
             if(union(p1,p2)) ans++;
           }else if(arr[j]=='\\'){
             int p1 = m*(i) + j;
             int p2 = m*(i+1) + j+1;
             if(union(p1,p2)) ans++;
           }
         }
       }
        return ans;
    }
    static int find(int x)
    {
        if(p[x]==x) return x;
        int temp = find(p[x]);
        p[x] = temp;
        return temp;
    }
    static boolean union(int x,int y)
    {
        int px = find(x);
        int py = find(y);
        
        if(px!=py)
        {
           if(rank[px]>rank[py]) p[py] = px;   
           else if(rank[px]<rank[py])   p[px] = py;  
            else{
                p[px] = py;
                rank[py]++;
            }
            return false;
        }
        return true;
    }
}