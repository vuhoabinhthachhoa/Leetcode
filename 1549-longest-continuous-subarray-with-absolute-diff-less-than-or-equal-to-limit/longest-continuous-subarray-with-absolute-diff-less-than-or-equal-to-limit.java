class Solution {
    /* 
    Intuition: use two deques to store the index of the max and min value in the current window.
    How does deque work to maintain the max and min value in the window? See the deque in Data Structure folder. 
    */
    public int longestSubarray(int[] nums, int limit) {
        int res = 1;
        Deque<Integer> max =  new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();
        // initially, add the first element to the deque
        max.addFirst(0);
        min.addFirst(0);
        int j = 0;
        for(int i = 1 ; i < nums.length ; i++) {
            // all the previous elements that are smaller than the current element are useless, remove them
            while(!max.isEmpty() && nums[i] > nums[max.peekLast()]) max.pollLast();
            // add the current element to the deque
            max.addLast(i);
            // all the previous elements that are larger than the current element are useless, remove them
            while(!min.isEmpty() && nums[i] < nums[min.peekLast()]) min.pollLast();
            // add the current element to the deque
            min.addLast(i);
            // if the difference between the max and min value in the current window is larger than limit, shrink the window
            while(nums[max.peekFirst()] - nums[min.peekFirst()] > limit) {
                j++;
                // remove the elements that are out of the window
                if(max.peekFirst() < j) max.pollFirst();
                if(min.peekFirst() < j) min.pollFirst();
            }
            // update the result
            res = Math.max(res, i - j + 1);
         }
        return res;
    }
}