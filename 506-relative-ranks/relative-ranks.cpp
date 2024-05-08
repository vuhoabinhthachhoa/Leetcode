class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& score) {
        vector<int> temp = score;
        sort(temp.begin(), temp.end());
        unordered_map<int, int> mp;
        for(int i = 0 ; i < temp.size() ; i++) {
            mp[temp[i]] = temp.size() - i;
        }
        
        vector<string>res;
        for(auto it : score) {
            int rank = mp[it];
            if(rank == 1) {
                res.push_back("Gold Medal");
            }
            else if(rank == 2) {
                res.push_back("Silver Medal");
            }
            else if(rank == 3) {
                res.push_back("Bronze Medal");
            }
            else{
                res.push_back(to_string(rank));
            }
        }

        return res;
    }
};