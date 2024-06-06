class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize > 0) {
            return false;
        }
        Map<Integer, Integer> mp = new HashMap<>();

        Arrays.sort(hand);
        for(int i = 0 ; i < n ; i++) {
            mp.put(hand[i], mp.getOrDefault(hand[i], 0) + 1);
        }

        for(int i = 0 ; i < n ; i++) {
            int val = mp.getOrDefault(hand[i], 0);
            mp.put(hand[i], 0);
            if(val == 0) {
                continue;
            }

            for(int j = 1 ; j < groupSize; j++) {
                int currVal = mp.getOrDefault((hand[i] + j), 0);
                if(currVal >= val) {
                    mp.put((hand[i] + j), currVal - val);
                }
                else return false;
            }
        }
        // 1 2 2 3 3 4 6 7 8


        return true;
    }
}