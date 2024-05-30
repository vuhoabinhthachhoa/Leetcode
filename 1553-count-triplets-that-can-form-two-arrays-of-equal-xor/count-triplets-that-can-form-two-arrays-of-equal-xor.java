class Solution {
     public int countTriplets(int[] arr) {
        int n = arr.length;
        int res = 0;
        // count is the number appearances of the prefix x in the array before index i
        Map<Integer, Integer> count = new HashMap<>();

        // total is the number of (indices + 1) that the prefix x appears in the array before index i
        Map<Integer, Integer> total = new HashMap<>();


        int[] prefix = new int[n + 1];
        // prefix has n + 1 elements, because we need to consider the prefix of the first element
        // the prefix of the first element is 0 (we haven't xor with any element yet)

        // initialize value
        prefix[0] = 0;
        count.put(0, 1);
        total.put(0, 0);

        for(int i = 1; i < n + 1; i++) {
            prefix[i] = prefix[i - 1] ^ arr[i - 1];
            int appearances = count.getOrDefault(prefix[i], 0);
            int indices = total.getOrDefault(prefix[i], 0);

            res += appearances * (i - 1) - indices;

            count.put(prefix[i], appearances + 1);
            total.put(prefix[i], indices + i);
        }

        return res;
    }
}