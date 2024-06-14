class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if(maxMove == 0) return 0;
        int [][] dp = new int[m][n]; // m: width ; n: length ; maxMove: height
        // dp[i][j] indicates the number of ways to reach the (i,j) element with the previous moves
        dp[startRow][startColumn] = 1;
        int res = 0;

        for(int h = 0 ; h < maxMove ;h++) {
            int[][] curr = new int[m][n];
            for(int i = 0 ; i < m ;i++) {
                for(int j = 0 ; j < n ; j++) {
                    int paths = 0;
                    if(i == 0 || i == m -1 || j == 0 || j == n - 1) {

                    }
                    int[][] adjacents = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
                    for(int k = 0; k < 4 ; k ++) {
                        int nextI = i + adjacents[k][0];
                        int nextJ = j + adjacents[k][1];
                        if(nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n) {
                            curr[nextI][nextJ] =  (curr[nextI][nextJ] + dp[i][j]) % 1000000007;
                        }
                        // if the next move is out of the boundary, then it is a path
                        // so we add the number of ways to reach the current element to the result
                        else {
                            res = (res + dp[i][j]) % 1000000007;
                        }
                    }
                }
            }
            dp = curr;
        }

        return res;
    }
}