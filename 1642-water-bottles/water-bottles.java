class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = 0;
        res += numBottles;
        while(numBottles >= numExchange) {
            // we have [numBottles] empty bottles
            // we can change [changedBottles] bottles
            int changedBottles = numBottles / numExchange;
            // there are [remain] bottles left
            int remain = numBottles - changedBottles*numExchange;
            // we drink all changed bottles and now we have [numBottles] empty bottles      
            res += changedBottles;
            numBottles = remain + changedBottles;
        }
        return res;
    }
}