class Solution {
public:
    string compressString(string s) {
    string res = "";

    int i = 0;
    while (i < s.size()) {
        int count = 1;
        char currChar = s[i];
        i++; //move to next character

        while (i < s.size() && s[i] == currChar) {
            count++;
            i++;
        }

        res += (char)(count + '0');
        res += currChar;
    }

    return res;
}

string countAndSay(int n) {
    if (n == 1) {
        return "1";
    } 

    string previousSequence = countAndSay(n - 1);
    string res = compressString(previousSequence);
    return res;
}
};