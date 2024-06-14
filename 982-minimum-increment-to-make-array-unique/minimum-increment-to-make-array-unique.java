class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int currVal = nums[0] + 1;
        int res = 0;
        for(int i = 1 ; i < nums.length ; i++) {
            if(currVal > nums[i]) {
                res += currVal - nums[i];
            }
            currVal = Math.max(nums[i], currVal) + 1;
        }

        return res;
    }
}