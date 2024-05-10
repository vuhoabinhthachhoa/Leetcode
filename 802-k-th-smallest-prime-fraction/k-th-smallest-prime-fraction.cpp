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
    vector<int>selects(n-1);
    priority_queue<FractionWithPositions, vector<FractionWithPositions>, FractionWithPositionsCompare> minHeap;
    
    // selects[i] is the number of fractions which were selected at row i

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
        if (i < selects.size() - 1 && j == selects[i + 1]) {
            minHeap.push({{ arr[i + 1], arr[n - 1 - j] }, i + 1, j });
        }
        // push the right fraction
        if (i == 0 || j + 1 < selects[i - 1]) {
            minHeap.push({ { arr[i], arr[n - 1 - (j + 1)]}, i, j + 1});
        }
        
    }
    

    return {};
}
};