class Solution {
public:
   bool isIsomorphic(string s, string t) {
    unordered_map<char, char> mp;
    vector<bool> isUsed(128, false);
    
    for(int i = 0 ; i < s.size() ; i++) {
        // If s[i] hasn't been mapped to any t[i] before.
        if(mp[s[i]] == '\0') {
            // If t[i] hasn't been used for mapping before.
            if(isUsed[t[i]] == false) {
                mp[s[i]] = t[i];
                isUsed[t[i]] = true;
            }
            // If t[i] has already been used for mapping, therefore we
            // can't use t[i] for mapping to s[i], return false.
            else {
                return false;
            }
        }
        // If s[i] has already been mapped to any t[i] before.
        else {
            // If s[i] does not map to t[i] as the same as the previous mapping, return false.
            if(mp[s[i]] != t[i]) {
                return false;
            }
        }
    }

    return true;
}

};