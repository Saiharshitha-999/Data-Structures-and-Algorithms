class Solution {
    public int numberOfMatches(int n) {
        
        int Matches = 0;
        int sum = 0;
        while(n > 1)
        {
            if(n%2 == 0)
            {
                Matches = (n/2);
                n = Matches;
            }
            else
            {
                Matches = (n-1)/2;
                n = Matches + 1;
            }
            sum += Matches;
        }
        return sum;
    }
}
