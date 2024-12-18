/**
 * @param {number[]} nums
 * @return {number}
 */
var countValidSelections = function(nums) {
    let prefixSum = [];
    prefixSum[0] = nums[0];
    for(let i = 1; i < nums.length ; i++) {
        prefixSum[i] = nums[i] + prefixSum[i-1];
    }
    // do prefix sum from right to left
    let sum = 0;
    let res = 0;
    for(let i = nums.length - 1; i >= 0 ;i--) {
        if(nums[i] === 0) {
            // we can move either left or right
            if(sum === prefixSum[i]) {
                res+=2;
            }
            // we can only move to the side that has the greater prefix sum
            else if(Math.abs(sum - prefixSum[i]) === 1) {
                res++;
            }
        }
        else {
            sum += nums[i];
        }
    }
    return res;
};