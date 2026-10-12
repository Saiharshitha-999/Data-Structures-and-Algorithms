class Solution {
    public List<Integer> getRow(int rowIndex)
    {
        List<Integer> arr = new ArrayList<>();
        long ans = 1;
        for(int i=0;i<=rowIndex;i++)
        {
             arr.add((int)ans);
             ans = ans * (rowIndex - i);
             ans = ans/(i+1);
        }
        return arr;
    }
}
