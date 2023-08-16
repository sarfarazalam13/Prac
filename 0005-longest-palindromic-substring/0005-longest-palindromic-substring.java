class Solution 
{
    int start = 0, end = 0;
    public String longestPalindrome(String s) 
    {
        int n = s.length();
        if (n < 2) return s;

        findLongestFrom(s.toCharArray(), 0);
        
        return s.substring(start, end + 1);
    }
    
    void findLongestFrom(char[] s, int mid) 
    {
        if (s.length - mid < (end - start) / 2) 
            return;

        int start = mid, end = mid;
        while (end < s.length - 1 && s[end] == s[end + 1]) end++;
        mid = end;

        while (start - 1 >= 0 && end + 1 < s.length && s[start - 1] == s[end + 1]) {
            start--;
            end++;
        }
        if (end - start > this.end - this.start) {
            this.start = start;
            this.end = end;
        }

        findLongestFrom(s, mid + 1);
    }
}