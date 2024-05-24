class Solution {
      public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[score.length];
        for (char c : letters) {
            freq[c - 'a']++;
        }
        return backtrack(words, letters, score, freq, 0);
    }

    int backtrack(String[] words, char[] letters, int[] score, int[] freq, int index) {
        if(index == words.length) {
            return 0;
        }
        int currScore = 0;
        boolean isValid = true;
        for(char c : words[index].toCharArray()) {
            currScore += score[c - 'a'];
            freq[c - 'a']--;

            if(freq[c - 'a'] < 0) {
                isValid = false;
            }
        }
        int pick = 0;
        if(isValid) {
            pick = currScore + backtrack(words, letters, score, Arrays.copyOf(freq, freq.length) , index + 1);
        }
        for(char c : words[index].toCharArray()) {
            freq[c - 'a']++;
        }
        int notPick = backtrack(words, letters, score, Arrays.copyOf(freq, freq.length), index + 1);
        return Math.max(pick, notPick);
    }
}