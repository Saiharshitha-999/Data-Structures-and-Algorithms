class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {

        int i = 0;
        int count = 0;
        while(i < startTime.length)
        {
            if(startTime[i] <= queryTime && queryTime <= endTime[i])
            {
                count++;
            }
            i++;
        }
        return count;

    }
}
