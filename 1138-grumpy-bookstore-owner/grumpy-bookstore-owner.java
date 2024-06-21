class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int techSatisfied = 0; // the numbers that can be satisfied by the tech (intially, these customers are not satisfied
                                                                                // but after applying the grumpy technique, they are satisfied)
        int totalSatisfied = 0; // the number of customers that are satisfied without applying the grumpy technique

        for(int i = 0; i < minutes; i++) {
            if(grumpy[i] == 1) {
                techSatisfied += customers[i];
            }
            else {
                totalSatisfied += customers[i];
            }
        }
        int maxTechSatified = techSatisfied;
        for(int right = minutes ; right < customers.length ; right++) {
            int left = right - minutes;
            if(grumpy[right] == 0) {
                totalSatisfied += customers[right];
            }
            else {
                techSatisfied += customers[right];
            }
            if(grumpy[left] == 1) {
                techSatisfied -= customers[left];
            }
            maxTechSatified = Math.max(techSatisfied, maxTechSatified);
        }
        
        // the maximum satisfied customers are the total satisfied customers + the maximum satisfied customers by the tech
        return totalSatisfied += maxTechSatified;
    }
}