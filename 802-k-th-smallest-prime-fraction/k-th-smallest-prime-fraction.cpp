class Solution {
public:
// Custom structure to store fraction and positions (i, j)
struct FractionWithPositions {
    pair<int, int> fraction;
    int i;
    int j;

    // Constructor
    FractionWithPositions(pair<int, int> frac, int posI, int posJ) : fraction(frac), i(posI), j(posJ) {}
};

// Comparison functor for FractionWithPositions
struct FractionWithPositionsCompare {
    bool operator()(const FractionWithPositions& fwp1, const FractionWithPositions& fwp2) const {
        // Compare fractions first
        if (fwp1.fraction.first * fwp2.fraction.second != fwp2.fraction.first * fwp1.fraction.second)
            return fwp1.fraction.first * fwp2.fraction.second > fwp2.fraction.first * fwp1.fraction.second;
        // If fractions are equal, compare positions (i, j)
        if (fwp1.i != fwp2.i)
            return fwp1.i > fwp2.i;
        return fwp1.j > fwp2.j;
    }
};
vector<int> kthSmallestPrimeFraction(vector<int>& arr, int k) {
    int n = arr.size();
    // we have n - 1 row of fractions
    // e.g : {1,2,3,7,11}
    // 1/11 1/7 1/3 1/2
    // 2/11 2/7 2/3
    // 3/11 3/7
    // 7/11
    // In each row, the left fraction is always smaller than the right fraction
    // In each column, the fraction above is always smaller that the fraction below
    // for each step, we find the smallest fraction in the rest
    // for example, after select 1/11 (0,0), we push the right and above fraction into the minHeap (to compare them), because the other 
    // fractions are all greater than them.

    vector<int>selects(n-1);
    priority_queue<FractionWithPositions, vector<FractionWithPositions>, FractionWithPositionsCompare> minHeap;
    
    // selects[i] is the number of fractions which have already been selected at row i

    minHeap.push({ {arr[0], arr[n-1] }, 0, 0});
    while (true) {
        FractionWithPositions curr = minHeap.top();
        minHeap.pop();
        k--;
        if (k == 0) {
            return { curr.fraction.first, curr.fraction.second };
        }
        int i = curr.i;
        int j = curr.j;
        selects[i]++;

        // push the below fraction
        // we can push below only if its left fraction has already been selected
        if (i < selects.size() - 1 && j == selects[i + 1]) {
            minHeap.push({{ arr[i + 1], arr[n - 1 - j] }, i + 1, j });
        }
        // push the right fraction
        // we can push below only if its above fraction has already been selected
        if (i == 0 || j + 1 < selects[i - 1]) {
            minHeap.push({ { arr[i], arr[n - 1 - (j + 1)]}, i, j + 1});
        }
        
    }
    

    return {};
}
};