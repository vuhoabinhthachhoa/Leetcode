class CityDistancePair {
    int currentCity;
    int currentDistance;

    public CityDistancePair(int currentCity, int currentDistance) {
        this.currentCity = currentCity;
        this.currentDistance = currentDistance;
    }

    public int getCurrentCity() {
        return currentCity;
    }

    public int getCurrentDistance() {
        return currentDistance;
    }
}


class Solution {
        public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        // build adjacent list
        for(int i = 0 ; i < edges.length ; i++) {
            int src = edges[i][0];
            int des = edges[i][1];
            int length = edges[i][2];
            adj[src].add(des);
            adj[src].add(length);
            adj[des].add(src);
            adj[des].add(length);
        }

        int[][] dist = new int[n][n];
        PriorityQueue<CityDistancePair> minHeap = new PriorityQueue<>(new Comparator<CityDistancePair>() {
            @Override
            public int compare(CityDistancePair pair1, CityDistancePair pair2) {
                return pair1.getCurrentDistance() - pair2.getCurrentDistance();
            }
        });

        boolean[] visited = new boolean[n];
        minHeap.add(new CityDistancePair(0, 0));
        while(!minHeap.isEmpty()){
            CityDistancePair curr = minHeap.poll();
            int currCity = curr.getCurrentCity();
            int currDist = curr.getCurrentDistance();
            visited[currCity] = true;
            for(int i = 0 ; i < adj[currCity].size() ; i+=2) {
                int nextCity = adj[currCity].get(i);

                int length = adj[currCity].get(i + 1);
                for(int j = 0 ; j < n ; j++) {
                    if(dist[currCity][j] != 0 && j != nextCity) {
                        int newDist = dist[currCity][j] + length;
                        if(dist[nextCity][j] == 0 || dist[nextCity][j] > newDist) {
                            dist[nextCity][j] = newDist;
                            dist[j][nextCity] = newDist;
                        }
                    }
                }
                if(dist[currCity][nextCity] == 0 || dist[currCity][nextCity] > length) {
                    dist[currCity][nextCity] = length;
                    dist[nextCity][currCity] = length;
                }
                if(visited[nextCity]) {
                    continue;
                }
                minHeap.add(new CityDistancePair(nextCity, currDist + length));
            }
        }

        int min = n-1;
        int res = -1;
        for(int i = 0 ; i < n ; i++) {
            int currDistanceThreshold = 0;
            for(int j = 0 ; j < n ; j++) {
                if(dist[i][j] <= distanceThreshold && dist[i][j] != 0) {
                    currDistanceThreshold ++;
                }
            }
            if(currDistanceThreshold <= min) {
                min = currDistanceThreshold;
                res = i;
            }
        }
        return res;
    }
 
}