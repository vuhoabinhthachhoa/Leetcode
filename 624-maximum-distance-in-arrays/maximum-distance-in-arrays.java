class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;
        int indMax = -1;
        int indMin = -1;

        for(int i = 0 ; i < arrays.size() ;i++) {
            int last =  arrays.get(i).getLast();
            if (last > max) {
                secMax = max;
                max = last;
                indMax = i;
            } else if (last > secMax) {
                secMax = last;
            }

            int first =  arrays.get(i).getFirst();
            if (first < min) {
                secMin = min;
                min = first;
                indMin = i;
            } else if (first < secMin) {
                secMin = first;
            }
        }
        // if the max and min are in the same array
        // we choose the second max or second min from another array
        // max - sexMax > secMin - min : this means we can achieve the higher difference by choosing the second min than choosing the second max

        if(indMax != indMin) {
            return Math.abs(max - min);
        }
        if(max - secMax > secMin - min) {
            return max - secMin;
        }
        return secMax - min;
    }
}