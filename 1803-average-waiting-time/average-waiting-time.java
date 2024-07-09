class Solution {
   public double averageWaitingTime(int[][] customers) {
        long totalWaitingTime = 0;
        int doneTime = 0;

        for(int i = 0 ; i < customers.length ; i++) {
            int arrivalTime = customers[i][0];
            int completeTime = customers[i][1];
            doneTime = Math.max(doneTime, arrivalTime) + completeTime;
            totalWaitingTime += doneTime - arrivalTime;
        }

        return (double)totalWaitingTime / customers.length;
    }

}