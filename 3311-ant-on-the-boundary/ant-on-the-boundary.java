class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int times = 0;
        int sum = nums[0];
        for(int i = 1 ; i < nums.length ; i++) {
            sum += nums[i];
            if(sum == 0) times ++;
        }
        
        return times;
    }
}