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
            res += right - left + 1;
            right++;
        }
        return res;
    }
}