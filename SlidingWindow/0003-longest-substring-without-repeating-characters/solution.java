class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        /* take the help of Hashmap and sliding window right - left +1 
        if duplicate detected then shift left to max of (left,duplicateindex + 1)->
        it preveents the left from accidently shift backward than its' position 
        */
         int maxLength = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            if (map.containsKey(currentChar)) {
                left = Math.max(left, map.get(currentChar) + 1);
            }
            
            map.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
