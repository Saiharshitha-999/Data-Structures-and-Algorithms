class Solution {
    public int[] intersection(int[] nums1, int[] nums2) 
    {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1=nums1.length;
        int n2=nums2.length;
        int i=0,j=0;
        ArrayList<Integer> nums3=new ArrayList<>();
        while(i<n1 && j<n2)
        {
            if(nums1[i]>nums2[j])
            {
                j++;
            }
            else if(nums1[i]<nums2[j])
            {
                i++;
            }
            else
            {
                if(nums3.size()==0 || nums1[i]!=nums3.get(nums3.size()-1))
                {
                    nums3.add(nums1[i]);
                    
                }
                j++;
                i++;
            }
        }
        int[] nums4 = new int[nums3.size()];
        for(int k=0;k<nums4.length;k++)
        {
            nums4[k]=nums3.get(k);
        }
        return nums4;
    }
}
