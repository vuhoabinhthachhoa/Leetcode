class Solution {
public:
    int findMaxK(vector<int>& nums) {
        unordered_map<int, bool> mp;
        for(auto it : nums) {
            if(it < 0) {
                mp[it] = true;
            }
        }

        int Max = -1;
        for(auto it : nums) {
            if(it > 0 && mp[-it] && it > Max) {
                Max = it;
            }
        }

        return Max;
    }
};