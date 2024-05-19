class Solution {
    // the demonstrative image is in dynamic programming folder
     public int minDistance(String word1, String word2) {
        int m = word2.length() + 1;
        int n = word1.length() + 1;
        int[][] ds = new int[m][n];

        for(int i = 0 ; i < m ; i ++) {
            ds[i][0] = i;
        }
        for(int i = 0 ; i < n ; i ++) {
            ds[0][i] = i;
        }

        for(int i = 1 ; i < m ; i++) {
            for(int j = 1; j < n ; j++) {
                if(word1.charAt(j-1) == word2.charAt(i-1)) {
                    ds[i][j] = ds[i-1][j-1];
                }
                else {
                    int insert = ds[i-1][j] + 1;
                    int replace = ds[i-1][j-1] + 1;
                    int delete = ds[i][j-1] + 1;
                    ds[i][j] = Math.min(insert, Math.min(replace, delete));
                }
            }
        }

        return ds[m-1][n-1];
    }
}
