class Solution {
    public boolean judgeSquareSum(int c) {
        int r = (int)Math.sqrt(c);
        int l = 0;
        while(l<=r) {
            long sum = (long) l *l + (long) r *r;
            if(sum >c ) r--;
            else if (sum <c )l++;
            else return true;
        }
        return false;
    }
}