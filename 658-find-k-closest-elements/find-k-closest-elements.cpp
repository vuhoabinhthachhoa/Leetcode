class Solution {
public:
    int binarySearch(vector<int>& arr, int x) {
	int low = 0;
	int high = arr.size() - 1;

	while (low <= high) {
		int mid = low + (high - low) / 2;
		
		if (arr[mid] > x) {
			high = mid - 1;
		}
		else if (arr[mid] < x) {
			low = mid + 1;
		}
		else return mid;
	}

	return high;
}

vector<int> findClosestElements(vector<int>& arr, int k, int x) {
	vector<int>res;

	// find the position of x in arr, if x doesn't apear in arr, find the position of the largest element that < x.
	int pos = binarySearch(arr, x);
	int left = pos;
	int right = pos + 1;
	
	// we need to check pos>= because if x is less than all elements in arr, the pos would be -1.
	if (pos>=0 && arr[pos] == x) {
		k--;
		left = pos - 1;
		res.push_back(x);
	}

	while (k > 0 && left>=0 && right<arr.size()) {
		if (x - arr[left] <= arr[right] - x) {
			res.insert(res.begin(), arr[left]);
			left--;
		}
		else {
			res.push_back(arr[right]);
			right++;
		}
		k--;
	}

	while (k > 0 && left >= 0) {
		res.insert(res.begin(), arr[left]);
		left--;
		k--;
	}
	while (k > 0 && right < arr.size()) {
		res.push_back(arr[right]);
		right++;
		k--;
	}

	return res;
}

};