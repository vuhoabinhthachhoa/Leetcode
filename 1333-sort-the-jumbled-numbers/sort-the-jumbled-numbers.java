class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[] mappedValue = new int[n];
        for(int i = 0 ; i < n ; i++) {
            int num = nums[i];
            // deal with case num = 0
            StringBuilder temp = new StringBuilder();
            temp.append(mapping[num % 10]);
            num /= 10;
            while(num > 0) {
               temp.append(mapping[num % 10]);
                num /= 10;
            }
            // reverse temp
            int value = 0;
            for(int  k= temp.length() -1  ; k >= 0 ; k--) {
                value = value * 10 + temp.charAt(k) - '0';
            }
            mappedValue[i] = value;
            int currNum = nums[i];
            int j = i - 1;
            // insert
            while(j >= 0 && mappedValue[j] > value) {
                mappedValue[j + 1] = mappedValue[j];
                nums[j+1] = nums[j];
                j--;
            }
            mappedValue[j + 1] = value;
            nums[j + 1] = currNum;
        }
        return nums;
    }
}