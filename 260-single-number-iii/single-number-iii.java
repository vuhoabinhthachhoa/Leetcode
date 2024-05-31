class Solution {
    // solution: https://leetcode.com/problems/single-number-iii/?envType=daily-question&envId=2024-05-31
    public int[] singleNumber(int[] nums) {
        int diff = nums[0];
        for(int i = 1 ; i < nums.length ; i++) {
            diff ^= nums[i];
        }

        // get the last 1 bit of diff
        // for example: 10010 -> 00010
        diff = diff& (-diff);
        
        // these two number must be different at that bit
        // because the xor result of them has 1 at that bit

        // so we can divide these two numbers into two groups
        // 1. has 1 at that bit -> nums[i] & diff == 1
        // 2. has 0 at that bit -> nums[i] & diff == 0
        int[] res = new int[]{0, 0};
        for(int i = 0 ; i < nums.length ; i++) {
            // if 
            if((nums[i] & diff) != 0) {
                res[0] ^= nums[i];
            }
            else {
                res[1] ^= nums[i];
            }
        }

        return res;
    }
}