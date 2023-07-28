class Solution {
    public int partitionString(String s) {
        Set<Character> checkUniqueAlphabet = new HashSet<>();
        int i = 0;
        int minCount = 0;
        while (i < s.length()) {
            minCount++;
            while (i < s.length() && !checkUniqueAlphabet.contains(s.charAt(i))) {
                checkUniqueAlphabet.add(s.charAt(i));
                i++;
            }
            checkUniqueAlphabet.clear();
        }
        return minCount;
    }
}