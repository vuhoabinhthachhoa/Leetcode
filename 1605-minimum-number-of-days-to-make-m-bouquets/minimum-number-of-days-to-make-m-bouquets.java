class Solution {
     boolean canMakeBouquets(int[] bloomDay, int m, int k, int days) {
        int curr = 0;
        for(int i = 0 ; i < bloomDay.length ; i++) {
            if(days >= bloomDay[i]) {
                curr++;
                if(curr == k) {
                    m--;
                    if(m == 0) {
                        return true;
                    }
                    curr = 0;
                }
            }
            else {
                curr = 0;
            }
        }
        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((m * k) > n) return -1;

        int high = (int)1e9;
        int low = 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            boolean isValid = canMakeBouquets(bloomDay, m, k, mid);
            if(isValid) high = mid - 1;
            else low = mid + 1;
        }

        if(low == 1e9 + 1) return -1;
        return low;
    }

}