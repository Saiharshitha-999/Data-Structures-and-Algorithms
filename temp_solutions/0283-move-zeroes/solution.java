class Solution {
    public void moveZeroes(int[] nums) {
        int p = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[p++] = nums[i];
            }
        }
        for(; p < nums.length; p++) nums[p] = 0;
    }
        
    

}
