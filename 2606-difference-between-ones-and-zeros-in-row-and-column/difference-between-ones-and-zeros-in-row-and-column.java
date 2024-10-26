class Solution {
   public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;;
        int n = grid[0].length;
        int[] oneCountRow = new int[m];
        int[] oneCountCol = new int[n];
        int[] zeroCountRow = new int[m];
        int[] zeroCountCol = new int[n];

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(grid[i][j] == 1) {
                    oneCountRow[i]++;
                    oneCountCol[j]++;
                }
                else {
                    zeroCountRow[i]++;
                    zeroCountCol[j]++;
                }
            }
        }

        int[][] res = new int[m][n];
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {

                res[i][j] = oneCountRow[i] + oneCountCol[j] - zeroCountRow[i] - zeroCountCol[j];
            }
        }
        return res;
    }
}