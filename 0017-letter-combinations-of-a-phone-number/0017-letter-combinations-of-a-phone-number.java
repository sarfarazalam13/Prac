class Solution {

    char[][] buttons = new char[][]{
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };
    List<String> res;

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        res = new ArrayList<>();
        traverse(1, buttons[digits.charAt(0) - '0' - 2], digits, new StringBuilder());
        return res;
    }

    private void traverse(int idx, char[] button, String digits, StringBuilder sb) {
        if (sb.length() >= digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < button.length; i++) {
            sb.append(button[i]);
            if (idx >= digits.length()) {
                traverse(idx + 1, button, digits, sb);
            } else {
                traverse(idx + 1, buttons[digits.charAt(idx) - '0' - 2], digits, sb);
            }
            sb.setLength(sb.length() - 1);
        }
    }
}