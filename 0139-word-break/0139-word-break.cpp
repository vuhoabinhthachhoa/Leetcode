class Solution {
public:
bool wordBreak(string s, vector<string>& wordDict) {
	unordered_map<string, bool>mp;
	for (string s : wordDict) {
		mp[s] = true;
	}
	int n = s.size();
	vector<vector<bool>>wb(n, vector<bool>(n,false));
	//initialize value
	for (int i = 0; i < n; i++){
		wb[i][i] = mp[s.substr(i, 1)];
	}
	int k = 1;
	while(k<n){
		for (int i = 0; i < n - k; i++) {
			int start = i;
			int end = i + k;
			bool check = false;
			for (int j = start; j < end; j++) {
				if (wb[start][j] && wb[j + 1][end]) {
					check = true;
					break;
				}
			}
			wb[start][end] = check || mp[s.substr(start, end - start + 1)];
		}
		k++;
	}
	
	return wb[0][n - 1];
}
};