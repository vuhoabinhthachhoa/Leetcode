class Solution {
public:
    void help(vector<string>& res, int n, string ds = "", int opens = 0, int closes = 0) {
	// if the number of opening and closing parethesis are equal to n, the ds is now a valid string
	if (opens == n && closes == n) {
		res.push_back(ds);
		return;
	}

	// the number of closing parenthesis is always less than or equal to the numbers of opening one.
	if (opens > closes) {
		help(res, n, ds + ')', opens, closes + 1);
	}
	
	// if the number of opening parenthesis is equal to n, return. his string cannot form a valid string.
	// for example: ()( with n = 2. if we push (, the string would be ()(( --> invalid.
	if (opens == n) return;
	help(res, n, ds+ '(', opens + 1, closes);
}

vector<string> generateParenthesis(int n) {
	vector<string>res;
	help(res, n);
	return res;
}
};