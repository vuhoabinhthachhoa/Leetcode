class Solution {
     public int[] frequencySort(int[] nums) {
        int[] freq = new int[201];
        for(int i = 0 ; i < nums.length ; i++) {
            freq[nums[i] + 100]++;
        }
        ArrayList<Integer>[] sorter = new ArrayList[101];
        for(int i = 0 ; i < 101 ; i++) {
            sorter[i] = new ArrayList<>();
        }

        for(int i = 200 ; i >= 0 ; i--) {
            sorter[freq[i]].add(i - 100);
        }

        int[] res = new int[nums.length];
        int j = 0;
        for(int i = 0 ; i < 101 ; i++ ) {
            // freq: i
            if(sorter[i].isEmpty()) {
                continue;
            }
            for(Integer num : sorter[i]) {
                for(int k = 0 ; k < i ; k++) {
                    res[j++] = num;
                }
            }
        }
        return res;
    }
}