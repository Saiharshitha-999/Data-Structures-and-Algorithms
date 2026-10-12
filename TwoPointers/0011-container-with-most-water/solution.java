class Solution {
    public int maxArea(int[] height) 
    {
        int start = 0;
        int end = height.length - 1;
        int area = -1;
        int maxarea = -1;
        while(start < end)
        {
            area = (Math.min(height[start],height[end])) * (end - start);
            if(area > maxarea)
            {
                maxarea = area;
            }
            if(height[start] < height[end])
            {
                start++;
            } 
            else
            {
                end--;
            }

        }
        return maxarea;
    }
}
