class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = 0;
        for (char c : s.toCharArray()) {
            while (index < t.length() && c != t.charAt(index)) {
                index++;
            }
            if (index == t.length()) return false;
            index++;
        }
        return true;
    }
}