class Solution {
public:
    int nextPosition(int currInd, int currRow, int numRows) {
    // There are two types of positions: 
    // Going down: the distance between two positions in the same row is (go to the bottom) + (go up to the current row).
    // -> distance = (numRows - currRow) + (numRows - currRow).
    if (((currInd) / (numRows - 1)) % 2 == 0) {
        return currInd += 2 * (numRows - currRow);
    }

    // Going up: the distance between two positions in the same row is (go up to the top) + (go down to the current row).
    // -> distance = (currRow - 1) + (currRow - 1). 
     return currInd += 2 * (currRow - 1);
}

string convert(string s, int numRows) {
    if (s.size() <= 1 || numRows <= 1) return s;
    string res;
    int currRow = 1;

    while (currRow <= numRows) {
        // The start position of each row equals to that row itself - 1.
        int currInd = currRow - 1;
        while (currInd < s.size()) {
            res.push_back(s[currInd]);
            // Move to the next position at the same row.
            currInd = nextPosition(currInd, currRow, numRows);
        }
        currRow++;
    }

    return res;
}

};