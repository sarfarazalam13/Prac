class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        // int rows = maze.length;
        // int columns = maze[0].length;
        // Queue<int[]> queue = new LinkedList<>();
        // queue.offer(entrance);
        // maze[entrance[0]][entrance[1]] = '+';
        // int[][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        // int steps = 0;
        // int x, y;
        // while (!queue.isEmpty()) {
        //     steps++;
        //     int n = queue.size();
        //     for (int i = 0; i < n; i++) {
        //         int[] current = queue.poll();
        //         for (int[] direction : directions) {
        //             x = current[0] + direction[0];
        //             y = current[1] + direction[1];
        //             if (x < 0 || x >= rows || y < 0 || y >= columns)
        //                 continue;
        //             if (maze[x][y] == '+')
        //                 continue;
        //             if (x == 0 || x == rows - 1 || y == 0 || y == columns - 1)
        //                 return steps;
        //             maze[x][y] = '+';
        //             queue.offer(new int[]{x, y});
        //         }
        //     }
        // }
        // return -1;

        int m = maze.length, n = maze[0].length;
        int[][] neighbors = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        maze[entrance[0]][entrance[1]] = '+';
        int res = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(entrance);
        while(!q.isEmpty()) {
            for(int i = q.size() - 1; i >= 0; i--) {
                int[] curr = q.remove();
                int x = curr[0], y = curr[1];
                if((x == 0 || x == m - 1 || y == 0 || y == n - 1)
                    && (x != entrance[0] || y != entrance[1]))
                    return res;
                for(int[] neighbor: neighbors) {
                    int newX = x + neighbor[0], newY = y + neighbor[1];
                    if(newX >= 0
                        && newX <= m - 1
                        && newY >= 0
                        && newY <= n - 1
                        && maze[newX][newY] == '.') {
                        maze[newX][newY] = '+';
                        q.add(new int[] {newX, newY});
                    }
                }
            }
            res++;
        }
        return -1;
    }
}