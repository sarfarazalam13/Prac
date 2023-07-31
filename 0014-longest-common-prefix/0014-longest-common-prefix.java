class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (String str : strs) {
            if (str.length() < prefix.length()) prefix = str;
        }

        while (prefix.length() > 0) {
            boolean allMatch = true;
            for (String str : strs) {
                if (!str.startsWith(prefix)) allMatch = false;
            }
            if (allMatch) break;
            prefix = prefix.substring(0, prefix.length()-1);
        }

        return prefix;
    }
}