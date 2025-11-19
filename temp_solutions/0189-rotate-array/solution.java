class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        reverse(0,n-k,nums);
        reverse(n-k,n,nums);
        reverse(0,n,nums);
    }
    public void reverse(int a,int b,int[] nums)
     {
        int i=a,j=b-1;
        while(i<=j)
        {
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
     }

}
