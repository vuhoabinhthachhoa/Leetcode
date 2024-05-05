class Solution {
public:
    bool isIsomorphic(string s, string t) {
        unordered_map<char, char> mp;
        vector<bool> isUsed(128, false);
        
        for(int i = 0 ; i < s.size() ; i++) {
            if(mp[s[i]] == '\0') {
                if(isUsed[t[i]] == false){
                    mp[s[i]] = t[i];
                    isUsed[t[i]] = true;
                }
                else {
                    return false;
                }
                
            }
            else {
                if(mp[s[i]] != t[i]) {
                    return false;
                }
            }
        }

        return true;
    }
};