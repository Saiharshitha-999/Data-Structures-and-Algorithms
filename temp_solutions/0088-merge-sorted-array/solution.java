class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) 
    {
        //It is Three pointer technique
        int j,k,i;

        j=m-1;      //other is at the number of valid merge values in nums1     
        k=n-1;     //one is at the end of nums1
        i=m+n-1;   //This problem basically uses three pointer technique one is at the end of nums1
        while(k>=0)    //we will run a while loop until the elements in the nums2 becomes zero because after they become zero nums1 elements will be automatically sorted no need to check nums1 elements
        {
            if(j>=0 && nums1[j]>nums2[k])
            {
                 nums1[i]=nums1[j];         //In this while loop we have to check the j>=0 because if j becomes zero there are no elements to compare with the nums2 so we will directly add it to nums1 end in else block 
                 j--;
            }
            else
            {
               nums1[i]=nums2[k];
               k--;
            }
            i--;
        }
        
    }
}
