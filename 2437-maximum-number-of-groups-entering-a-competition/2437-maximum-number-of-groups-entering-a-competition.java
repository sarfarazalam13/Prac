class Solution {
    public int maximumGroups(int[] grades) {
        int length = grades.length;
        int b24ac = (int)Math.sqrt(1 + (8*length));
        return (-1 + b24ac)/2;
    }
}