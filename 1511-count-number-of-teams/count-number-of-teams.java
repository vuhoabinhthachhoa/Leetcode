class Solution {
    public int numTeams(int[] rating) {
        int res = 0;
        int leftLess = 0;
        int rightGreater = 0;
        for(int i = 1 ; i < rating.length - 1 ; i++) {
            for(int j = 0 ; j < i ; j++) {
                if(rating[j] < rating[i]) {
                    leftLess++;
                }
            }
            for(int k = i + 1 ; k < rating.length ; k++) {
                if(rating[k] > rating[i]) {
                    rightGreater++;
                }
            }
            // ascending order
            res += leftLess * rightGreater;
            // descending order
            res += (i - leftLess) * (rating.length - 1 - i - rightGreater);
            leftLess = 0;
            rightGreater = 0;
        }
        return res;
    }
}