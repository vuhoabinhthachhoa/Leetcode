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
     * => R1 - R2 is divisible by k if
     *  + (R1 - R2) = 0 => R1 = R2
     *  + (R1 - R2) = k => R1 = R2 + k
     *  + (R1 - R2) = -k => R1 = R2 - k
     *  How to calculate the number of valid subarrays?
     *  when we meet prefixSum[i], we need to know how many prefixSum[j] (j < i) that satisfy the condition (count)
     *  +) prefixSum[j] % k = prefixSum[i] % k
     *  +) prefixSum[j] % k = prefixSum[i] % k + k
     *  +) prefixSum[j] % k = prefixSum[i] % k - k
     *  => We have {count} subarrays more
     */
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