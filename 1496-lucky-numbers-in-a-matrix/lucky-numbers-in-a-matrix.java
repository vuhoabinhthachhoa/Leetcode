class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] minInRows = new int[m];
        Set<Integer> maxInCols = new HashSet<>();
        for(int i = 0 ; i < m ; i++) {
            int Min = matrix[i][0];
            for(int j = 1 ; j < n ; j++) {
                Min = Math.min(Min, matrix[i][j]);
            }
            minInRows[i] = Min;
        }
        for(int i = 0 ; i < n ; i++) {
            int Max = matrix[0][i];
            for(int j = 1 ; j < m ; j++) {
                Max = Math.max(Max, matrix[j][i]);
            }
            maxInCols.add(Max);
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < m ; i++) {
            if(maxInCols.contains(minInRows[i])) {
                res.add(minInRows[i]);
            }
        }
        return res;
    }
}