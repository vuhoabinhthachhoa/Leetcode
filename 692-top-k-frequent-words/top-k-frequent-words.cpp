class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
	if (k > words.size()) return{};

	unordered_map<string, int> freq;
	priority_queue < pair<int, string>>q;

	for (auto it : words) {
		freq[it]++;
	}

	for (auto it : freq) {
		q.push({ it.second, it.first });
	}

	vector<string>res;
	int i = 0;
	while (i < k) {
		vector<string> temp;

		int currFreq = q.top().first;
		temp.push_back(q.top().second);
		q.pop();

		while (!q.empty() && currFreq == q.top().first) {
			temp.push_back(q.top().second);
			q.pop();
		}

		sort(temp.begin(), temp.end());

		int j = 0;
		while (i < k && j < temp.size()) {
			res.push_back(temp[j++]);
			i++;
		}
	}

	return res;
}
};