class Solution {
     /*
    * Intuition:
    * range indicates that we can build up the sum from 1 to range.
    * First, we initialize range as 0
    * We iterate the nums array:
    * - The next sum we need to build is range + 1
    * - If nums[i] > range + 1, that means there is no way to build the sum (range + 1) by using the current elements in the array 
    *   (because all the remaining elements in the arrays are greater than (range +1))
    *   + So we need to add (range + 1) to the array (it's one patch), so increase the res by 1
    * - If nums[i] <= range + 1, so we can use the nums[i] (that means we can add nums[i] to the current range) 
    *   +) for example: the current range is 5 and we meet nums[i] = 3, so we can use nums[i] to build up the sum
    *      and the range now is 5 + 3 = 8 because we can build sum(6) by using 3 and 3, sum(7) by using 3 and 4, sum(8) by using 3 and 5
    * */
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
        // after we've used all the elements in the arrays, but the range is still less than n
        // we need to continue adding the elements to the array
        // for each element we add, the range will be increased by (range + 1)
        // loop unitl the range is equal to or greater than n
        while(range < n) {
            range += range + 1;
            res ++;
        }
        return res;
    }
}