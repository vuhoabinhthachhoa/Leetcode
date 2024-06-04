class Solution {
    public int longestPalindrome(String s) {
        int [] count = new int[128];
        int singleCount = 0;
        int res = 0;
        for (char c : s.toCharArray()) {
            count[c]++;
            if(count[c] == 1) {
                singleCount++;
            } else {
                if(count[c] % 2 == 0) {
                    singleCount--;
                    res+=2;
                }
                else {
                    singleCount++;
                }
            }
        }
        if(singleCount > 0) {
            res++;
        }
        return res;
    }
}