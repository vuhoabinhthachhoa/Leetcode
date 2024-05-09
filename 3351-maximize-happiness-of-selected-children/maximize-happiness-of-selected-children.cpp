class Solution {
public:
    long long maximumHappinessSum(vector<int>& happiness, int k) {
        priority_queue<int> maxHeap;
        for(auto it : happiness) {
            maxHeap.push(it);
        }
        long long maxHappiness = 0;
        int turns = 0;
        while(turns < k) {
            maxHappiness += max((maxHeap.top() - turns), 0);
            maxHeap.pop();
            turns ++;
        }

        return maxHappiness; 
    }
};