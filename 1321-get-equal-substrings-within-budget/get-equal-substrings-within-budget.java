class Solution {
     public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int l = 0;
        int r = 0;
        int cost = 0;
        int maxLength = 0;
        while(r < n) {
            int currCost = Math.abs(s.charAt(r) - t.charAt(r));
            cost += currCost;
            while(cost > maxCost && l <= r) {
                cost -= Math.abs(s.charAt(l) - t.charAt(l));
                l++;
            }
            if(cost > maxCost) {
                l++;
                r++;
            }
            else {
                maxLength = Math.max(maxLength, r - l + 1);
                r++;
            }
        }
        return maxLength;
    }
}