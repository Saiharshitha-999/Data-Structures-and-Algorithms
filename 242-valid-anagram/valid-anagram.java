class Solution {
    public boolean isAnagram(String s, String t) {

        LinkedHashMap<Character, Integer> d1 = new LinkedHashMap<>();
        LinkedHashMap<Character, Integer> d2 = new LinkedHashMap<>();

        if (s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);

            if (d1.get(ch1) != null)
                d1.put(ch1, d1.get(ch1) + 1);
            else
                d1.put(ch1, 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch2 = t.charAt(i);

            if (d2.get(ch2) != null)
                d2.put(ch2, d2.get(ch2) + 1);
            else
                d2.put(ch2, 1);
        }

        return d1.equals(d2);
    }
}
