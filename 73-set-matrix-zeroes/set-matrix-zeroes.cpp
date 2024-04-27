class Solution {
public:
    void setZeroes(vector<vector<int>>& a) {
        int m = a.size();
        int n = a[0].size();

        unordered_map<int, bool> rows;
        unordered_map<int, bool> cols;

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j ++) {
                if(a[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j ++) {
                if(rows[i] == true || cols[j] == true) {
                    a[i][j] = 0;
                }
            }
        }
    }
};