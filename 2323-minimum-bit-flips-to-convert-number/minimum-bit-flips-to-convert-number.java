class Solution {
    public int minBitFlips(int start, int goal) {
        int number = start^goal;
        int count = 0;
         while (number != 0) {
            count += number & 1;  // Check the LSB
            number >>= 1;          // Right shift to check the next bit
        }
        return count;
    }
}