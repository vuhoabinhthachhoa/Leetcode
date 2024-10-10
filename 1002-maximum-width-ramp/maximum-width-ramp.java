class Solution {
      public int maxWidthRamp(int[] A) {
        // keep a decreasing stack
        List<Integer> s = new ArrayList<>();
        int res = 0, n = A.length;
        for (int i = 0; i < n; ++i) {
            if (s.size() == 0 || A[i] < A[s.get(s.size() - 1)]) {
                s.add(i);
                // if A[i] >= the top element of the stack, that means A[i] is always greater than at least one element in the stack,
                // therefore we don't need to add A[i] to the stack because we always choose the element in stack which is equal to or less than A[i] to become
                // a left element of a ramp with every elements after A[i]
                // consider this example: 6 0 8 2 1 5
                // i = 2: stack: {6,0} A[i]:8
                // for all elements after 8 (2, 1, 5), we always choose the elements in stack (6 or 0) to become
                // a left element of a ramp with (2, 1, 5) but not 8 because 6 and 0 always in the left of 8 and less than or equal to 8.

            } else {
                // do binary search to find the left most element which <= A[i]
                int left = 0, right = s.size() - 1, mid = 0;
                while (left < right) {
                    mid = (left + right) / 2;
                    if (A[s.get(mid)] > A[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                res = Math.max(res, i - s.get(left));
            }
        }
        return res;
    }
}