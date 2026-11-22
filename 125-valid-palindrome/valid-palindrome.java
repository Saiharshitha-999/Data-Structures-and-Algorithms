class Solution {
    public boolean isPalindrome(String s) 
    {
        char[] ch = s.toCharArray();
        int i = 0;
        int j = ch.length - 1;
        while(i <= j)
        {
            while(i < ch.length && !Character.isLetterOrDigit(ch[i]))
            {
                i++;
            }
            while(j >= 0 && !Character.isLetterOrDigit(ch[j]))
            {
                j--;
            }
            if((i < ch.length && j >= 0) && Character.toLowerCase(ch[i]) != Character.toLowerCase(ch[j]))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}