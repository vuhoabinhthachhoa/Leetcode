/**
 * @param {string} num
 * @return {boolean}
 */
var isBalanced = function(num) {
    let numArray = Array.from(num, Number);
    return numArray.reduce(function(acc, val, ind) {
        if (ind % 2 === 0) {
            return acc + val;
        } else {
            return acc - val;
        }
    }, 0) === 0;
};