class Solution {
    public int minOperations(int n) 
    {
        int ops = 0;
        for (int i = 0; i < n / 2; i++) ops += n - (2 * i + 1);
        return ops;
    }
}
