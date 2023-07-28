class Solution {
    public int partitionString(String s) {
        int sL = s.length();
        int bitMask = 0;
        int numParts = 1;

        byte[] chars = new byte[sL];
        s.getBytes(0, sL, chars, 0);

        for (byte c : chars) {
            int charMask = 1 << c;

            if ((bitMask & charMask) != 0) {
                ++numParts;
                bitMask = charMask;
            } else {
                bitMask += charMask;
            }
        }

        return numParts;
    }
}
/*Time: O(n)
Space: O(n)*/