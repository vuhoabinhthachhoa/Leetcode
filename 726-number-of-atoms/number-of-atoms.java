class Pair {
    private String key;
    private int value;
    public Pair(String key, int value) {
        this.key = key;
        this.value = value;
    }
    public String getKey() {
        return key;
    }
    public int getValue() {
        return value;
    }
}

class Solution {
    public String countOfAtoms(String formula) {
        Stack<Pair> atoms = new Stack<>();
        int i = 0;
        StringBuilder name = new StringBuilder();
        int count = 0;
        while(i < formula.length()) {
            if(formula.charAt(i) == ')') {
                if(!name.isEmpty()) {
                    if(count == 0) {
                        count = 1;
                    }
                    atoms.push(new Pair(name.toString(), count));
                    name = new StringBuilder();
                    count = 0;
                }
                int count2 = 0;
                i++;
                while(i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    count2 = count2 * 10 + formula.charAt(i) - '0';
                    i++;
                }
                if(count2 == 0) {
                    count2 = 1;
                }
                Stack<Pair> util = new Stack<>();
                while(true) {
                    Pair atom = atoms.pop();
                    if(atom.getKey().equals("(")) {
                        break;
                    }
                    util.push(new Pair(atom.getKey(), atom.getValue() * count2));
                }
                while(!util.empty()) {
                    atoms.push(util.pop());
                }
                continue;
            }
            else if (formula.charAt(i) == '(') {
                if(!name.isEmpty()) {
                    if(count == 0) {
                        count = 1;
                    }
                    atoms.push(new Pair(name.toString(), count));
                    name = new StringBuilder();
                    count = 0;
                }
                atoms.push(new Pair("(", 0));
            }
            else if (Character.isUpperCase(formula.charAt(i))) {
                if(!name.isEmpty()) {
                    if(count == 0) {
                        count = 1;
                    }
                    atoms.push(new Pair(name.toString(), count));
                    name = new StringBuilder();
                    count = 0;
                }
                name.append(formula.charAt(i));
            }
            else if (Character.isLowerCase(formula.charAt(i))) {
                name.append(formula.charAt(i));
            }
            else if (Character.isDigit(formula.charAt(i))) {
                count = count* 10 + formula.charAt(i) - '0';
            }
            i++;
        }
        if(!name.isEmpty()) {
            atoms.push(new Pair(name.toString(), count));
        }
        Map<String, Integer> mp = new TreeMap<>();
        while(!atoms.empty()) {
            Pair atom = atoms.pop();
            mp.put(atom.getKey(), mp.getOrDefault(atom.getKey(), 0) + atom.getValue());
        }
        StringBuilder res = new StringBuilder();
        for(Map.Entry<String, Integer> entry : mp.entrySet()) {
            res.append(entry.getKey());
            if(entry.getValue() > 1) {
                res.append(entry.getValue());
            }
        }
        return res.toString();
    }
}