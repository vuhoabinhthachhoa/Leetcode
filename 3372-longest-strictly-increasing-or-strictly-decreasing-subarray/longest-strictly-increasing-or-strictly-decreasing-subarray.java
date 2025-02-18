class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int res = 1;
        int decLength = 1;
        int incLength = 1;

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i-1]){
                decLength++;
                incLength = 1;
                res = Math.max(res, decLength);
            }
            else if(nums[i] > nums[i-1]){
                incLength++;
                decLength = 1;
                res = Math.max(res, incLength);
            }
            else {
                incLength = 1;
                decLength = 1;
            }
        }
        return res;
    }
}