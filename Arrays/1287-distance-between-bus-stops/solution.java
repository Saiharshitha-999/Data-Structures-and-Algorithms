class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) 
    {
        int totalSum = 0;
        int n = distance.length;
        for(int i = 0 ; i < n ; i++)
        {
            totalSum+= distance[i];
        }
        int clocksum = 0;
        for(int i = start ;i < n ;i++)
        {
            if(i == destination)
            {
                break;
            }
            clocksum += distance[i];
             if(i == n-1)
             {
                i = -1;
             }
        }
        int min = Math.min(totalSum - clocksum,clocksum);
        return min;

    }
}
