class Solution {
    public String frequencySort(String s) 
    {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        StringBuilder str = new StringBuilder();
        while(map.size()!=0)
        {
            int max = Integer.MIN_VALUE;
            char maxChar = ' ';
            for(char ch : map.keySet())
            {
                if(map.get(ch) > max)
                {
                    max = map.get(ch);
                    maxChar = ch;
                }
            }
            for(int i = 0;i<max;i++)
            {
                str.append(maxChar);   
            }
            map.remove(maxChar);
        }
        return str.toString();
    }
}
