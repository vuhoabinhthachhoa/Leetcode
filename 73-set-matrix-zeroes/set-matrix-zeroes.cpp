class Solution {
public:
    void setZeroes(vector<vector<int>>& a) {
        int m = a.size();
        int n = a[0].size();

        unordered_map<int, bool> rows_with_zeros;
        unordered_map<int, bool> cols_with_zeros;

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j ++) {
                if(a[i][j] == 0) {
                    rows_with_zeros[i] = true;
                    cols_with_zeros[j] = true;
                }
            }
        }

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j ++) {
                if(rows_with_zeros[i] == true || cols_with_zeros[j] == true) {
                    a[i][j] = 0;
                }
            }
        }
    }
};