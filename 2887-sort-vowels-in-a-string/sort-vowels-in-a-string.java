class Solution {
    public String sortVowels(String s) 
    {
         ArrayList<Character> arr = new ArrayList<>();
         String v = "aeiouAEIOU";

         for(int i = 0; i < s.length(); i++)
         {
            char ch = s.charAt(i);
            if(v.indexOf(ch) != -1)
            {
                arr.add(ch);
            }
         }
         Collections.sort(arr);
         StringBuilder st = new StringBuilder();
         int p = 0;
         for(int i = 0; i < s.length(); i++)
         {
            char ch = s.charAt(i);
            if(v.indexOf(ch) != -1)
            {
                st.append(arr.get(p++));
            }
            else
            {
                st.append(ch);
            }
         }
         return st.toString();
    }
}