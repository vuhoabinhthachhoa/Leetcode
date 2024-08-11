 class Pair {
    private Integer first;
    private Integer second;

    public Pair(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }

    public Integer getFirst() {
        return first;
    }

    public Integer getSecond() {
        return second;
    }

    public void setFirst(Integer first) {
        this.first = first;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }
    }

class Solution {
   

    int[][] adj = new int[][]{
            {-1, 0}, // up
            {1, 0},  // down
            {0, -1}, // left
            {0, 1}   // right
    };
    public int bfs(int[][] grid, int startI, int startJ, int land) {
        int m = grid.length;;
        int n = grid[0].length;
        // bfs to count the number of islands;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startI, startJ));
        grid[startI][startJ] = -land;

        int eleCount = 0;
        while(!queue.isEmpty()) {
            Pair currEle = queue.poll();
            eleCount++;
            int currI = currEle.getFirst();
            int currJ = currEle.getSecond();

            for(int i = 0 ; i < 4 ; i++) {
              int newI = currI + adj[i][0];
              int newJ = currJ + adj[i][1];
              if(newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] == land) {
                  queue.add(new Pair(newI, newJ));
                  grid[newI][newJ] = -land;
                  // we have to mark the visited node as -land right after we add it to the queue
                  // if we mark it as -land after we poll it from the queue, we may add the same node
                  // to the queue multiple times.
              }
            }
        }
        return eleCount;
    }

    public int minDays(int[][] grid) {
        int m = grid.length;
        int n= grid[0].length;

        int land = 1;
        int isLandCount = 0;
        int eleCount = 0;
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(grid[i][j] == land) {
                    eleCount = bfs(grid, i, j, land);
                    isLandCount++;
                }
            }
        }
        if(isLandCount != 1) {
            return 0;
        }
        // exceptional case
        if(eleCount == 1) {
            return 1;
        }

        land = -land;
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(grid[i][j] == land) {
                    grid[i][j] = -land;
                    for(int k = 0 ; k < 4 ; k++) {
                        int newI = i + adj[k][0];
                        int newJ = j + adj[k][1];
                        if(newI >= 0 && newI < m && newJ >= 0 && newJ < n && grid[newI][newJ] == land) {
                            int currEle = bfs(grid, newI, newJ, land);
                            if(currEle != eleCount - 1) {
                                return 1;
                            }
                            land = -land;
                            break;
                        }
                    }
                }
            }
        }
        return 2;
    }
}