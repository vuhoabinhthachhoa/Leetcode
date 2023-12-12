class Solution {
private:
	// store the owner of each email
	unordered_map<string, string> owners;
	
	// store the parent of each email
	unordered_map<string, string> parents;

	unordered_map<string, int> rank;
	
	// store the union to which each email belongs.
	unordered_map<string, set<string>> unions;
public:
	// function to find the ultimate parent
	string findUPar(string email) {
		if (email == parents[email]) return email;
		return parents[email] = findUPar(parents[email]);
	}

	void unionByRank(string u, string v) {
		string ulp_u = findUPar(u);
		string ulp_v = findUPar(v);

		// if u and v are in the same component.
		if (ulp_u == ulp_v) return;

		// connect the smaller component to the bigger one.
		if (rank[ulp_u] > rank[ulp_v]) {
			parents[ulp_v] = ulp_u;
		}
		else if (rank[ulp_u] < rank[ulp_v]) {
			parents[ulp_u] = ulp_v;
		}

		// if two components has the same rank:
		else {
			parents[ulp_u] = ulp_v;
			rank[ulp_v]++;
		}
	}

	vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
		// initialize values
		for (int i = 0; i < accounts.size(); i++) {
			for (int j = 1; j < accounts[i].size(); j++) {
				// initialize parent for each email:
		        // the initial parent of each email is itself.
				parents[accounts[i][j]] = accounts[i][j];

				// the initial parent of each email is itself.
				rank [accounts[i][j]]= 0;

				// set the owner for each email:
				owners[accounts[i][j]] = accounts[i][0];
			}
		}
		
		// unionize (merge) 
		for (int i = 0; i < accounts.size(); i++) {
			// we assume that each account itself is a component with:
			// the first emails is the root and it connects to every the other emails.
			// so that we assume there is a edge between the first emails and each the other email 
			for (int j = 2; j < accounts[i].size(); j++) {
				unionByRank(accounts[i][1], accounts[i][j]);
			}
		}

		// insert each email to its union. 
		for (int i = 0; i < accounts.size(); i++) {
			for (int j = 1; j < accounts[i].size(); j++) {
				// each uPar represent a union.
				string uPar = findUPar(accounts[i][j]);
				unions[uPar].insert(accounts[i][j]);
			}
		}

		vector<vector<string>>res;
		for (auto it : unions) {
			// add the emails
			vector<string> emails(it.second.begin(), it.second.end());
			// add the owner 
			emails.insert(emails.begin(), owners[it.first]);
			// push to res.
			res.push_back(emails);
		}
		return res;
	}
};