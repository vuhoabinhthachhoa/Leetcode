class Solution {
     public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        Queue<Character> que = new LinkedList<>();
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == ')') {
                while(st.peek() != '(') {
                    que.add(st.pop());
                }
                st.pop();
                while(!que.isEmpty()) {
                    st.push(que.poll());
                }
            }
            else {
                st.push(s.charAt(i));
            }
        }
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()) {
            res.insert(0, st.pop());
        }
        return res.toString();
    }

}