class Solution {
    class DisjointSetBySize {
    private int[] parent;
    private int[] size;
    private int numSets;

    public DisjointSetBySize(int n) {
        parent = new int[n];
        size = new int[n];
        numSets = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int u) {
        if (parent[u] == u) return u;
        return parent[u] = find(parent[u]);
    }

    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU == rootV) return;
        numSets--;
        if (size[rootU] > size[rootV]) {
            parent[rootV] = rootU;
            size[rootU] += size[rootV];
        } else {
            parent[rootU] = rootV;
            size[rootV] += size[rootU];
        }
    }
    public int getNumSets() {
        return numSets;
    }
}


    public int regionsBySlashes(String[] grid) {
        // the ordinal number of grid[i][j]:
        //  - the first half: i*grid.length*2 + j*2
        //  - the second half: i*grid.length*2 + j*2 + 1
        int n = grid.length * grid[0].length()*2;
        DisjointSetBySize ds = new DisjointSetBySize(n);

        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid.length ; j++) {
                char currSquare = grid[i].charAt(j);
                // the ordinal number of first and second half
                int firstHalf = i*grid.length*2 + j*2;
                int secondHalf = i*grid.length*2 + j*2 + 1;

                // connect two halfs
                if(grid[i].charAt(j) == ' ') {
                    ds.union(firstHalf, secondHalf);
                }

                // connect to the left square
                if(j - 1 >= 0 ){
                    int leftSquare = grid[i].charAt(j-1);
                    int firstHalfLeft = i*grid.length*2 + (j-1)*2;
                    int secondHalfLeft = i*grid.length*2 + (j-1)*2 + 1;

                    ds.union(firstHalf, secondHalfLeft);
                }

                // connect to the above square
                if(i - 1 >= 0) {
                    char aboveSquare = grid[i-1].charAt(j);
                    int firstHalfAbove = (i-1)*grid.length*2 + j*2;
                    int secondHalfAbove = (i-1)*grid.length*2 + j*2 + 1;

                    if(aboveSquare == '\\') {
                        // case 4
                        if(currSquare == '\\') {
                            ds.union(secondHalf, firstHalfAbove);
                        }
                        // case 3
                        else {
                            ds.union(firstHalf, firstHalfAbove);
                        }
                    }
                    else {
                        // case 2
                        if(currSquare == '\\') {
                            ds.union(secondHalf, secondHalfAbove);
                        }
                        // case 1
                        else {
                            ds.union(firstHalf, secondHalfAbove);
                        }
                    }
                }
            }
        }
        return ds.getNumSets();
    }
}