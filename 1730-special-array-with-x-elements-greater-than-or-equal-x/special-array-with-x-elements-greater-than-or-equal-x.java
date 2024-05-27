class Solution {
    public int specialArray(int[] nums) {
        int l = 0;
        int h = nums.length;
        while(l <= h) {
            int mid = l + (h - l) / 2;
            int count = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] >= mid) {
                    count++;
                }
            }
            if(count > mid) {
                l = mid + 1;
            }
            else if(count < mid) {
                h = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}