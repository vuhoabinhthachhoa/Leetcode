class Solution {
    public int heightChecker(int[] heights) {
        int[] freq = new int[101];
        for(int i = 0 ; i < heights.length ; i++) {
            freq[heights[i]]++;
        }

        int res = 0;
        int currHeight = 1;
        // we iterate through the heights array
        for(int i = 0 ; i < heights.length ; i++) {
            // we find the next greater height that is present in the array
            while(freq[currHeight] == 0) {
                currHeight++;
            }
            
            // the current position (i) belongs to the current element of current height
            // if heights[i] != currHeight, that means it is not in the correct position
            if(heights[i] != currHeight) {
                res++;
            }
            // now we move to the next position, so we ignore the current element of currHeight by decrementing the freq
            // for example: if curr position is 0, and this position belongs to one element of height 1,
            // then we move to position 1, this position belongs to the next element in ascending order, so we ignore the current element 
            freq[currHeight] --;
        }

        return res;
    }
}