class Solution {
    public int heightChecker(int[] heights) {
        int[] freq = new int[101];
        for(int i = 0 ; i < heights.length ; i++) {
            freq[heights[i]]++;
        }

        int res = 0;
        int currHeight = 1;
        for(int i = 0 ; i < heights.length ; i++) {
            while(freq[currHeight] == 0) {
                currHeight++;
            }

            if(heights[i] != currHeight) {
                res++;
            }
            freq[currHeight] --;
        }

        return res;
    }
}