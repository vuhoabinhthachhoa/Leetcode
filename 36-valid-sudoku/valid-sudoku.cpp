class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {

	// to check whether curr num already exists in curr row, col, or box.
	vector<vector<bool>> rowCheck(9, vector<bool>(9, false));
	vector<vector<bool>> colCheck(9, vector<bool>(9, false));
	vector<vector<bool>> boxCheck(9, vector<bool>(9, false));

	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
            if (board[i][j] == '.') continue;

			int num = board[i][j] - '0';
			// k is the order of current box.
			int k = i / 3 * 3 + j / 3;
			// why: k = i / 3 * 3 + j / 3
			// i / 3 to cal the number of previous rows
			// i / 3 * 3 to cal the number of boxes in previous rows (each row has 3 boxes)
			// j / 3 to cal the number of boxes from the beginning of current row.

			// if board[5][6] = 2
			// rowCheck[5][1]
			// colCheck[6][1]
			// boxCheck[6][1]
			if (rowCheck[i][num - 1] || colCheck[j][num - 1] || boxCheck[k][num - 1]) return false;
			
			rowCheck[i][num - 1] = colCheck[j][num - 1] = boxCheck[k][num - 1] = true;

		}
	}

	return true;
}
};