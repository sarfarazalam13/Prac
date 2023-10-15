//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner ob=new Scanner(System.in);
		int t=ob.nextInt();
		while(t-->0)
		{
		    long n=ob.nextLong();
		    Solution ab=new Solution();
		    long k=ab.findNth(n);
		    System.out.println(k);
		}
	}
}

    

// } Driver Code Ends


//User function Template for Java

class Solution {

    long findNth(long N)

    {

        //code here

        StringBuilder sb=new StringBuilder();

        long m=0;

        while(N>0){

            sb.append((char)(N%9+'0'));

            N/=9;

        }

        return Long.valueOf(sb.reverse().toString());

    }

}