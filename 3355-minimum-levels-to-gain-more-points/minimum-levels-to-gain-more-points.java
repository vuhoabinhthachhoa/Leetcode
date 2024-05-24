class Solution {
     public int minimumLevels(int[] possible) {
        int sum = 0;
        for(int i = 0 ; i < possible.length ; i++) {
            if(possible[i] == 1) {
                sum += 1;
            }
            else {
                sum -= 1;
            }
        }
        int alice = 0;
        int bob =0;
        int i = 0;
        while(i < possible.length - 1) {
            if(possible[i] == 1) {
                alice +=1;
            }
            else {
                alice -= 1;
            }
            bob = sum - alice;
            if(alice > bob) {
                return i+1;
            }
            i++;
        }

        return -1;
    }

};