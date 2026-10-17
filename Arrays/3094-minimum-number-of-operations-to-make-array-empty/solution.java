class Solution {
    public int minOperations(int[] nums) {

        Arrays.sort(nums);

        int count = 0;
        int freq = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                freq++;
            } else {

                if (freq == 1)
                    return -1;

                count += (freq + 2) / 3;

                freq = 1;
            }
        }
        if (freq == 1)
            return -1;

        count += (freq + 2) / 3;

        return count;
    }
}
