class Solution {
public:
        vector<int> findClosestElements(vector<int>& A, int k, int x) {
        int left = 0, right = A.size() -k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - A[mid] > A[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        return vector<int>(A.begin() + right, A.begin() + right + k);
    }
};