class Solution {
        public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> outcomes = new ArrayList<>();
        for(int i = 0; i < n; i++){
            outcomes.add(new ArrayList<>());
        }
        for(int i = 0 ; i < invocations.length ; i++){
            outcomes.get(invocations[i][0]).add(invocations[i][1]);
        }

        Set<Integer> suspicious = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        suspicious.add(k);
        boolean[] visited = new boolean[n];
        visited[k] = true;

        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int i : outcomes.get(curr)){
                if(!visited[i]){
                    queue.add(i);
                    suspicious.add(i);
                    visited[i] = true;
                }
            }
        }

        boolean canRemove = true;
        outerLoop:
        for(int i = 0 ; i < n ; i++){
            if(suspicious.contains(i)){
               continue;
            }
            for(int j : outcomes.get(i)){
                if(suspicious.contains(j)){
                    canRemove = false;
                    break outerLoop;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        if(canRemove){
            for(int i = 0 ; i < n ; i++){
                if(!suspicious.contains(i)){
                    res.add(i);
                }
            }
        }
        else {
            for(int i = 0 ; i < n ; i++){
                res.add(i);
            }
        }

        return res;
    }

}