class Solution {
public:
   string countingSort(string s) {
	int n = s.size();
	string res(n,' ');
	vector<int> countArray(26, 0);

	for (int i = 0; i < n; i++) {
		countArray[s[i] - 'a']++;
	}

	for ( int i = 1; i < 26; i++) {
		countArray[i] += countArray[i - 1];
	}

	for (int i = n-1; i >= 0; i--) {
		res[countArray[s[i] - 'a']-1] = s[i];
		countArray[s[i] - 'a']--;
	}

	return res;

}

vector<vector<string>> groupAnagrams(vector<string>& strs) {
	unordered_map<string, vector<string>> mp;

	for (auto it : strs) {
		mp[countingSort(it)].push_back(it);
	}

	vector<vector<string>>res;

	for (auto it : mp) {
		res.push_back(it.second);
	}
	
	return res;
}
};