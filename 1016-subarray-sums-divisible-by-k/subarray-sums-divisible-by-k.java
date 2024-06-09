class Solution {
        public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,  1);
        int prefixSum = 0;
        int res = 0;

        for(int i = 0 ; i < nums.length ; i++) {
            prefixSum += nums[i];
            int modulo = prefixSum % k;
            int freq = map.getOrDefault(modulo, 0);
            int extra =  map.getOrDefault(modulo + k, 0)
                    + map.getOrDefault(modulo - k, 0);
            if(freq + extra > 0) {
                res += freq + extra;
            }
            map.put(prefixSum % k, freq + 1);
        }

        return res;
    }
}