class Solution {
    public int rectangleArea(int[][] rectangles) {
        int n = rectangles == null ? 0 : rectangles.length;
        if (n == 0) return 0;
        long xmin = Long.MAX_VALUE;
        long ymin = Long.MAX_VALUE;
        long xmax = Long.MIN_VALUE;
        long ymax = Long.MIN_VALUE;
        for(int[] r: rectangles) {
            if (r[0] < xmin) xmin = r[0];
            if (r[1] < ymin) ymin = r[1];
            if (r[2] > xmax) xmax = r[2];
            if (r[3] > ymax) ymax = r[3];
        }
        Node root = new Node(xmin, ymin, xmax, ymax, false);
        for(int[] r: rectangles) {
            root.add(r[0], r[1], r[2], r[3]);
        }
        return (int)(root.getFilledArea() % 1000000007L);
    }
    static class Node {
        long x1, y1, x2, y2;
        boolean filled;
        Node tl, tr, bl, br;
        Node(long x1, long y1, long x2, long y2, boolean filled) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
            this.filled = filled;
        }
        void add(int x1, int y1, int x2, int y2) {
            if (tl == null && filled) {
                return;
            }
            if (x1 >= this.x2 || x2 <= this.x1 || y1 >= this.y2 || y2 <= this.y1) {
                return;
            }
            if (x1 <= this.x1 && y1 <= this.y1 && x2 >= this.x2 && y2 >= this.y2) {
                filled = true;
                tl = tr = bl = br = null;
                return;
            }
            if (tl == null) {
                long x = this.x1 < x1 ? x1 : Math.min(x2, this.x2);
                long y = this.y1 < y1 ? y1 : Math.min(y2, this.y2);
                bl = new Node(this.x1, this.y1, x, y, false);
                br = new Node(x, this.y1, this.x2, y, false);
                tl = new Node(this.x1, y, x, this.y2, false);
                tr = new Node(x, y, this.x2, this.y2, false);
            }
            bl.add(x1, y1, x2, y2);
            br.add(x1, y1, x2, y2);
            tl.add(x1, y1, x2, y2);
            tr.add(x1, y1, x2, y2);
        }
        long getFilledArea() {
            long area;
            if (tl == null) {
                area = filled ? (x2-x1) * (y2-y1) : 0;
            } else {
                area = tl.getFilledArea() + tr.getFilledArea() + bl.getFilledArea() + br.getFilledArea();
            }
            return area;
        }
    }
}