class Solution {
    public int[] findBall(int[][] grid) 
    {
        int n = grid[0].length;
        int arr[] = new int[n];

        for(int i = 0; i < grid[0].length; i++)
        {
            arr[i] = dfs(grid,0,i);
             
        }
        return arr;
    }
    public int dfs(int[][] grid,int r, int c)
    {
        if(grid.length  == r)
        {
            return c;
        }

        int c_next = c + grid[r][c];
        if(c_next < 0 || c_next >= grid[0].length || (grid[r][c_next] != grid[r][c]))
        {
            return -1;
        }

        return dfs(grid,r + 1,c_next);
        
    }
}