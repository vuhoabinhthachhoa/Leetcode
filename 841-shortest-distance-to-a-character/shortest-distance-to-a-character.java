class Solution {
     public static int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        Arrays.fill(ans, n);
        for(int i = 0 ; i < n ; i++) {
            if(s.charAt(i) == c) {
                ans[i] = 0;
                int left = i - 1;
                while(left >= 0 && s.charAt(left) != c) {
                    if(i - left < ans[left]) {
                        ans[left] = i - left;
                    }
                    left--;
                }

                int right = i + 1;
                while(right < n && s.charAt(right) != c) {
                    if(right - i < ans[right]) {
                        ans[right] = right - i;
                    }
                    right++;
                }
            }
        }

        return ans;
    }
}