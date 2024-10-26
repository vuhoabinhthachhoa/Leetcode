class Solution {
   public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;;
        int n = grid[0].length;
        int[] oneCountRow = new int[m];
        int[] oneCountCol = new int[n];

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                oneCountRow[i]+= grid[i][j];
                oneCountCol[j]+= grid[i][j];
            }
        }

        int[][] res = new int[m][n];
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {

                res[i][j] = oneCountRow[i] + oneCountCol[j] - (m - oneCountRow[i] + n - oneCountCol[j]);
            }
        }
        return res;
    }
}