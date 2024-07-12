class Solution {
    public int maximumGain(String s, int x, int y) {
        // x: ab, y: ba
        char first, second;
        int greater, lower;
        if(y > x) {
            first = 'b';
            second = 'a';
            greater = y;
            lower = x;
        }
        else {
            first = 'a';
            second = 'b';
            greater = x;
            lower = y;
        }
        int res = 0 ;
        // assume x > y; first = a; second = b;
        Stack<Character> st = new Stack<>();
        // first phase: remove all the substring with greater point
        st.push(s.charAt(0));
        for(int i = 1 ;  i < s.length() ; i++) {
            if(s.charAt(i) == second && !st.empty() && st.peek() == first) {
                st.pop();
                res += greater;
            }
            else {
                st.push(s.charAt(i));
            }
        }
        // phase 2: remove all the substring with lower point
        Stack<Character> st2 = new Stack<>();
        while(!st.empty()) {
            char c = st.pop();
            if(c == second && !st2.empty() && st2.peek() == first) {
                st2.pop();
                res += lower;
            }
            else {
                st2.push(c);
            }
        }
        return res;
    }
}