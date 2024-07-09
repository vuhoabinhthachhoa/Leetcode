class Solution {
    // Intuition:
    // for each loop, we remove the (k%n)th element from the current array, and move
    // all the previos elements to the end of the array. Then re-number the new array from 0 to n - 1
    // next loop, the size of array is n - 1, because we start number the new array from the next element
    // of the removed element. So the previous index  = (current index + k) % n
    // for example: n = 5, k = 2
    // index:   0 1 2 3 4
    // element: 1 2 3 4 5
    // move 1 to the end and remove 2, then re-number the array
    // index:   0 1 2 3
    // element: 3 4 5 1
    // previous index of 3: 2 ; current index of 3: 0 (2 = (0 + 2) % 4)
    // Therefore, we can solve this problem recursively
    // Recursive formula: f(n, k) = (f(n - 1, k) + k) % n
    // Base case: f(1, k) = 0

    // Below is the iterative implementation for the above recursive formula
    public int findTheWinner(int n, int k) {
        // base case: f(1, k) = 0
        int res = 0;
        // now, we start from n = 2 to n
        for(int i = 2; i <= n; i++) {
            res = (res + k) % i;
        }
        return res + 1;
    }
};