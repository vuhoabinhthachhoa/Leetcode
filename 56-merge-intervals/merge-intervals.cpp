class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
    if (intervals.size() <= 1) return intervals;

    sort(intervals.begin(), intervals.end());
    vector<vector<int>> res;

    int leftEdge = intervals[0][0];
    int rightEdge = intervals[0][1];

    for (int i = 1; i < intervals.size(); i++) {
        // cannot merge
        if(intervals[i][0] > rightEdge) {
            res.push_back({ leftEdge, rightEdge });
            leftEdge = intervals[i][0];
            rightEdge = intervals[i][1];
        }
        // can merge
        else {
            rightEdge = max(intervals[i][1], rightEdge); // [0,4] [1,3]
        }
    }
    res.push_back({ leftEdge, rightEdge });

    return res;
}
};