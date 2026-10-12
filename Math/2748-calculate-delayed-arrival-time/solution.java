class Solution {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) 
    {
        if(arrivalTime == 24)
        {
            arrivalTime = 0;
        }
        if(delayedTime == 24)
        {
            delayedTime = 0;
        }

        int time = arrivalTime + delayedTime;

        if(time >= 24)
        {
            return time - 24;
        }
        return time;

    }
}
