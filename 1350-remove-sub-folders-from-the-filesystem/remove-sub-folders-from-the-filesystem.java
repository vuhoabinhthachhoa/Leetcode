class Solution {
     public List<String> removeSubfolders(String[] folder) {
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(folder));

        List<String> res = new ArrayList<>();
        for(int i = 0 ; i < folder.length ; i++) {
            boolean isSub = false;
            for(int j = 1 ; j < folder[i].length() ; j++) {
                if(folder[i].charAt(j) == '/') {
                    String sub = folder[i].substring(0, j);
                    if(set.contains(sub)) {
                        isSub = true;
                        break;
                    }
                }
            }
            if(!isSub) {
                res.add(folder[i]);
            }
        }

        return res;
    }
}