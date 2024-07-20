class Solution {
    //Idea: https://www.youtube.com/watch?v=Ks6fGnXkHPg
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] res = new int[m][n];
        long currColSum = 0;
        for(int i = 0 ; i < m; i ++) {
            res[i][0] = rowSum[i];
            currColSum += rowSum[i];
        }

        for(int i = 0 ; i < n - 1; i++) {
            long excess = currColSum - colSum[i];
            currColSum = 0;
            for(int j = 0 ; j < m; j++) {
                if(res[j][i] <= excess) {
                    excess -= res[j][i];
                    res[j][i + 1] = res[j][i];
                    res[j][i] = 0;
                    currColSum += res[j][i + 1];
                }
                else {
                    res[j][i] -= excess;
                    res[j][i + 1] = (int)excess;
                    currColSum += excess;
                    break;
                }
            }
        }



        return res;
    }
}