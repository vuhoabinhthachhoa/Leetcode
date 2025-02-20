class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        int right = 0;
        int minWrongEle = Integer.MAX_VALUE;
        while(i < nums.length) {
            if(nums[i] < max) {
                right = i;
                minWrongEle = Math.min(minWrongEle, nums[i]);
            }
            else {
                max = nums[i];
            }
            i++;
        }
        int left = 0;
        while(left < nums.length && nums[left] <= minWrongEle) {
            left++;
        }
        return (right - left + 1) > 1 ? (right - left + 1) : 0;
    }
}