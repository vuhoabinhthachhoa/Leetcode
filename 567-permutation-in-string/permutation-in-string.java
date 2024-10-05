class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i = 0 ; i < s1.length() ; i++) {
            int freq = mp.getOrDefault(s1.charAt(i), 0);
            mp.put(s1.charAt(i), freq + 1);
        }

        // do sliding window
        int left = 0;
        for(int right = 0 ; right < s2.length() ; right++) {
            // remain = the frequent of s2[right] in s1 - the frequent of s2[right] in the substring that we are considering in s2
            // for example: s1: xxyy ; s2: xyabcd
            // if the substring is xy: the remain of x would be 1 and y would be 1
            int remain = mp.getOrDefault(s2.charAt(right), 0);
            if(remain == 0) {
                // remain = 0 means that we can't add s2[right] into the substring
                // so, we need to shrink the substring by increasing left until we meet the s2[right].
                while(s2.charAt(left) != s2.charAt(right)) {
                    // if the character that we are removing from the substring is in s1, 
                    // we have to increase its remain by 1
                    if (s1.contains(Character.toString(s2.charAt(left)))) {
                        remain = mp.getOrDefault(s2.charAt(left), 0);
                        mp.put(s2.charAt(left), remain+1);
                    }
                    left++;
                }
                left++;
            }
            else {
                mp.put(s2.charAt(right), remain - 1);
            }
            if(right - left + 1 == s1.length()) {
                return true;
            }
        }
        return false;
    }
       
}