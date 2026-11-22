class Solution {
    public int romanToInt(String s) 
    {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        int sum = 0;
        int flag = 0;
        int i = 0;
        while(i < s.length() - 1)
        {
            int a = map.get(s.charAt(i));
            int b = map.get(s.charAt(i + 1));
            if(a < b)
            {
                if(i == s.length() - 2)
                {
                    flag = 1;
                }
                sum += (b - a);
                i += 2;
            }
            else
            {
                sum += a;
                i++;
            }
            
        }
        if(flag == 0)
        {
            sum += map.get(s.charAt(s.length() - 1));
        }
        return sum;
    }
}