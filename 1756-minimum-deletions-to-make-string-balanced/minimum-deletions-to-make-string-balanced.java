class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        // do prefix sum for the number of a from right to left
        int[] preA = new int[n];
        if(s.charAt(n - 1) == 'a' ) {
            preA[n-1] = 1;
        }
        else {
            preA[n-1] = 0;
        }
        for(int i = n - 2 ; i >= 0 ; i --) {
            preA[i] = preA[i + 1];
            if (s.charAt(i) == 'a') {
                preA[i]++;
            }
        }

        // do prefix sum for the number of b from left to right
        int[] preB = new int[n];
        if(s.charAt(0) == 'b' ) {
            preB[0] = 1;
        }
        else {
            preB[0] = 0;
        }
        for(int i = 1 ; i <n  ; i ++) {
            preB[i] = preB[i - 1];
            if (s.charAt(i) == 'b') {
                preB[i]++;
            }
        }

        int res = n;
        // for each element, we assume it is the split point, and calculate the number of deletions
        // preA[i] is the number of a on the right side of the current element (including the current element)
        // preB[i] is the number of b on the left side of the current element (including the current element)
        // However, if we choose the current element as the split point, we need to delete all
        // the a on the right side and all the b on the left side (not including the current element)
        // so one of the preA[i] and preB[i] should minus 1, therefore the total number of deletions is preA[i] + preB[i] - 1
        // example: baaabbbb, if we choose the 4th element as the split point,
        // preA[4] = 1, preB[4] = 1, the number of a on the rightside(not including the current element) is preA[4] - 1 = 0
        // the number of b on the leftside(not including the current element) is preB[4] = 1
        // so the total number of deletions is 1.
        for(int i = 0 ; i < n ; i++) {
            res = Math.min(preA[i] + preB[i] - 1, res);
        }

        return res;
    }
}