class Solution {
    public static int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];

        int rightMostPos = -n;
        // traverse from left to right
        for(int i = 0 ; i < n ; i++) {
            if(s.charAt(i) == c) {
                ans[i] = 0;
                rightMostPos = i;
            }
            else {
                ans[i] = i - rightMostPos;
            }
        }

        int leftMostPos = 2*n;
        // traverse from right to left
        for(int i = n - 1 ; i >= 0 ; i--) {
            if(s.charAt(i) == c) {
                leftMostPos = i;
            }
            else {
                ans[i] = Integer.min(ans[i], leftMostPos - i);
            }
        }


        return ans;
    }
}