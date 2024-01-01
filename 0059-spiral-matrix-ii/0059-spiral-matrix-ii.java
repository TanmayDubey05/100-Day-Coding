class Solution {
    /**
        direction:
        0: left -> right
        1: up -> down
        2: right -> left
        3 down -> up
     */
    int direction = 0;
    //dx and dy is used to increment x and y `(i, j)` value of the matrix.
    int dx = 0, dy=1;

    //defines left starting limit for columns eg. 0
    int yLeftLimit;
    //defines right starting limit for columns eg. n-1
    int yRightLimit;
    //defines upper starting limit for rows eg. 0
    int xUpLimit;
    //defines lower starting limit for rows eg. n-1
    int xDownLimit;

    public int[][] generateMatrix(int n) {
        yLeftLimit = 0;
        yRightLimit = n-1;
        xUpLimit = 0;
        xDownLimit = n-1;
        
        int limit = n*n;
        int x = 0, y=0;
        int[][] nums = new int[n][n];
        for(int i=1; i<=limit; i++) {
            nums[x][y] = i;
            //move in the specified direction in matrix
            x += dx;
            y += dy;
            //check for any state change.
            getState(x, y);
        }

        return nums;
    }

    void getState(int x, int y) {
        if(direction == 0 && y == yRightLimit) {
            //changing direction from left -> right to up -> down
            direction = 1;
            dy = 0;
            dx = 1;
            xUpLimit++;
        } else if(direction == 1 && x == xDownLimit) {
            //changing direction from up -> down to right -> left
            direction = 2;
            dy = -1;
            dx = 0;
            yRightLimit--;
        } else if(direction == 2 && y == yLeftLimit) {
            //changing direction from right -> left to down -> up
            direction = 3;
            dy = 0;
            dx = -1;
            xDownLimit--;
        } else if(direction == 3 && x == xUpLimit) {
            //changing direction from down -> up to left -> right
            direction = 0;
            dx = 0;
            dy = 1;
            yLeftLimit++;
        }
    }
}