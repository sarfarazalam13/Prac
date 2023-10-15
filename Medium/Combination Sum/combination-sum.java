//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main (String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        
        while(t-- >0)
        {
            String str[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            ArrayList<Integer> list = new ArrayList<>();
            str = br.readLine().trim().split(" ");
            for(int i = 0; i <n ;i++)
                list.add(Integer.parseInt(str[i]));
            str = br.readLine().trim().split(" ");    
            int sum = Integer.parseInt(str[0]);
            
            Solution ob = new Solution();
            
            res = ob.combinationSum(list, sum);
            if (res.size() == 0) {
    			out.print("Empty");
    		}
 
    		// Print all combinations stored in res.
    		for (int i = 0; i < res.size(); i++) {
    			if (res.size() > 0) {
    				out.print("(");
    				List<Integer> ij = res.get(i);
    				for (int j = 0; j < ij.size(); j++) {
    				    
    					out.print(ij.get(j));
    					if(j < ij.size()-1)
    					 out.print(" ");
    				}
    				out.print(")");
    			}
    		}
    		out.println();
    		res.clear();
	    }
	    out.flush();
    }
    
}
// } Driver Code Ends


//User function template for JAVA


class Solution{
    static void Print(ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> l,ArrayList<Integer> a,int t,int index){
        if(index == a.size()){
            if(t == 0){
                ans.add(new ArrayList<>(l));
            }
            return;
        }
        //include
        if(a.get(index) <= t){
            l.add(a.get(index));
            Print(ans,l,a,t-a.get(index),index);
            l.remove(l.size() - 1);
        }
        //exclude
        Print(ans,l,a,t,index+1);
    }
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B){
        // add your code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>(A);
        A = new ArrayList<>(set);
        Collections.sort(A);
        Print(ans,new ArrayList<>(),A,B,0);
        return ans;
    }
}
