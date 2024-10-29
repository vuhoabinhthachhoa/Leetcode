class Solution {
      public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[] currCol = new boolean[m];
        boolean[] leftCol = new boolean[m];
        Arrays.fill(leftCol, true);
        for(int j = 1 ; j < n ; j ++) {
            boolean canMoveCol = false;
            for(int i = 0 ; i < m ; i++) {
                int[] move = new int[]{-1, 0, 1};
                boolean canMove = false;
                for(int k = 0 ; k < move.length ; k++) {
                    int newI = i + move[k];
                    if(newI >= 0 && newI < m) {
                        if(grid[newI][j-1] < grid[i][j] && leftCol[newI]) {
                            canMove = true;
                            break;
                        }
                    }
                }
                currCol[i] = canMove;
                if(canMove) {
                    canMoveCol = true;
                }
            }
            if(!canMoveCol) {
                return j - 1;
            }
            else {
                leftCol = Arrays.copyOf(currCol, m);
            }
        }
        return n - 1;
    }
}