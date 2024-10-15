class Solution {
    public long minimumSteps(String s) {
        int whiteCount = 0;
        long res = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            // whiteCount is the number of white cells before the current cell, that also means the current white cells is (whiteCount)th white cell
            // (the first white cell is 0th)
            // if the current white cell is at i, and it is the (whiteCount)th white
            // that means we need to move the current cell from the position i to the position whiteCount, it will take i - whiteCount steps
            if(s.charAt(i) == '0') {
                res += (i - whiteCount);
                whiteCount++;
            }
            
        }
        return res;
    }
}