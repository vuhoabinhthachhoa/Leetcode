class Solution {
    public int findTheWinner(int n, int k) {
        boolean[] isLeaved = new boolean[n];
        int currFriend = 0;
        int leaves = 0;
        while(leaves < n - 1) {
            int temp = k;
            while(true) {
                if(!isLeaved[currFriend]) {
                    temp--;
                }
                if(temp == 0) {
                    break;
                }
                currFriend = (currFriend + 1) % n;
            }
            isLeaved[currFriend] = true;
            leaves++;
            currFriend = (currFriend + 1) % n;
        }
        while(isLeaved[currFriend]) {
            currFriend = (currFriend + 1) % n;
        }
        return currFriend + 1;
    }
};