class Solution {
   public int minOperations(String[] logs) {
        int res = 0;
        for(int i = 0 ; i < logs.length ; i++) {
            if (logs[i].charAt(0) == '.' && logs[i].charAt(1) == '.') {
                res--;
                if(res < 0) {
                    res = 0;
                }
            }
            else if(logs[i].charAt(0) == '.' && logs[i].charAt(1) == '/') {
                continue;
            }
            else {
                res ++;
            }
        }
        return res;
    }
}