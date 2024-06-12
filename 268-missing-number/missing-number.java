class Solution {
     public int missingNumber(int[] nums) {
        int n = nums.length;
        long actualSum = 0;
        long missingSum = 0;
        for(int i = 0 ; i < n ; i ++) {
            missingSum += nums[i];
            actualSum += i;
        }
        actualSum += n;
        return (int)(actualSum - missingSum);
    }
}