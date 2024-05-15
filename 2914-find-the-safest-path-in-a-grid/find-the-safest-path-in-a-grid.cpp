class Solution {
public:
    
void bfsToFindDistance(std::vector<std::vector<int>>& distance, int startI, int startJ, int n) {
	// Create a queue to manage cells to be processed
	std::queue<std::pair<int, int>> q;

	// Start from the initial cell with distance 0
	q.push({ startI, startJ });
	distance[startI][startJ] = 0;

	// Array to represent the four possible directions (down, up, right, left)
	std::vector<std::pair<int, int>> directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

	// Process the queue
	while (!q.empty()) {
		auto [i, j] = q.front();
		q.pop();
		int currDistance = distance[i][j];

		// Explore all four directions
		for (const auto& dir : directions) {
			int newI = i + dir.first;
			int newJ = j + dir.second;

			// Check if the new position is within bounds and not visited (or can be updated with a shorter distance)
			if (newI >= 0 && newI < n && newJ >= 0 && newJ < n && (distance[newI][newJ] > currDistance + 1 || distance[newI][newJ] == -1)) {
				distance[newI][newJ] = currDistance + 1;
				q.push({ newI, newJ });
			}
		}
	}
}

void distanceFromThief(vector<vector<int>>& grid) {
	int n = grid.size();

	for (auto& i : grid) {
		for (auto& j : i) {
			if (j == 1) j = 0;
			else j = -1;
		}
	}

	for (int i = 0; i < n; i ++ ) {
		for (int j = 0; j < n; j++) {
			if (grid[i][j] == 0) {
				bfsToFindDistance(grid, i, j, n);
			}
		}
	}
}



bool isExistPath(vector<vector<int>> distance, int n, int safeness) {
	if (distance[0][0] < safeness) return false;
	queue<pair<int, int>> q;

	q.push({ 0, 0 });
	distance[0][0] = -1;

	// Array to represent the four possible directions (down, up, right, left)
	std::vector<std::pair<int, int>> directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

	while (!q.empty()) {
		auto [i, j] = q.front();
		q.pop();
		if (i == n - 1 && j == n - 1) {
			return true;
		}

		for (const auto& dir : directions) {
			int newI = i + dir.first;
			int newJ = j + dir.second;

			if (newI >= 0 && newI < n && newJ >= 0 && newJ < n && distance[newI][newJ] != -1 && distance[newI][newJ] >= safeness) {
				q.push({ newI, newJ });
				distance[newI][newJ] = -1;
			}
		}
	}
	return false;
}

int maximumSafenessFactor(vector<vector<int>>& grid) {
	int n = grid.size();
	if (grid[0][0] == 1) return 0;

	
	distanceFromThief(grid);

	// binary search
	int low = 0;
	int high = INT_MAX;
	while (low <= high) {
		int mid = low + (high - low) / 2;
		if (high < 20) {
			int x = 3;
		}
		if (isExistPath(grid, n, mid)) {
			low = mid + 1;
		}
		else high = mid - 1;
	}

	return high;

}

};