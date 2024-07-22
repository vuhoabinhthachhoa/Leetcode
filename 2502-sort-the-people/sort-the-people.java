class Solution {
     public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> mp = new TreeMap<>();
        for(int i = 0 ; i < heights.length ; i++) {
            mp.put(heights[i], names[i]);
        }

        String[] res = new String[heights.length];
        int i = heights.length - 1;
        for(Map.Entry<Integer, String> entry : mp.entrySet()) {
            res[i--] = entry.getValue();
        }
         return res;
    }
}