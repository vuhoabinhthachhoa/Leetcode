class Solution {
   /*
     * prefixSum[i] - prefixSum[j] is the sum of elements between index i and j
     * => prefixSum[i] - prefixSum[j] = n * k
     * => (prefixSum[i] - prefixSum[j]) % k = 0
     * We have:
     * prefixSum[i] = Q1 * k + R1
     * prefixSum[j] = Q2 * k + R2
     * => (prefixSum[i] - prefixSum[j]) % k = (Q1 * k + R1 - Q2 * k - R2) % k = 0
     * => ((Q1 - Q2) * k + (R1 - R2)) % k = 0
     * => (R1 - R2) is also divisible by k, another thing is that R1 and R2 are in the range of 0 to k - 1
     * (because R1 and R2 are the remainder when dividing by k)
     * => R1 - R2 is divisible by k if and only if R1 = R2
     * => prefixSum[i] % k = prefixSum[j] % k
     * Therefore, we are only concerned with the remainder when dividing the prefix sum by k
     * We can use hashmap to store the remainder of the prefix sum and the index of the prefix sum
     */
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