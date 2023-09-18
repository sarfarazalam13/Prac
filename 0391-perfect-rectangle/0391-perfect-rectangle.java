class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if(rectangles == null || rectangles.length == 0 || rectangles[0].length == 0) return false;

        int x1 = Integer.MAX_VALUE,
            y1 = Integer.MAX_VALUE,
            x2 = Integer.MIN_VALUE,
            y2 = Integer.MIN_VALUE;

        long area = 0;
        Set<int[]> set = new TreeSet<>((int[] a, int[] b) -> {
            if (a[3] <= b[1]) {
                return -1;
            } else if (a[1] >= b[3]) {
                return 1;
            } else if (a[2] <= b[0]) {
                return -1;
            } else if (a[0] >= b[2]) {
                return 1;
            } else return 0;
        });


        for(int[] rect : rectangles){
            x1 = Math.min(rect[0],x1);
            y1 = Math.min(rect[1],y1);
            x2 = Math.max(rect[2],x2);
            y2 = Math.max(rect[3],y2);

            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
            if(!set.add(rect)) return false;
        }
        return area == (x2 - x1) * (y2 - y1);
    }
}