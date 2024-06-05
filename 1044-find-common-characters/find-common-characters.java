class Solution {
     public List<String> commonChars(String[] words) {
        int n = words.length;

        int[] prev = new int[26];
        int[] curr = new int[26];
        // intitialize value
        for (int i = 0; i < 26; i++) {
            prev[i] = 0;
        }
        for (int i = 0; i < 26; i++) {
            curr[i] = 0;
        }

        for(int i = 0; i < words[0].length(); i++) {
            prev[words[0].charAt(i) - 'a']++;
        }

        for (int i = 1 ; i < n; i++) {
            for(int j = 0 ;j < words[i].length(); j++) {
                curr[words[i].charAt(j) - 'a']++;
            }
            for(int j = 0; j < 26; j++) {
                prev[j] = Math.min(prev[j], curr[j]);
                curr[j] = 0;
            }
        }

        List<String> result = new ArrayList<>();
        for(int i = 0 ; i < 26; i++) {
            for(int j = 0; j < prev[i]; j++) {
                result.add(Character.toString((char)('a' + i)));
            }
        }

        return result;
    }
}