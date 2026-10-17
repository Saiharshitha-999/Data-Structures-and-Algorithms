class Solution {
    public int eraseOverlapIntervals(int[][] intervals) 
    {
        Arrays.sort(intervals,(a,b) -> a[1] - b[1]);
        int count = 0;
        int[] current = intervals[0];

        for(int i = 1 ; i < intervals.length ; i++)
        {
           if(current[1] > intervals[i][0])
           {
              count++;
           }
           else
           {
            current = intervals[i];
           }

        }
        return count;
        
    }
}
