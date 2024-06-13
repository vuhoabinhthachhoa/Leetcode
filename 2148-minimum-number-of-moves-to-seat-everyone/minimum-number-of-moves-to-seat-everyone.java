class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int n = seats.length;
        int[] seatFreq = new int[101];
        int[] studentFreq = new int[101];

        for(int i = 0 ; i < n ; i++) {
            seatFreq[seats[i]] ++;
            studentFreq[students[i]] ++;
        }

        int res = 0;
        int i = 0, j = 0;
        while(true) {
            while(i < 101 && seatFreq[i] == 0) i++;
            while(j < 101 && studentFreq[j] == 0) j++;

            if(i >= 101 || j >= 101) break;
            res += Math.abs(i - j);
            seatFreq[i]--;
            studentFreq[j]--;
        }

        return res;
    }
}