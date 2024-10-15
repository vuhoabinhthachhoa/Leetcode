class Solution {
     public int distributeCandies(int n, int limit) {
        // min is the minimum number of candies that can be distributed for each child
        // each child can receive from min to limit candies
        // Math.max to avoid that n - 2*limit < 0
        int min = Math.max(0, n - 2*limit);
        
        int[] prevDp = new int[n + 1];
        int[] currDp = new int[n + 1];
        // do Math.min to avoid case of limit > n
        limit = Math.min(limit, n);
        
        // initialize value
        for(int i = min ; i <= limit ; i++) {
            // prev[i] is the number of ways to distribute i candies to the first child
            // for the first child, there is always only one way to distribute (min -> limit) candies
            prevDp[i] = 1;
        }
        for(int i = 0 ; i < n + 1 ; i++) {
            int total = 0;
            // j is the number of candies that the second child receives
            // so the number of ways to distribute i candies to the first two children is
            // the sum of the number of ways to distribute i-j candies to the first child
            for(int j = min ; j <= limit ; j++ ) {
                if(i - j >= 0) {
                    total += prevDp[i - j];
                }
            }
            currDp[i] = total;
        }
        int res = 0;
        // the number of ways to distribute n candies to the first child is the sum of the number 
        // of ways to distribute n-i candies to the first two children
        for(int i = min ; i <= limit ; i++ ) {
            res += currDp[n - i];
        }

        return res;


    }
}