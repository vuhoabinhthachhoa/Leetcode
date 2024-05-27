class Solution {
    public int specialArray(int[] nums) {
        int currNum = -1;
        int res = 0;
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length) {
            int validEles = nums.length - i;
            if(validEles == nums[i]) {
                return validEles;
            }
            if(validEles < nums[i]) {
                if(validEles > currNum) {
                    return validEles;
                }
                else {
                    return -1;
                }
            }
            currNum = nums[i];
            while(i < nums.length && nums[i] == currNum) {
                i++;
            }
        }
        return -1;
    }
}