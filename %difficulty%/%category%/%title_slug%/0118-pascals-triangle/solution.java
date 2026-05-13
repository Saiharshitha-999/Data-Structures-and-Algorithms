class Solution {
    public List<List<Integer>> generate(int rowIndex)
    {
        List<List<Integer>> nums1 = new ArrayList<>();
        for(int i = 0;i < rowIndex;i++)
        {
            nums1.add(singlerow(i));
        }
        return nums1;
    }
    public List<Integer> singlerow(int rowIndex)
    {
        List<Integer> arr = new ArrayList<>();
        long ans = 1;
        for(int i = 0;i <= rowIndex;i++)
        {
             arr.add((int)ans);
             ans = ans * (rowIndex - i);
             ans = ans/(i+1);
        }
        return arr;
    }
}
