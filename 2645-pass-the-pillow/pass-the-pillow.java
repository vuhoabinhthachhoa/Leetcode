class Solution {
    public int passThePillow(int n, int time) {
        int numberOfChanges = time / (n - 1);
        int remain = time % (n-1);
        if(numberOfChanges % 2 == 0) {
            return remain + 1;
        }
        return n - remain;
    }
}