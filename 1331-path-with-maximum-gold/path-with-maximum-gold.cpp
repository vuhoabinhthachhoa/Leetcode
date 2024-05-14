class Solution {
public:
   int help(vector<vector<int>>& grid, int i, int j, int m, int n) {
    if (i < 0 || j < 0 || i == m || j == n || grid[i][j] == 0) {
        return 0;
    }
    int valueOfRest = 0;
    int origin = grid[i][j];
    grid[i][j] = 0;
    // down
    valueOfRest = max(valueOfRest, help(grid, i + 1, j, m, n));
    // up
    valueOfRest = max(valueOfRest, help(grid, i - 1, j, m, n));
    // left
    valueOfRest = max(valueOfRest, help(grid, i, j - 1, m, n));
    // right
    valueOfRest = max(valueOfRest, help(grid, i, j + 1, m, n));
    
    grid[i][j] = origin; // backtrack

    return grid[i][j] + valueOfRest;
}

int getMaximumGold(vector<vector<int>>& grid) {
    int res = 0;
    int m = grid.size();
    int n = grid[0].size();

    for(int i = 0 ; i < m ; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] != 0) {
                res = max(res, help(grid, i, j, m, n));
            }
        }
    }

    return res;
}

};