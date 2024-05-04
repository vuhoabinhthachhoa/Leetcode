class Solution {
public:
   int numRescueBoats(vector<int>& people, int limit) {
    sort(people.begin(), people.end());
    int n = people.size();
    int res = 0;

    int l = 0;
    int r = n - 1;

    while (l < r) {
    while (l < r && people[l] + people[r] > limit) {
        r--;
        res++;
    }
    res++;
    l++;
    r--;
}
if (l == r) {
    res++;
}

    return res;
}
};