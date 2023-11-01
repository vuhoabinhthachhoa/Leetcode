class TimeMap {
public:
    //timestamps are only non-decreasing (equal to or greater than).
    unordered_map<string, vector<pair<int, string>>>mp;
    void set(string key, string value, int timestamp) {
        mp[key].push_back({ timestamp, value });
    }
    string get(string key, int timestamp) {
        string res = "";
        int low = 0;
        int high = mp[key].size()-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int curr_timestamp = mp[key][mid].first;
            if (curr_timestamp == timestamp) return mp[key][mid].second;
            else if (curr_timestamp > timestamp) high = mid - 1;
            else {
                res = mp[key][mid].second;
                low = mid + 1;
            }
        }
        return res;
    }
};

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap* obj = new TimeMap();
 * obj->set(key,value,timestamp);
 * string param_2 = obj->get(key,timestamp);
 */