class Solution {
     public int numberOfSubarrays(int[] nums, int k) {
        // using sliding window, each window contains k odds with the maximum length
        // e.g. for array [2,1,1,4,6,1,1,8] k =2, there are 3 windows [2,1,1,4,6], [1,4,6,1], and [4,6,1,1,8]
        int left = 0, right = 0;
        int odds = 0;
        int res = 0;
        // find the first window with k odds
        while(right < nums.length && odds < k) {
            if(nums[right] % 2 == 1) odds++;
            right++;
        }
        // if there are less than k odds in the entire array, return 0
        if(odds < k) return 0;

        // the number of evens on the left and right of the window
        // e.g. for window [2,4,1,1,6], leftEvens = 2, rightEvens = 1
        int leftEvens = 0;
        int rightEvens = 0;
        while(right < nums.length) {
            if(nums[right] % 2 == 0) rightEvens++;
            else {
                // if we meet an odd number, we find the number of evens on the left and calcute the number of subarrays of the current window
                while(nums[left] % 2 == 0) {
                    left++;
                    leftEvens++;
                }
                left++;
                // e.g. for window [2,4,1,1,6], leftEvens = 2, rightEvens = 1
                // the number of subarrays = (leftEvens + 1) * (rightEvens + 1)
                res += (leftEvens + 1)  * (rightEvens + 1);
                leftEvens = rightEvens = 0;
            }
            right++;
        }
        // if we reach the end of the array and the current window still has k odds, we need to calculate the number of subarrays of the current window
        // e.g. for array [2,1,1,4,6,1,1,8] k =2, the last window is [4,6,1,1,8], leftEvens = 2, rightEvens = 1
        while(nums[left] % 2 == 0) {
            left++;
            leftEvens++;
        }
        res += (leftEvens + 1)  * (rightEvens + 1);
        return res;
    }
}