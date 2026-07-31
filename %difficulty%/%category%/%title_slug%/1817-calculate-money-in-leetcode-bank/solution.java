class Solution {
    public int totalMoney(int n) {
        
        int total = 0;
        int Monday = 1;
        while(n > 0)
        {
            for(int i = 0 ; i < 7 && n > 0 ; i++)
            {
               total += Monday + i;
               n--;
            }
            Monday++;
        }
        return total;
    }
}
