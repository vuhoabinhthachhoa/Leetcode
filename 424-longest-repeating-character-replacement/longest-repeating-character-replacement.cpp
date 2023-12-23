class Solution {
public:
   int characterReplacement(string s, int k) {
	int n = s.size();
	vector<int>mp(26, 0);
	int end = 0, start = 0;
	int maxFreq = 0;
	int res = 0;
	
	for (end = 0; end < n; end++) {
		if(++mp[s[end] - 'A'] > maxFreq) maxFreq = mp[s[end] - 'A'];
		
		// shrink the window until the window is satisfied
		while (end - start + 1 - maxFreq > k) {
			mp[s[start] - 'A']--;
			// if the element just removed from the window is the max frequent element, update the maxFreq.
			if (mp[s[start] - 'A'] + 1 == maxFreq) {
				for (int i = 0; i < 26; i++) {
					if (mp[i] > maxFreq) maxFreq = mp[i];
				}
			}
			// shrink the window
			start++;
		}

		res = max(end - start + 1, res);
	}

	return res;
}
};