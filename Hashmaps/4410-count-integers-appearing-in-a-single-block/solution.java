class Solution {
    public int countSpecialIntegers(int[] nums) 
    {
        HashMap<Integer, Integer> hash = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
        {
            if(i == 0 || nums[i] != nums[i - 1])
            {
                hash.put(nums[i], hash.getOrDefault(nums[i], 0) + 1);
            }
        }

        int count = 0;

        for(Integer value : hash.values())
        {
            if(value == 1)
            {
                count++;
            }
        }

        return count;
    }
}
