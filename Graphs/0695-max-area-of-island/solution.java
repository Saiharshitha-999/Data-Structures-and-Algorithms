class Solution {
    int count;
    int maxcount;
    public int maxAreaOfIsland(int[][] grid) 
    {
        int[][] pos = {{-1,0},{1,0},{0,-1},{0,1}};
        maxcount = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                count = 0;
                if(grid[i][j] == 1)
                {
                    count++;
                    dfs(grid,i,j,pos);
                }
                maxcount = Math.max(maxcount,count);
            }
        }
        return maxcount;
    }
    private void dfs(int[][] grid, int r, int c, int[][] pos)
    {
        grid[r][c] = 0;
        for(int[] p : pos)
        {
           int newrow = r + p[0];
           int newcol = c + p[1];
           if((newrow >= 0 && newrow < grid.length) && (newcol >= 0 && newcol < grid[0].length) && grid[newrow][newcol] == 1)
           {
               count++;
               dfs(grid,newrow,newcol,pos);
           }
            
        }
        return;
    }
}
