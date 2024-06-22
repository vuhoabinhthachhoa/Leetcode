class Solution {
      public int numberOfSubarrays(int[] nums, int k) {
        int left = 0, right = 0;
        int odds = 0;
        int res = 0;
        while(right < nums.length && odds < k) {
            if(nums[right] % 2 == 1) odds++;
            right++;
        }
        if(odds < k) return 0;
        
        int leftEvens = 0;
        int rightEvens = 0;
        while(right < nums.length) {
            if(nums[right] % 2 == 0) rightEvens++;
            else {
                while(nums[left] % 2 == 0) {
                    left++;
                    leftEvens++;
                }
                left++;
                res += (leftEvens + 1)  * (rightEvens + 1);
                leftEvens = rightEvens = 0;
            }
            right++;
        }
        while(nums[left] % 2 == 0) {
            left++;
            leftEvens++;
        }
        res += (leftEvens + 1)  * (rightEvens + 1);
        return res;
    }
}