class Solution {
public:
/*
- we traverse through every worker and set their ratio for current group to check all cases
- The reasons why we have to sort workers by ratio
    + to find the minimum wage for the current group, we have to find the minimum possible ratio which satisfies all workers who have been traversed(the current ratio is the minimum ratio)
    + we traverse from the worker with smaller ratio to greater ratios because if we traverse from worker with greater ratio to smaller ratio, the ratio of smaller ratio does not satisfy the worker with greater ratio  
*/
    double mincostToHireWorkers(vector<int> q, vector<int> w, int K) {
        vector<vector<double>> workers;
        for (int i = 0; i < q.size(); ++i)
            workers.push_back({(double)(w[i]) / q[i], (double)q[i]});
        sort(workers.begin(), workers.end());
        double res = DBL_MAX, qsum = 0;
        priority_queue<int> pq;
        for (auto worker: workers) {
            qsum += worker[1], pq.push(worker[1]);
            if (pq.size() > K) qsum -= pq.top(), pq.pop();
            if (pq.size() == K) res = min(res, qsum * worker[0]);
        }
        return res;
    }
};