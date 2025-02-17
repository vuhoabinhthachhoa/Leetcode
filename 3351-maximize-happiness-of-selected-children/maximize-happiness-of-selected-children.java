class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i =0 ; i < happiness.length; i++){
            maxHeap.add(happiness[i]);
        }
        long res = 0;
        int turns = 0;
        while(k-- > 0) {
            int cur = maxHeap.poll() - turns;
            if(cur <= 0) {
                return res;
            }
            res += cur;
            turns++;
        }

        return res;
    }
}