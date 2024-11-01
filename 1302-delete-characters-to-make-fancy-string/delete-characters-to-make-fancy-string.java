class Solution {
 public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        for(int i = 1 ; i < sb.length() ; i++) {
            if(sb.charAt(i) == sb.charAt(i - 1)) {
                count++;
            }
            else {
                count = 0;
            }
            if(count == 2){
                count--;
                sb.deleteCharAt(i);
                i--;
            }
        }
        return sb.toString();
    }
}