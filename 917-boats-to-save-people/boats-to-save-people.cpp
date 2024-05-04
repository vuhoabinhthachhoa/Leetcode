class Solution {
public:
  int numRescueBoats(vector<int>& people, int limit) {
    sort(people.begin(), people.end());
    int n = people.size();
    int res = 0;

    int l = 0;
    int r = n - 1;
    
    while (l < r) {
        // if people[l] + people[r] > limit, that means people[l] can not combine with any other people,
        // therefore we have to spend 1 boat for people[i] (res++)
        // Then, move r to the left (to find lighter people to combine with current people[l])
  
        while (l < r && people[l] + people[r] > limit) {
            r--;
            res++;
        }

        // break out of the loop, there are two cases:
        // 1. We've found a pair of two people
        // 2. l >= r, ex: 2, 3, 3, 3 limit = 4
        // In both two cases, we have to increase res by 1 
        res++;
        l++;
        r--;
    }

    // check l == r, ex: 2, 3, 4, 5, 6 limit = 8
    // after the loop, l = r = 2 (4)
    if (l == r) {
        res++;
    }

    return res;
}
};