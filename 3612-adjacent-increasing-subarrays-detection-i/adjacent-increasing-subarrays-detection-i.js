/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var hasIncreasingSubarrays = function(nums, k) {
    let left = 0;
    let validArraysStartPoints = new Set();
    if(k === 1) {return nums.length >= 2;}

    for(let right = 0 ; right < nums.length ; right++) {
        if(nums[right] > nums[right - 1]) {
            if(right - left + 1 === k) {
                validArraysStartPoints.add(left);
                left++;
            }
        }
        else {
            left = right;
        }
    }
    for(let ele of validArraysStartPoints) {
        if(validArraysStartPoints.has(ele + k)) {
            return true;
        }
    }
    return false;

};
