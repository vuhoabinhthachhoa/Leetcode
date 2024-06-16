class Solution {
    public int minPatches(int[] nums, int n) {
        int res = 0;
        long range = 0;
        int i = 0;
        while (range < n && i < nums.length) {
            if(nums[i] > (range + 1)) {
                res++;
                range += range+1;
            }
            else {
                range += nums[i];
                i++;
            }
        }

        while(range < n) {
            range += range + 1;
            res ++;
        }
        return res;
    }
}