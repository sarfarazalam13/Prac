class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int[] point : points) {
            min = Math.min(min, point[0]);
            max = Math.max(max, point[0]);
        }

        int diff = max - min;

        if (diff == 0) {
            return 0;
        }

        int[][] buckets = new int[points.length + 1][];
        for (int[] point : points) {
            int index = (int) ((point[0] - min) * ((long) points.length) / diff);
           if (buckets[index] == null) {
                buckets[index] = new int[] {point[0], point[0]};
            } else {
                buckets[index][0] = Math.min(buckets[index][0], point[0]);
                buckets[index][1] = Math.max(buckets[index][1], point[0]);
            }
        }

        int maxWidth = 0;
        int lastMaxX = buckets[0][1];
        for (int i = 1; i < points.length + 1; i++) {
            if (buckets[i] != null) {
                maxWidth = Math.max(maxWidth, buckets[i][0] - lastMaxX);
                lastMaxX = buckets[i][1];
            }
        }
        return maxWidth;
    }
}