//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            long L = Long.parseLong(input_line[1]); 
            long R = Long.parseLong(input_line[2]); 
            input_line = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);
            Solution ob = new Solution();
            long ans = ob.countSubarray(N, A, L, R); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
     long countSubarray(int N,int A[],long L,long R) {
        // code here
        int i=0,j=0;
        long sum=0;
        long count=0;
        for(i=0;i<N;i++)
        {
            sum+=A[i];
            while(sum>L-1)
            {
                sum-=A[j];
                j++;
            }
            count+=(i-j+1);
        }
        j=0;i=0;
        long count2=0;
        sum=0;
        for(i=0;i<N;i++)
        {
            sum+=A[i];
            while(sum>R)
            {
                sum-=A[j];
                j++;
            }
            count2+=(i-j+1);
        }
        if(count2>=count)
        {
            return count2-count;
        }
        return count-count2;

}
} 