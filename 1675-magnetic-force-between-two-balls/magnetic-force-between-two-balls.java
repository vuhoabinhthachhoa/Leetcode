class Solution {
   boolean isValidForce(int[] position, int m, int distance) {
        int currPos = position[0];
        m--;
        int i = 1;
        while(i < position.length) {
            if(position[i] - currPos >= distance) {
                currPos = position[i];
                m--;
                if(m == 0) return true;
            }
            i++;
        }
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