class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
	int n = temperatures.size();
	vector<int>res(n, 0);

	// {value, pos} ex: {a[i], i}
	stack < pair<int, int>>st;

	for (int i = 0; i < n; i++) {
		while (!st.empty() && st.top().first < temperatures[i]) {
			int pos = st.top().second;
			res[pos] = i - pos;
			st.pop();
		}

		st.push({ temperatures[i], i });
	}

	return res;
}
};