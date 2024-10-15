class Solution {
    public int distributeCandies(int n, int limit) {
        int min = Math.max(0, n - 2*limit);
        int[] prevDp = new int[n + 1];
        int[] currDp = new int[n + 1];
        limit = Math.min(limit, n);
        // initialize value
        for(int i = min ; i <= limit ; i++) {
            prevDp[i] = 1;
        }
        for(int i = 0 ; i < n + 1 ; i++) {
            int val = 0;
            for(int j = min ; j <= limit ; j++ ) {
                if(i - j >= 0) {
                    val += prevDp[i - j];
                }
            }
            currDp[i] = val;
        }
        int res = 0;
        for(int i = min ; i <= limit ; i++ ) {
            res += currDp[n - i];
        }

        return res;


    }
}