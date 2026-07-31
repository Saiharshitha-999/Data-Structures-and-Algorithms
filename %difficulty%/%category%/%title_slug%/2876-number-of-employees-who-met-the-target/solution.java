class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int sum = 0;
        for(int i = 0; i< hours.length ; i++)
        {
            if(hours[i] >= target)
            {
                sum+=1;
            }
        }
        return sum;
    }
}
