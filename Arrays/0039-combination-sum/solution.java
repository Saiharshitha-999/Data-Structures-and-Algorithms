class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        helper(0, candidates, target, new ArrayList<>(), ans);

        return ans;
    }

    public void helper(int index,
                       int[] candidates,
                       int target,
                       List<Integer> ds,
                       List<List<Integer>> ans)
    {
        if(index == candidates.length)
        {
            if(target == 0)
            {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(candidates[index] <= target)
        {
            ds.add(candidates[index]);

            helper(index,
                   candidates,
                   target - candidates[index],
                   ds,
                   ans);

            ds.remove(ds.size() - 1);
        }

        helper(index + 1,
               candidates,
               target,
               ds,
               ans);
    }
}
