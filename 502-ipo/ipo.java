class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        for(int i = 0; i < n; i++) {
            projects[i] = new int[]{profits[i], capital[i]};
        }
        Arrays.sort(projects, (a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int i = 0;
        while(k-- > 0 ) {
            while(i < n && projects[i][1] <= w) {
                maxHeap.offer(projects[i++][0]);
            }
            if(maxHeap.isEmpty()) {
                break;
            }
            w += maxHeap.poll();
        }
        return w;
    }
}