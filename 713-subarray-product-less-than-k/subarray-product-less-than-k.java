class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int currProduct = 1;
        int left = 0;
        int right = 0;
        while(right < nums.length) {
            if(nums[right] >= k) {
                right++;
                left = right;
                currProduct = 1;
                continue;
            }
            currProduct *= nums[right];
            while(currProduct >= k) {
                currProduct /= nums[left];
                left++;
            }
            // right - left + 1 is the number of subarrays of array[left, right] ending at right
            // for example: 1,2,3,4
            // there are 4 subarrays ending at 4: [4], [3,4], [2,3,4], [1,2,3,4]
            // that means if we can add the current number to the subarray, we have additionally right - left + 1 new valid subarrays
            res += right - left + 1;
            right++;
        }
        return res;
    }
}