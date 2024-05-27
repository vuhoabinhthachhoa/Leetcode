class Solution {
    public int specialArray(int[] nums) {
        int currNum = -1;
        int res = 0;
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length) {
            // validEles is the number of elements that are greater than or equal to the nums[i]
            int validEles = nums.length - i;
            if(validEles == nums[i]) {
                return validEles;
            }
            // if validEles is less than nums[i], that means we need to find the number that is equal to validEles and greater than the currNum
            if(validEles < nums[i]) {
                if(validEles > currNum) {
                    return validEles;
                }
                else {
                    return -1;
                }
            }
            // if validEles is greater than nums[i], that means we need to find the greater number than nums[i]
            // for example: nums = {1,2,2,4,4,5}
            // if nums[i] = 2, we have validEles = 5, so we need to find the number that is greater than 2
            currNum = nums[i];
            while(i < nums.length && nums[i] == currNum) {
                i++;
            }
        }
        return -1;
    }

}