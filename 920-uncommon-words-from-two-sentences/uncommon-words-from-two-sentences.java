class Solution {
       public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> mp = new HashMap<>();

        StringBuilder currWord = new StringBuilder();
        for(int i = 0; i < s1.length() ; i++) {
            if(s1.charAt(i) == ' ') {
                if(!currWord.isEmpty()) {
                    int freq = mp.getOrDefault(currWord.toString(), 0);
                    mp.put(currWord.toString(), freq + 1);
                    currWord.setLength(0);
                }
            }
            else {
                currWord.append(s1.charAt(i));
            }
         }
        mp.put(currWord.toString(), mp.getOrDefault(currWord.toString(), 0) + 1);
        currWord.setLength(0);

        for(int i = 0; i < s2.length() ; i++) {
            if(s2.charAt(i) == ' ') {
                if(!currWord.isEmpty()) {
                    int freq = mp.getOrDefault(currWord.toString(), 0);
                    mp.put(currWord.toString(), freq + 1);
                    currWord.setLength(0);
                }
            }
            else {
                currWord.append(s2.charAt(i));
            }
        }
        mp.put(currWord.toString(), mp.getOrDefault(currWord.toString(), 0) + 1);
        currWord.setLength(0);

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