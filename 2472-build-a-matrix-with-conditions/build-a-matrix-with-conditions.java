class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] res = new int[k][k];
        // apply topo sort on colConditions
        int[] leftsCount = new int[k + 1];

        ArrayList<Integer>[] rights = new ArrayList[k + 1];
        for(int i = 0; i < rights.length; i++) {
            rights[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < colConditions.length ; i++) {
            leftsCount[colConditions[i][1]]++;
            rights[colConditions[i][0]].add(colConditions[i][1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1 ; i < leftsCount.length ; i++) {
            if(leftsCount[i] == 0) {
                q.add(i);
            }
        }

        int n = 0;
        while(!q.isEmpty() && n < k) {
            int curr = q.poll();
            res[0][n++] = curr;
            for(Integer x : rights[curr]) {
                if(--leftsCount[x] == 0) {
                    q.add(x);
                }
            }
        }
        if(n < k) {
            return new int[0][0];
        }

        // apply topo sort on rowConditions
        int[] abovesCount = new int[k + 1];

        ArrayList<Integer>[] belows = new ArrayList[k + 1];
        for(int i = 0; i < belows.length; i++) {
            belows[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < rowConditions.length ; i++) {
            abovesCount[rowConditions[i][1]]++;
            belows[rowConditions[i][0]].add(rowConditions[i][1]);
        }

        Queue<Integer> q2 = new LinkedList<>();
        for(int i = 1 ; i < abovesCount.length ; i++) {
            if(abovesCount[i] == 0) {
                q2.add(i);
            }
        }

        int m = 0;
        Map<Integer, Integer> rowPos = new HashMap<>();
        while(!q2.isEmpty() && m < k) {
            int curr = q2.poll();
            rowPos.put(curr, m++);
            for(Integer x : belows[curr]) {
                if(--abovesCount[x] == 0) {
                    q2.add(x);
                }
            }
        }
        if(m < k) {
            return new int[0][0];
        }

        for(int i = 0 ; i < k ; i++) {
            int pos = rowPos.get(res[0][i]);
            if(pos == 0) continue;
            res[pos][i] = res[0][i];
            res[0][i] = 0;
        }

        return res;
    }
}