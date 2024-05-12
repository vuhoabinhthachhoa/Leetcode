class Solution {
   public int[][] largestLocal(int[][] grid) {
    int n = grid.length;
    int[][] res = new int[n - 2][n - 2];  

    for (int i = 1; i < n - 1; i++) {
        for (int j = 1; j < n - 1; j++) {
            int max = 0;
            for (int row = i - 1; row < i + 2; row++) {
                for (int col = j - 1; col < j + 2; col++) {
                    max = Math.max(grid[row][col], max);
                }
            } 
            res[i - 1][j - 1] = max;
        }
    }
    return res;
}
}