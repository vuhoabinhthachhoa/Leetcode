class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        map.put(0, -1);
        for(int i = 0 ; i < nums.length ; i++) {
            prefixSum += nums[i];
            int modulo = prefixSum % k;
            Integer existVal = map.getOrDefault(modulo, null);

            if(existVal != null){
                if(i - existVal >= 2) {
                    return true;
                }
                else continue;
            }
            map.put(modulo, i);
        }
        return false;
    }
}