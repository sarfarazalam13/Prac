class Solution {
    public int snakesAndLadders(int[][] board) {
        final int n = board.length;
        final int endSquare = n * n;

        // Convert the Boustrophedon ordered (zig-zaggy) 2-D board[][] grid to a simple 
        // linear 1-D array indexed by square number.  For gameplay, nothing in the 
        // game requires a 2-D board, because the gameplay ONLY uses the square-number 
        // starting at square #1, ending at square #n^2, and following a snake or 
        // ladder to the square of the snake's or ladder's destination.  Gameplay does 
        // NOT need a 2-D board, so why should I write code to repeatedly convert a 1-D 
        // square-number to a 2-D board grid coordinate.
        short[] brd = new short[endSquare + 1];
        int brdIdx = 1;
        for (int row = n - 1; row >= 0; row--) {
            for (int col = 0; col < n; col++)  brd[brdIdx++] = (short)board[row][col];
            if (--row < 0)  break;
            for (int col = n - 1; col >= 0; col--)  brd[brdIdx++] = (short)board[row][col];
        }
        
        // Circular queue for the Breadth First Search.  If the queue is empty 
        // (bfsQueueRead == bfsQueueWrite), then there are no more possible moves in 
        // the game.  Each entry in the queue is the square number of the square 
        // to make moves from.
        final int bfsQueueLen = Math.min(n * n, 8 * n);
        short[] bfsQueue = new short[bfsQueueLen];
        int bfsQueueRead = 0;
        int bfsQueueWrite = 0;
        bfsQueue[bfsQueueWrite++] = 1;  // Initialize BFS queue to start at square #1

        // The count[] array, indexed by square number, is used to contain both the 
        // minimum number of moves to get to a square, and also indicate if the square 
        // has ever been visited before.  A value of zero (set by the Java creation of 
        // the array) indicates the square has NOT been visited yet.  A non-zero value 
        // indicates the square has been visited and that value is 1 plus the minimum 
        // number of moves needed to get to the square.  If a square has already been 
        // visited, we don't need to move there again.
        byte[] count = new byte[endSquare + 1];
        count[1] = 1;                   // Mark the starting location as already visited.

        // Loop to get a next current square-number from the BFS queue, and start 
        // making moves from that current location.
        while (bfsQueueRead != bfsQueueWrite) {
            int currSquare = bfsQueue[bfsQueueRead++];
            bfsQueueRead %= bfsQueueLen;
            // If close enough to the end square to make it on one move, then done.
            if (currSquare + 6 >= endSquare)  return count[currSquare];
            // Loop through the possible moves from the current location, using all 
            // possible moves from a 6-sided dice (i.e. moving 1,2,3,4,5, and 6 squares 
            // forward).
            int maxOpenMove = 0;
            for (int move = 6; move >= 1; move--) {
                int nextSquare = currSquare + move;
                // If moved to a snake or ladder, then jump to that destination square.
                // If the jump is to the end square of the game, then the game is done.
                if (brd[nextSquare] >= 0) {
                    if ((nextSquare = brd[nextSquare]) == endSquare)  return count[currSquare];
                }
                // Else moved to an open square 1 to 6 moves ahead.  Don't move to any 
                // open squares that are closer than the farthest open square we visited 
                // in the 1 to 6 moves ahead.  For example, if we were able to move to 
                // an open square 5 moves ahead, then there is no reason to move to an 
                // open square that is 1,2,3, or 4 moves ahead.  This does NOT apply to 
                // moving to any snakes or ladders that are 1 to 6 moves ahead, and the 
                // snakes or ladders must be taken.  This optimization can reduce the 
                // number of squares that are pushed onto the BFS queue, and saves the 
                // processing of those unnecessary squares.
                else {
                    if (move < maxOpenMove)  // If we already moved to an open square 1 to 6
                        continue;
                    maxOpenMove = move;
                }
                // If square not yet visited, then mark square as visited using the 
                // minimum number of moves to get to that square, and push that new 
                // square onto the BFS queue to later use as another square to move from.
                if (count[nextSquare] == 0) {
                    count[nextSquare] = (byte)(count[currSquare] + 1);
                    bfsQueue[bfsQueueWrite++] = (short)nextSquare;
                    if ((bfsQueueWrite %= bfsQueueLen) == bfsQueueRead)  return 0; // Queue overflow
                }
            }
        }

        // We ran out of moves (i.e. the BFS queue is empty) and we didn't reach the 
        // end square, so it must be impossible to win this game board.
        return -1;
    }
}