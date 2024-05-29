class Solution {
   // for more understanding, please refer the illustrative image
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        // prefix[x][y] = sum of all elements mat[i][j] where i <= x and j <= y

        int[][] prefix = new int[m][n];

        prefix[0][0] = mat[0][0];

        // initialize value for top border
        for (int i = 1; i < n; i++) {
            prefix[0][i] = mat[0][i] + prefix[0][i-1];
        }
        // initialize value fot left border
        for (int i = 1; i < m; i++) {
            prefix[i][0] = mat[i][0] + prefix[i-1][0];
        }

        // calculate prefix sum
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                prefix[i][j] = mat[i][j] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
            }
        }

        // calculate result
        int [][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // get last element
                int lastI = Math.min(i + k, m-1);
                int lastJ = Math.min(j + k, n-1);

                result[i][j] = prefix[lastI][lastJ];
                // substract
                // test case: i = 3, j = 2
                if(i == 2 && j == 3) {
                    System.out.println("lastI: " + lastI + ", lastJ: " + lastJ);
                }

                // the left bottom element outside the range
                // 2*(k+1) - 1 is the length of square (k): ex: k = 1 -> length = 3 ; k = 2 -> length = 5
                int leftJ = j + k - (2*(k+1) -  1);
                if(leftJ >= 0 && leftJ < n) {
                    result[i][j] -= prefix[lastI][leftJ];
                }

                // the top right element outside the range
                int topI = i + k - (2*(k+1) -  1);
                if(topI >= 0 && topI < m) {
                    result[i][j] -= prefix[topI][lastJ];
                }

                // intersection
                if(topI >= 0 && topI < m && leftJ >= 0 && leftJ < n) {
                    result[i][j] += prefix[topI][leftJ];
                }
            }
        }

        return result;
    }
}