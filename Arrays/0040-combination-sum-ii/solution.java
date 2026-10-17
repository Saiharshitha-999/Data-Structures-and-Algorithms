class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        Arrays.sort(candidates);
        List<List<Integer>> arr = new ArrayList<>();
        helper(0,candidates,target,new ArrayList<>(),arr);
        return arr;
    }

    public void helper(int index,int[] candidates,int target,List<Integer> bt,List<List<Integer>> arr)
    {
        if(target == 0)
        {
                arr.add(new ArrayList<>(bt));
                return;
        }
        for(int i = index; i<candidates.length;i++)
        {
            if(i > index && candidates[i] == candidates[i-1])
            {
                continue;
            }
            if(candidates[i] > target)
            {
                return;
            }
            bt.add(candidates[i]);
            helper(i+1,candidates,target - candidates[i],bt,arr);
            bt.remove(bt.size()-1);
        
         }
    }
}

