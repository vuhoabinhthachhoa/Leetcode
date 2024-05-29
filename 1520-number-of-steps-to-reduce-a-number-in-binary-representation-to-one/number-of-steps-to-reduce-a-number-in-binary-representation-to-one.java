class Solution {
  public int numSteps(String s) {
        int steps = 0;
        int carry = 0;
        for(int i = s.length() - 1 ; i >= 1 ; i--) {
            int curr = (s.charAt(i) - '0' + carry) % 2;
            carry = (s.charAt(i) - '0' + carry) / 2;
            if(curr == 1) {
                steps += 2;
                carry += 1;
            } else {
                steps += 1;
            }
        }
        if(carry == 1) steps += 1;
        return steps;
    }

}