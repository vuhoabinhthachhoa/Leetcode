class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int res = 1;
        Deque<Integer> max =  new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();
        max.addFirst(0);
        min.addFirst(0);
        int j = 0;
        for(int i = 1 ; i < nums.length ; i++) {
            while(!max.isEmpty() && nums[i] > nums[max.peekLast()]) max.pollLast();
            max.addLast(i);
            while(!min.isEmpty() && nums[i] < nums[min.peekLast()]) min.pollLast();
            min.addLast(i);
            while(!max.isEmpty() && !min.isEmpty() && nums[max.peekFirst()] - nums[min.peekFirst()] > limit) {
                j++;
                if(max.peekFirst() < j) max.pollFirst();
                if(min.peekFirst() < j) min.pollFirst();
            }
            res = Math.max(res, i - j + 1);
         }
        return res;
    }
}