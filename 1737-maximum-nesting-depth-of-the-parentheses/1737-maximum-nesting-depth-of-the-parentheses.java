class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        
        int maxDepth = 0;
        int count = 0;
        
        for(int i = 0 ; i < n; i++){
            char ch = s.charAt(i);
            if(ch =='('){
                count ++;
                if(count > maxDepth){
                    maxDepth = count;
                }
            }
            else if(ch == ')'){
                count --;
            }
        }
        
        return maxDepth;
    }
}