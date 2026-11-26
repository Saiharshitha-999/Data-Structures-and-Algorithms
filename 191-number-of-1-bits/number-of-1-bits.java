class Solution {
    public int hammingWeight(int n) {
        int c = 1;
        int count = 0;
        while(n != 1)
        {
            if(n % 2 == 1)
            {
                count++;
            }
            n = n/2;
        }
        return count + 1;
    }
}