class Solution {
public:
   int leastInterval(vector<char>& tasks, int n) {
	// The idea:
	// we find out the max frequency then we arrange the other elements in all parts between two max frequency's element.
    
	// -- Reason --
	// Ta có thể làm như thế vì các phần tử còn lại luôn có số lượng tối đa là maxFre - 1.
	// Nên ta có thể đặt được tất cả các phần tử con của mỗi phần tử vào các khoảng (tối đa 1 con trong 1 khoảng)
	
	// We can do this because the remaining elements always have a maximum quantity of maxFre - 1.
    // Therefore, we can place all the sub-elements of each element into parts (maximum 1 sub-element in 1 parts).
	//  ---------
	
	// for example: we have 3A 2B 1C, n = 2.
	// we arrange A as follows: A__A__A
	// then we arrange B and C: ABCAB_A
	// so there is one empty slot left,
	// so the result equal to the size of tasks plus empty slots.

	vector<int> mp(26, 0);
	// the max frequencies
	int maxFre = 0;
	// the number of elements with max frequency.
	int maxFreCount = 0;

	for (auto it : tasks) {
		mp[it - 'A']++;
		if (mp[it - 'A'] > maxFre) {
			maxFre = mp[it - 'A'];
			maxFreCount = 1;
		}
		else if (mp[it - 'A'] == maxFre) {
			maxFreCount++;
		}
	}

	// A_A_A
	// assuming that A is the most frequency task and the maxFre is 3
	// so, the part between 3 A elements is 2.
	int partCount = maxFre - 1;

	// the total of remaining tasks after substracting all most frequency tasks.
	int remainTasks = tasks.size() - maxFre * maxFreCount;

    // the number of empty slots after arranging all elements.
	// it's the number of cooldown periods.
	int emptySlots = partCount * (n - (maxFreCount - 1)) - remainTasks;

	// emptySlots may be negative in some case such as:
	// we have 3A 3B 3C 3D, n = 2;
	// so the length of the part between two A is larger than n, so there are no empty slot left.
	emptySlots = max(0, emptySlots);
	
	// the result is equal to the size of tasks plus the number of cooldown periods (remaining emty slots)
	return tasks.size() + emptySlots;
}
};