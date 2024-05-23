class Solution {
    public int backtrack(int[] nums, int k, int ind, Map<Integer, Integer> mp, int mpSize) {
        if(ind == nums.length) {
            return 0;
        }

        // pick
        int pick = 0;
        if(mp.containsKey(nums[ind] - k) || mp.containsKey(nums[ind] + k)) {
            pick = (int)Math.pow(2, nums.length - ind - 1);
        }
        else {
            if(mp.containsKey(nums[ind])) {
                mp.put(nums[ind], mp.get(nums[ind]) + 1);
            }
            else {
                mp.put(nums[ind], 1);
            }
            pick = backtrack(nums, k, ind + 1, new HashMap<>(mp), mpSize + 1);
            if(mp.get(nums[ind]) == 1) {
                mp.remove(nums[ind]);
            }
            else {
                mp.put(nums[ind], mp.get(nums[ind]) - 1);
            }
        }
        int notPick = backtrack(nums, k, ind + 1, new HashMap<>(mp), mpSize);
        return pick + notPick;
    }
    public int beautifulSubsets(int[] nums, int k) {
        return (int)Math.pow(2, nums.length) - 1 - backtrack(nums, k, 0, new HashMap<>(), 0);
    }

}