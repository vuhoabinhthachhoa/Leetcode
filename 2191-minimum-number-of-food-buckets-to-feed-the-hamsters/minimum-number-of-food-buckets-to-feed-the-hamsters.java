class Solution {
    public int minimumBuckets(String hamsters) {
        int rightMostBucket = -2; // initialize value for rightMostBucket (-1 does not work)
        int res = 0;
        int n = hamsters.length();
        int i = 0;
        while(i < n) {
            if(hamsters.charAt(i) == 'H') {
                if(rightMostBucket == i-1 ) {
                    i++;
                    continue;
                }
                if(i < n - 1 && hamsters.charAt(i+1) == '.') {
                    res++;
                    rightMostBucket = i+1;
                }
                else {
                    if(i >= 1 && hamsters.charAt(i-1)=='.'){
                        res++;
                        rightMostBucket = i-1;
                    }
                    else {
                        return -1;
                    }
                }
            }
            i++;

        }
        return res;
    }

}