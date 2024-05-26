class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            int currProduct = 1;
            for(int j = i; j < nums.length ; j++) {
                currProduct *= nums[j];
                if(currProduct >= k) {
                    break;
                }
                res++;
            }
        }
        return res;
    }
}