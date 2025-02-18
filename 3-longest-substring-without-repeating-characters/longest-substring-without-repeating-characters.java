class Solution {
      public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int[] mp = new int[256];
        int res = 0;
        for(int right = 0; right < s.length() ; right++){
            if(mp[s.charAt(right)] == 1) {
                while(s.charAt(left) != s.charAt(right)){
                    mp[s.charAt(left)]--;
                    left++;
                }
                mp[s.charAt(left)]--;
                left++;
            }
            res = Math.max(res, right - left + 1);
            mp[s.charAt(right)]++;
        }
        return res;
    }

}