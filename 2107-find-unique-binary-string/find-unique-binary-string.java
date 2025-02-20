class Solution {
    Set<String> set = new HashSet<>();

    public String backtrack(String cur, int n) {
        if(n == 0) {
            if(!set.contains(cur)) {
                return cur;
            }
            return "";
        }
        String res1 = backtrack(cur + '0', n - 1);
        if(!res1.isEmpty()) return res1;
        String res2 = backtrack(cur + '1', n - 1);
        if(!res2.isEmpty()) return res2;
        return "";
    }

    public String findDifferentBinaryString(String[] nums) {
        set.addAll(Arrays.asList(nums));
        int n = nums[0].length();
        String res = backtrack("", n);

        return res;
    }
}
