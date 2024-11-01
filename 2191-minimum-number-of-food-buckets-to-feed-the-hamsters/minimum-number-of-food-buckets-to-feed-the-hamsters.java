class Solution {
    public int minimumBuckets(String hamsters) {
        int rightMostBucket = -2; // initialize value for rightMostBucket (-1 does not work)
        int res = 0;
        int n = hamsters.length();
        int i = 0;
        while(i < n) {
            if(hamsters.charAt(i) == 'H') {
                // if we already added a bucket on the left, current hamster is fed
                if(rightMostBucket == i-1 ) {
                    i++;
                    continue;
                }
                // else we have to add a new bucket for current hamster
                // we prioritize to add the new bucket to the right, because by doing this the new bucket might feed 2 hamsters, which allows us 
                // to minimize the number of buckets
                if(i < n - 1 && hamsters.charAt(i+1) == '.') {
                    res++;
                    rightMostBucket = i+1;
                }
                // if we can't add to the right, we have to add to the left
                else {
                    if(i >= 1 && hamsters.charAt(i-1)=='.'){
                        res++;
                        rightMostBucket = i-1;
                    }
                    // if we even can't add to the left, which means it's impossible to feed the current hamster
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