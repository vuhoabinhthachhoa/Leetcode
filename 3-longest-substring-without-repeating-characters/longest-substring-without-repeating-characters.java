class Solution {
     public int lengthOfLongestSubstring(String s) {
        int left = 0;
        // mp to store the index of the last occurrence of each character
        int[] mp = new int[256];
        Arrays.fill(mp, -1);
        int res = 0;
        for(int right = 0; right < s.length() ; right++){
            if(left <= mp[s.charAt(right)]) {
                left = mp[s.charAt(right)] + 1;
            }
            res = Math.max(res, right - left + 1);
            mp[s.charAt(right)] = right;
        }
        return res;
    }
}