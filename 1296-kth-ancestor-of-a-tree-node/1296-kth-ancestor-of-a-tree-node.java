class TreeAncestor {
    int a[][];
    public TreeAncestor(int n, int[] parent) {
        a=new int[n][21];
        for(int i=0;i<n;i++)
        a[i][0]=parent[i];
        for(int i=1;i<21;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(a[j][i-1]==-1)
                a[j][i]=-1;
                else
                a[j][i]=a[a[j][i-1]][i-1];
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        int curr=node;
        for(int i=20;i>=0;i--)
        {
            if(curr==-1)
            break;
            int ans=k & (1<<i);
            if(ans!=0)
            curr=a[curr][i];
        }
        return curr;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */