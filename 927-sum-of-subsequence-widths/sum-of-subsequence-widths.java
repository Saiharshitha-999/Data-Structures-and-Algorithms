class Solution {
    public int sumSubseqWidths(int[] nums) {
       long twoPower [] =new long[nums.length];
       long mod = 1000000007L;
       twoPower[0] =1;
	   // generating 2 power array
       for (int i = 1; i< nums.length; i++){
           twoPower[i] = (twoPower[i-1]*2)%mod;
       }
       long effective[] = new long[nums.length];
	   // generating effective frequency array  by subtracting the 2 power array's elements from its reverse view
       for (int i = 0; i< nums.length; i++) {
    	   effective[i] = (twoPower[i]- twoPower[nums.length- i-1]);
       }
       Arrays.sort(nums); // sorting the array
       long ans = 0;
	   // now, to get the answer we multiply the elements of the sorted array with the effective frequency array elements
       for (int i = 0; i< nums.length; i++) {
    	   ans = (ans+ effective[i]*nums[i])%mod;
       }
       return (int) ans;
   }
}