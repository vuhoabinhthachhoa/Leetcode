class Solution {
     public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            if(!map.containsKey(winner)){
                map.put(winner, 0);
            }
            map.put(loser, map.getOrDefault(loser, 0) + 1);
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> notLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                oneLoss.add(entry.getKey());
            }
            else if(entry.getValue() == 0) {
                notLoss.add(entry.getKey());
            }
        }
        // sort notLost and oneLoss
        Collections.sort(notLoss);
        Collections.sort(oneLoss);
        res.add(notLoss);
        res.add(oneLoss);
        return res;
    }
}