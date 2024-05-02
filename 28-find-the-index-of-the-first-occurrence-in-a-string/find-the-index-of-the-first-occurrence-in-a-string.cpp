class Solution {
public:
    vector<int> computeLPSArray(string & parrtern) {
    int n = parrtern.size();

    vector<int> lps(n, 0);
    if (n <= 1) { return lps; }
    
    // the length of  the previous longest prefix. 
    // ex: abcdabc if we are at c (array[6]) the longest previous prefix is 3: because (abc)dabc (abc)is prefix
    // and we are considering suffix abcd(abc) 
    // (length of  the previous longest prefix also means the index of last element of longest prefix)
    int len = 0; 
    int i = 1;
    while (i < n) {
        if (parrtern[i] == parrtern[len]) {
            len++;
            lps[i] = len;
            i++;
        }
        else { // parrtern[i] != parrtern[len]
            // This is tricky. Consider the example.
            // AAACAAAA and i = 7. The idea is similar
            // to search step.
            if (len != 0) {
                len = lps[len - 1];

                // Also, note that we do not increment
                // i here
            }
            else // if (len == 0)
            {
                lps[i] = 0;
                i++;
            }
        }
    }
    return lps;
}

int KMPSearch(string text, string parttern) {
    vector<int> lps = computeLPSArray(parttern);

    int i = 0; // index for txt[]
    int j = 0; // index for pattern[]
    while (i < text.size() && j < parttern.size()) {
        if (text[i] == parttern[j]) {
            i++;
            j++;
        }
        else {
            // if text[i] != parrtern[j], we go back and continue compare at the last element of longest prefix + 1
            // because according to lps array, we can know that (see example)
            // text = abcabcabd, parrtern = abcabd
            // i = 5 (c) and j = 5 (d): c != d
            // so we need to consider string starting at index 1.
            // but we do not need to go back to i = 1 (b), instead we just go back to i = 3 (a)
            // because we know that abc abc(abc)abd is in (string from i = 1 to current i : bcabc)
            if (j != 0) {
                j = lps[j - 1];

            }
            else {
                i++;
            }
        }

    }

    if (j == parttern.size()) {
        return i - parttern.size();
    }
    return -1;
}

int strStr(string haystack, string needle) {
    
    return KMPSearch(haystack, needle);
}
};