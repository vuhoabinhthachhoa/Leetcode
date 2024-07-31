class Solution {
    // using top down dynamic programming
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        // dp[i] represents the minimum height of the shelf to store the first i books
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = books[0][1]; // the minimum height of the shelf to store the first book is its height
        for(int i = 1 ; i < n ; i++) {
            int currWidth = 0;
            int maxHeight = 0;
            // we set the ith book as the last book on the current level of the shelf
            // we need to consider all the cases that the ith book is the last book on a level.
            // we add books from the ith book to the first book
            // for each time we add a book, it is a case that the ith book is the last book on a level
            // by doing this, we can consider all the cases.
            for(int j = i ; j >= 0 ; j--) {
                currWidth += books[j][0]; // add the width of the current book
                if(currWidth > shelfWidth) { // if the width exceeds the shelf width, we can't add more books, so we break
                    break;
                }
                maxHeight = Math.max(maxHeight, books[j][1]); // update the maximum height of the current level of the shelf
                // dp[j - 1]: the minimum height of the shelf to store the first j - 1 books
                // maxHeight: the height of the current level of the shelf
                // so the minimum height to store the first i books = dp[j - 1] + maxHeight
                
                if(j == 0)
                    dp[i] = Math.min(dp[i], maxHeight); // j = 0 means all the first i books can be stored on the same level
                else{
                    dp[i] = Math.min(dp[i], dp[j - 1] + maxHeight);
                }
            }
        }

        return dp[n-1];
    }
}