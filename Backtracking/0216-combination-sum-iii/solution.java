class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) 
    {
        List<List<Integer>> arr = new ArrayList<>();
        helper(1,k,n,arr,0,new ArrayList<>(),0);
        return arr;
    }

    public void helper(int index,int k ,int n,List<List<Integer>> arr,int sum, List<Integer> bt,int count)
    {
        if( sum > n)
        {
            return;
        }
        if(count == k)
        {
            if(sum == n)
            {
                arr.add(new ArrayList<>(bt));
            }
            return;
        }
        for(int i = index ; i <= 9; i++)
        {
            bt.add(i);
            helper(i+1,k,n,arr,sum+i,bt,count+1);
            bt.remove(bt.size()-1);
        }
    
    }
}
