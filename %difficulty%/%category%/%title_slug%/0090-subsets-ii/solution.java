class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        Arrays.sort(nums);
        List<List<Integer>> arr = new ArrayList<>();
        helper(0,nums,new ArrayList<>(),arr);
       
        return arr;
    }
    public void helper(int index,int[] candidates,List<Integer> bt,List<List<Integer>> arr)
    {
        arr.add(new ArrayList<>(bt));
            
        for(int i = index; i < candidates.length; i++)
        {
            if(i > index && candidates[i] == candidates[i-1])
            {
                continue;
            }
            bt.add(candidates[i]);
            helper(i+1,candidates,bt,arr);
            bt.remove(bt.size()-1);
        
         }

    }
}
