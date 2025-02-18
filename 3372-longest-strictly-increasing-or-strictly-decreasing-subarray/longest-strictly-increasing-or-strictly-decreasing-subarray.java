class Solution {
     public int longestMonotonicSubarray(int[] nums) {
        int left = 0;
        int res = 1;
        // exceptional cases
        if(nums.length == 1) {
            return 1;
        }

        if(nums.length == 2) {
            if(nums[0] == nums[1]) {
                return 1;
            }
            return 2;
        }
        for(int right = 1 ; right < nums.length - 1 ; right ++) {
            // we can't include the current num in this case
            if(nums[right] == nums[right - 1]) {
                left = right;
            }
            // we update the res before checking because the current num is also in our current subarray
            res = Math.max(res, right - left + 1);
            if(nums[right] < nums[right - 1] && nums[right] < nums[right + 1] || nums[right] > nums[right - 1] && nums[right] > nums[right + 1]) {
                left = right;
            }
        }
        if(nums[nums.length - 1] != nums[nums.length - 2]) {
            res = Math.max(res, (nums.length - 1) - left + 1);

        }
        return res;
    }
}