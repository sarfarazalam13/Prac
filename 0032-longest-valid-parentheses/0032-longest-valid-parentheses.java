class Solution {
    public int longestValidParentheses(String s) {
        int open = 0, close = 0;
        int len = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if(open==close){
                max=Math.max(max,open+close);
            }
            else if(close>open){
                open=close=0;
            }
        }

        open = close = len = 0; // Reset counters and length
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                close++;
            } else {
                open++;
            }
            if(open==close){
                max=Math.max(max,open+close);
            }
            else if(close<open){
                open=close=0;
            }
        }

        return max;
    }
}