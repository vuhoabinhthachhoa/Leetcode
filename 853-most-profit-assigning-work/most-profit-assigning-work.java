class Solution {
    // similar to IPO problem: https://leetcode.com/problems/ipo/description/
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] job = new int[profit.length][2];
        for(int i = 0 ; i < profit.length ; i++) {
            job[i][0] = difficulty[i];
            job[i][1] = profit[i];
        }
        Arrays.sort(job, Comparator.comparing(a -> a[0]));
        Arrays.sort(worker);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int maxProfit = 0;
        int j = 0;
        for(int i = 0 ; i < worker.length ; i++) {
            while(j < job.length && worker[i] >= job[j][0]) {
                maxHeap.add(job[j][1]);
                j++;
            }
            if(maxHeap.isEmpty()) continue;
            maxProfit += maxHeap.peek();
        }
        return maxProfit;
    }

}