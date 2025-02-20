class Solution {
   public int findUnsortedSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        // right is the position of the right most element that is at wrong position
        int right = 0;
        // minWrongEle is the minimum element of the wrong position elements
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
        // to have to sort from the element that is greater than the minWrongEle.
        return (right - left + 1) > 1 ? (right - left + 1) : 0;
    }
}