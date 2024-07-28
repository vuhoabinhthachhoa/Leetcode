class Solution {
    // max cost for each edge is 10^6, the maximum number of edges between any two nodes is 25
    // so the maximum cost for any path is 10^6 * 25
    static final long MAX_COST = (long) Math.pow(10, 6) * 25;
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        // prepare the cost matrix
        long[][] minCosts = new long[26][26];
        for(int i = 0 ; i < 26 ; i++) {
            for(int j = 0 ; j < 26 ; j++) {
                minCosts[i][j] = MAX_COST;
            }
        }
        for(int i = 0 ; i < cost.length ; i++) {
            if(minCosts[original[i]- 'a'][changed[i]- 'a'] == MAX_COST || cost[i] < minCosts[original[i]- 'a'][changed[i]- 'a']) {
                minCosts[original[i]- 'a'][changed[i]- 'a'] = cost[i];
            }
        }
        // floyd warshall algorithm
        for(int k = 0 ; k < 26 ; k++) {
            for(int i = 0 ; i < 26 ; i++) {
                for(int j = 0 ; j < 26 ; j++) {
                    minCosts[i][j] = Math.min(minCosts[i][j], minCosts[i][k] + minCosts[k][j]);
                }
            }
        }


        Long res = 0l;
        for(int i = 0 ; i < source.length() ; i++) {
            if(source.charAt(i) != target.charAt(i)) {
                if(minCosts[source.charAt(i) - 'a'][target.charAt(i) - 'a'] == MAX_COST) {
                    return -1;
                }
                res += minCosts[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
            }
        }

        return res;
    }
}