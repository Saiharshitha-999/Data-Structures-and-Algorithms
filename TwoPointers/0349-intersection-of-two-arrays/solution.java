class Solution {
    public int[] intersection(int[] nums1, int[] nums2) 
    {
        int i=0;
        int j=0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(i < n1 && j < n2)
        {
            if(nums1[i]==nums2[j] )
            {
                if(list.size()==0 || list.get(list.size()-1)!=nums1[i])
                {
                list.add(nums1[i]);
                }
                i++;
                j++;
            }
            else if(nums1[i]>nums2[j])
            {
                j++;
            }
            else if(nums2[j]>nums1[i]){
                i++;
            }
        }
        
        int[] arr = new int[list.size()];
        for(int k=0;k<list.size();k++)
        {
            arr[k]=list.get(k);
        }
        return arr;
    }
}
