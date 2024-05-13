class Solution {
public:
    int matrixScore(vector<vector<int>>& grid) {
    int m = grid.size();
    int n = grid[0].size();
    vector<int> zeroesEachCol(n, 0);
    vector<bool> isMoveRow(m, false);
    vector<bool> isMoveCol(n, false);

    // first col
    for (int i = 0; i < m; i++) {
        if (grid[i][0] == 0) {
            isMoveRow[i] = true;
        }
    }

    // row 1 -> n - 1
    for (int i = 1; i < n; i++) {
        int zeroes = 0;
        for (int j = 0; j < m; j++) {
            if (grid[j][i] == 0 && !isMoveRow[j] || grid[j][i] == 1 && isMoveRow[j]) {
                zeroes++;
            }
        }
        if (zeroes > m / 2) {
            isMoveCol[i] = true;
        }
    }

    int res = 0;
    int carry = 0;
    for (int i = n - 1; i >= 0; i--) {
        int sum = 0;
        for (int j = 0; j < m; j++) {
            int isMove = false;
            if (isMoveRow[j]) {
                isMove = !isMove;
            }
            if (isMoveCol[i]) {
                isMove = !isMove;
            }
            if (grid[j][i] == 1 && !isMove || grid[j][i] == 0 && isMove) {
                sum++;
            }
        }
        sum += carry;
        res += (sum % 2) * pow(2, n - 1 - i);
        carry = sum / 2;
    }

    while (carry > 0) {
        res += (carry % 2) * pow(2, n++);
        carry = carry / 2;
    }

    return res;
}
};