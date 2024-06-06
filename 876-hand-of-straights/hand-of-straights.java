class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize > 0) {
            return false;
        }
        Map<Integer, Integer> mp = new HashMap<>();

        Arrays.sort(hand);
        // count the frequency of each element
        for(int i = 0 ; i < n ; i++) {
            mp.put(hand[i], mp.getOrDefault(hand[i], 0) + 1);
        }

        for(int i = 0 ; i < n ; i++) {
            int val = mp.getOrDefault(hand[i], 0);
            mp.put(hand[i], 0);
            if (val == 0) {
                continue;
            }
            // for each element with frequency > 0, check if we can form a group of size groupSize starting from that element
            // we sort the array so that we can assure that the element that we are currently checking is the smallest element in the group
            for (int j = 1; j < groupSize; j++) {
                int currVal = mp.getOrDefault((hand[i] + j), 0);
                if (currVal >= val) {
                    mp.put((hand[i] + j), currVal - val);
                } else return false;
            }
        }
        
        return true;
    }
}