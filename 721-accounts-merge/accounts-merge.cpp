class Solution {
private:
	// store the owner of each email
	unordered_map<string, string> owners;
	// store the parent of each email
	unordered_map<string, string> parents;
	// store the union to which each email belongs.
	unordered_map<string, set<string>> unions;
public:
	// function to find the ultimate parent
	string findUPar(string email) {
		if (email == parents[email]) return email;
		return parents[email] = findUPar(parents[email]);
	}

	vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
		for (int i = 0; i < accounts.size(); i++) {
			for (int j = 1; j < accounts[i].size(); j++) {
				// initialize parent for each email:
		        // the initial parent of each email is itself.
				parents[accounts[i][j]] = accounts[i][j];

				// set the owner for each email:
				owners[accounts[i][j]] = accounts[i][0];
			}
		}
		
		// unionize (merge) 
		for (int i = 0; i < accounts.size(); i++) {
			// find the root of the union to which the first email belongs
			string uPar = findUPar(accounts[i][1]);

			for (int j = 2; j < accounts[i].size(); j++) {
			    // connect the first email's union to the other emails's union by
				// connecting them root. 
				parents[findUPar(accounts[i][j])] = uPar;
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