class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int i=0;
        int n=nums.length;
        int Majority_element=0;
        while(i<n)
        {
            if(count==0)
            {
                Majority_element=nums[i];
                count++;
            }
            else if(Majority_element==nums[i])
            {
                count++;
            }
            else
            {
                count--;
            }
             i++;
        }
        return Majority_element;
       

}
}
