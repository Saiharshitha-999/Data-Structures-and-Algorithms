class Solution {
    public int[] findBall(int[][] grid) 
    {
        int n = grid[0].length;
        int arr[] = new int[n];
        for(int i = 0; i < grid[0].length; i++)
        {
            int c = i;
            for(int j = 0; j < grid.length; j++)
            {
                int c_next = c + grid[j][c];
                if(c_next < 0 || c_next >= n || (grid[j][c_next] != grid[j][c]))
                {
                    c = -1;
                    break;
                }
                c = c_next;
            }  
            arr[i] = c; 
        }
        return arr;
    }
}