class Solution {
    public long minimumSteps(String s) {
        int whiteCount = 0;
        long res = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == '0') {
                res += (i - whiteCount);
                whiteCount++;
            }
            
        }
        return res;
    }
}