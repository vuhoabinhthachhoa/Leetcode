class Solution {
   public boolean halvesAreAlike(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'u'));
        
        int firstPart = 0;
        for(int i = 0 ; i < s.length()  / 2; i++) {
            if(vowels.contains(Character.toLowerCase(s.charAt(i)))) {
                firstPart++;
            }
        }
        int secondPart = 0;
        for(int i = s.length() / 2; i < s.length(); i++) {
            if(vowels.contains(Character.toLowerCase(s.charAt(i)))) {
                secondPart++;
            }
        }
        return firstPart == secondPart;
    }
}