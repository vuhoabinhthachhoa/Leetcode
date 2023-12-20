class Solution {
public:
int stringToInteger(string s) {
	int res = 0;
	for (auto c : s) {
		res = res * 10 + c - '0';
	}

	return res;
}

string multipyString(string s, int times) {
	string res = "";
	for (int i = 0; i < times; i++) {
		res += s;
	}
	return res;
}

string decodeString(string s) {
	// store the position of open blanket and the times. 
	stack<string>st;
	int i = 0;
	int n = s.size();

	while (i < n) {
		if (s[i] == ']') {
			string sub = "";
			// we don't need to check empty stack here because 
			// for every ] there will always be a corresponding [
			while (st.top() != "[") {
				sub = st.top() + sub;
				st.pop();
			}
			// pop the [
			st.pop();
			int times = stringToInteger(st.top());
			st.pop();

			st.push(multipyString(sub, times));
		}

		else if (isdigit(s[i])) {
			int times = 0;
			while (isdigit(s[i])) {
				times = times * 10 + s[i] - '0';
				i++;
			}
			// we need to decrease i by 1 because i now exceed the range of the number. 
			i--;

			// convert the times number to string
			st.push(to_string(times));
		}

		else {
			// convert the s[i] char to string
			string temp = "";
			temp = s[i];
			st.push(temp);
		}

		i++;
	}

	// merge all the strings in the stack
	string res = "";
	while (!st.empty()) {
		res = st.top() + res;
		st.pop();

	}

	return res;
}
};