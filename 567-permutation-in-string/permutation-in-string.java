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
            int remain = mp.getOrDefault(s2.charAt(right), 0);
            if(remain == 0) {
                while(left < right && s2.charAt(left) != s2.charAt(right)) {
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