class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int techSatisfied = 0;
        int totalSatisfied = 0;
       
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

        return totalSatisfied += maxTechSatified;
    }
}