class Solution {
     public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>(dictionary);

        String[] words = sentence.split(" ");
        StringBuilder res = new StringBuilder();

        for(String word : words) {
            StringBuilder root = new StringBuilder();
            for(int i = 0; i < word.length()&&!set.contains(root.toString());i++) {
                root.append(word.charAt(i));
            }
            res.append(root);
            res.append(" ");
        }

        res.deleteCharAt(res.length()-1);
        return res.toString();
    }

}