class Solution {
public:
   int leastInterval(vector<char>& tasks, int n) {
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
	// assuming that A is the most frequency element and the maxFre is 3
	// so, the part between 3 A elements is 2.
	int partCount = maxFre - 1;

	// the total of empty slots in all parts.
	int remainTasks = tasks.size() - maxFre * maxFreCount;
    
	int emptySlots = partCount * (n - (maxFreCount - 1)) - remainTasks;
	emptySlots = max(0, emptySlots);
	
	return tasks.size() + emptySlots;
}
};