class Solution {
   boolean isValidForce(int[] position, int m, int distance) {
        // we always put the first ball at the first position
        int currPos = position[0];
        m--; // we have already put one ball, so we need to put remaining m-1 balls
        int i = 1;
        while(i < position.length) {
            // for each ball, we find the next position that is at least [distance] away from the current ball
            if(position[i] - currPos >= distance) {
                currPos = position[i];
                m--;
                // if we have put all the balls, we return true
                if(m == 0) return true;
            }
            i++;
        }
        // if we have not put all the balls, we return false
        return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1;
        int high = (position[position.length -1] - position[0]) / (m -1);

        while(low <= high) {
            int mid = low + (high - low) / 2;
            boolean valid = isValidForce(position, m, mid);
            if(valid) {
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return high;
    }
}