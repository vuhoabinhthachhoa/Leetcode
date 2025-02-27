class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        // dp[i][j]: length of longest fibonacchi sequence end with A[i], A[j] - 2
        int[][] dp = new int[n][n];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        int maxLength = 0;
        //               1, 3, 4, 7, 10, 11, 12, 18, 23, 35
        for (int i = 2; i < n; i++) {
            int preMaxLength = 0;
            int couple = 0;
            for(int j = 0; j < i; j++) {
                couple = map.getOrDefault(arr[i] - arr[j], -1);
                if(couple != -1 && couple != j) {
                    // check only in case that j < couple
                    // for example: 3 and 5
                    // there are two times that j = index of 3; couple = index of 5
                                            //  j = index of 5; couple = index of 3
                    // we need to check only the first case 
                    if(j < couple ) {
                        dp[couple][i] = Math.max(dp[couple][i], dp[j][couple] + 1);
                        maxLength = Math.max(maxLength, dp[couple][i]);
                    }

                }
            }

        }

        return maxLength == 0 ? 0 : maxLength + 2;

    }
}