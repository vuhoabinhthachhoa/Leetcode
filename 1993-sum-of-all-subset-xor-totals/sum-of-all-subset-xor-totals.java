class Solution {

      public int help(int[] nums, int ind, int currSubset, int n) {
        if(ind == n) {
            return currSubset;
        }
        int pick = help(nums, ind + 1, currSubset^nums[ind], n);
        int notPick = help(nums, ind + 1, currSubset, n);

        return pick + notPick;
    }

    public int subsetXORSum(int[] nums) {
        return help(nums, 0, 0, nums.length);
    }
}