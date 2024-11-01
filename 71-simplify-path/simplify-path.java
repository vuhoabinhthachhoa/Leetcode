class Solution {
    public String simplifyPath(String path) {
        StringBuilder component = new StringBuilder();
        Deque<String> deque = new ArrayDeque<>();

        for(int i = 1 ; i < path.length() + 1 ; i++) {
            if(i == path.length() || path.charAt(i) == '/') {
                if(component.toString().equals("..")) {
                    if(!deque.isEmpty()) {
                        deque.pollLast();
                    }
                }
                else if(!component.toString().equals(".") && !component.isEmpty()){
                    deque.addLast(component.toString());
                }
                component = new StringBuilder();
            }
            else {
                component.append(path.charAt(i));
            }
        }
        if(deque.isEmpty()) {
            return "/";
        }
        StringBuilder res  = new StringBuilder();
        while(!deque.isEmpty()) {
            res.append("/");
            res.append(deque.poll());
        }

        return res.toString();
    }
}