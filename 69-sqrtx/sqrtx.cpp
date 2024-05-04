class Solution {
public:
   int binarySearch(int low, int high, int x) {

	while (high  >= low) {
		int mid = low + (high - low) / 2;
	
		if ((long long)mid * mid > x) high = mid - 1;
		else {
			low = mid + 1;
		}
	}

	return high;
}

int mySqrt(int x) {
	// exceptional case
	if (x == 1) return 1;
	return binarySearch(0, x / 2, x);
}
};