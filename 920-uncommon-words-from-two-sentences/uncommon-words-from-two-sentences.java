class Solution {
      public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> mp = new HashMap<>();
        String s = s1 + " " + s2;
        StringBuilder currWord = new StringBuilder();

        String[] words = s.split(" ");
        for(String word : words) {
            int freq = mp.getOrDefault(word.toString(), 0);
            mp.put(word.toString(), freq + 1);
        }

        List<String> commons = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : mp.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if(value == 1) {
                commons.add(key);
            }
        }

        String[] res = new String[commons.size()];
        commons.toArray(res);

        return res;
    }

}