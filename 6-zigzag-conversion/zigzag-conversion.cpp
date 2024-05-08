class Solution {
public:
    int nextPosition(int currInd, int currRow, int numRows) {
    // go down: the distance between two postion in the same row is: (go down to the bottom) + (go up to the current row)
    // -> distance = (numRows - currRow) + (numRows - currRow)
    if (((currInd) / (numRows - 1)) % 2 == 0) {
        return currInd += 2 * (numRows - currRow);
    }

    // go up: the distance between two postion in the same row is: (go up to the top) + (go down to the current row)
    // -> distance = (currRow - 1) + (currRow - 1) 
     return currInd += 2 * (currRow - 1);


}

string convert(string s, int numRows) {
    if (s.size() <= 1 || numRows <= 1) return s;
    string res;
    int currRow = 1;

    while (currRow <= numRows) {
        int currInd = currRow - 1;
        while (currInd < s.size()) {
            res.push_back(s[currInd]);
            currInd = nextPosition(currInd, currRow, numRows);
        }
        currRow++;
    }

    return res;
}
};