class Solution {
     public String convert(String s, int numRows) {
        var length = s.length();
        if (numRows == 1 || numRows >= length) return s;
        var memo = new char[length];
        var step = 2 * numRows - 2;
        var p = 0;
        for (var i = 0; i < numRows; i++) {
            var next = i;
            while (next < length) {
                memo[p] = s.charAt(next);
                next += step;
                var nextInc = next - 2 * i;
                if (i > 0 && i < numRows - 1 && nextInc < length)
                    memo[++p] = s.charAt(nextInc);

                p++;
            }
        }

        return new String(memo);
    }
}