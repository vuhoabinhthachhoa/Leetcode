class Solution {
public:
   /*
* Ý tưởng:
* Giả sử mỗi vị trí từ 0->n-1 sẽ có trọng số giảm dần, từ 10^n-1 -> 10^0
* Nên ta cần tìm permutation tiếp theo sao cho s > s hiện tại ( s là tổng tích của từng phần tử với trọng số tương ứng)
* B1: tìm vị trí k lớn nhất sao cho nums[k] < nums[k+1] tức là tìm vị trí cuối cùng mà mảng
* còn tăng dần (sau k thì mảng sẽ giảm dần) để đổi chỗ nó với một phần tử lớn hơn phía sau để làm cho s tăng lên
* ( nhưng cần phải tìm k lớn nhất để đảm bảo s mới là nhỏ nhất.
* B2: tìm vị trí l lớn nhất sao cho l > k và nums[l] > nums[k]. (l đây chính là phần tử sẽ hoán
* đổi vị trí cho k, (nếu chỉ lấy k+1 hoán đổi cho k thì sẽ không đúng vì vì s lúc này sẽ lớn hơn
* s khi hoán đổi l cho k)
* B3: hoán đổi l với k
* B4: đảo ngược mảng từ vị trí k + 1 đến hết (vì sau khi hoán đổi l với k thì ta phải đảm bảo
* phần phía sau vị trí k phải tăng dần để có s nhỏ nhất) (vì khi đổi l với k thì phần phía sau k 
* vẫn giảm dần nên chỉ cần đảo ngược là sẽ thành tăng dần.)
* 
*/

/*
* Idea:
* Suppose each position from 0 to n-1 will have decreasing weights, from 10^n-1 to 10^0.
* So, we need to find the next permutation such that s > current s (where s is the sum product of each element 
* with its corresponding weight).
* Step 1: Find the largest index k such that nums[k] < nums[k+1], i.e., find the last position where the array
* is increasing (after k, the array will decrease). Swap it with a larger element from the rest to increase s
* (but we need to find the largest k to ensure the new s is the smallest possible).
* Step 2: Find the largest index l such that l > k and nums[l] > nums[k]. (l will be the element to swap with k,
* swapping k+1 won't be correct because s would be larger than the s obtained by swapping l with k.)
* Step 3: Swap l with k.
* Step 4: Reverse the array from index k+1 to the end (since after swapping l with k, we need to ensure
* that the part after position k is increasing to achieve the smallest possible s) (after swapping l with k,
* the part after k continues decreasing, so just reversing it will make it increasing).
*/

void nextPermutation(vector<int>& nums) {
	int n = nums.size();

	// find the largest k such that nums[k] < nums[k+1]
	int k = n - 2;
	while (k >= 0 && nums[k] >= nums[k + 1]) k--;

	// if the nums is sorted in descending order, nums is now the largest permutation.
	// So just start again at smallest permutation (ascending order).
	if (k < 0) {
		reverse(nums.begin(), nums.end());
		return;
	}

	// find the largest l such that l > k and nums[l] > nums[k]
	int l = n - 1;
	while (l > k && nums[l] <= nums[k]) l--;

	swap(nums[k], nums[l]);

	reverse(nums.begin() + k + 1, nums.end());
}
};