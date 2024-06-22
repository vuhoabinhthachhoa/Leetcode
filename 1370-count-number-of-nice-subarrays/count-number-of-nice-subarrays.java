class Solution {
     public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int res = 0;
        int odds = 0;
        mp.put(0,1);
        for(int i =0 ; i < nums.length ;i++) {
            if(nums[i] % 2 == 1) {
                odds++;
            }
            int freq = mp.getOrDefault(odds - k, 0);
            res += freq;
            mp.put(odds, mp.getOrDefault(odds,0) +1);
        }
        return res;
    }
}