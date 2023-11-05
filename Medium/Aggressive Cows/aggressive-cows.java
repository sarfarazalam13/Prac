//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    static boolean cwp(int[] stalls,int dist,int cows)
    {
        int cntcows=1,last=stalls[0];
        for(int i=1;i<stalls.length;i++)
        {
            if(stalls[i]-last>=dist)
            {
                cntcows++;
                last=stalls[i];
            }
            if(cntcows>=cows) return true;
            
        }
        return false;
    }
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int s=0,e=stalls[n-1]-stalls[0];
        while(s<=e)
        {
            int mid=(s+e)/2;
            if(cwp(stalls,mid,k)==true)
            {
                s=mid+1;
            }
            else
            {
                e=mid-1;
            }
        }
        return e;
    }
}