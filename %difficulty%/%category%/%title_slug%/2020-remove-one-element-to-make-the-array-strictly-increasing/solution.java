class Solution {
    public boolean canBeIncreasing(int[] nums) {

        int len = nums.length;
        int count = 0;

        for (int i = 1; i < len; i++) {

            if (nums[i] <= nums[i - 1]) {

                if (++count > 1) {
                    return false;
                }

                if ((i > 1 && nums[i] <= nums[i - 2]) && (i + 1 < len && nums[i + 1] <= nums[i - 1])) {
                    return false;
                }
            }
        }

        return true;
    }
}
