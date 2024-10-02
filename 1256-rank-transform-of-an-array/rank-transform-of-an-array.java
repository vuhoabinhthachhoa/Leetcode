class Solution {
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(pair -> pair[0]));
        int n = arr.length;
        for(int i = 0 ; i< n ; i++) {
            minHeap.add(new int[]{arr[i], i});
        }
        int i = 0;
        int prev = Integer.MIN_VALUE;
        while(!minHeap.isEmpty()) {
            int[] pair = minHeap.poll();
            if(pair[0] > prev) {
                i++;
                prev = pair[0];
            }
            arr[pair[1]] = i;
        }

        return arr;
    }
}