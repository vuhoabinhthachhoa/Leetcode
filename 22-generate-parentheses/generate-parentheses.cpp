class Solution {
public:
    void help(vector<string>& res, int n, string ds = "", int opens = 0, int closes = 0) {

	if (opens == n && closes == n) {
		res.push_back(ds);
		return;
	}

	if (opens > closes) {
		ds.push_back(')');
		help(res, n, ds, opens, closes + 1);
		ds.pop_back();
	}
	
	if (opens == n) return;
	ds.push_back('(');
	help(res, n, ds, opens + 1, closes);
	ds.pop_back();
}

vector<string> generateParenthesis(int n) {
	vector<string>res;
	help(res, n);
	return res;
}
};