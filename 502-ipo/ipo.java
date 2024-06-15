class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i = 0; i < n ; i++) {
            maxHeap.add(new int[]{profits[i], capital[i]});
        }
        while(k-- > 0 && !maxHeap.isEmpty()) {
            List<int[]> temp = new ArrayList<>();
            while(!maxHeap.isEmpty() && maxHeap.peek()[1] > w) {
                temp.add(maxHeap.poll());
            }
            int[] currProject = maxHeap.poll();
             if(currProject == null) {
                break;
            }
            w += currProject[0];
            maxHeap.addAll(temp);
        }
        return w;
    }
}