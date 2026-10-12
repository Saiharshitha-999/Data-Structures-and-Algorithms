class Solution {
    public int numIslands(char[][] grid) 
    {
       int count = 0;
       int[][] pos = {{-1,0},{1,0},{0,1},{0,-1}};
       for(int i = 0; i < grid.length; i++)
       {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == '1')
                {
                    count++;
                    dfs(grid,pos,i,j);
                }
            }
       }
       return count;
    }
    private void dfs(char[][] grid,int[][] pos,int i,int j)
    {
        grid[i][j] = '0';
       for(int[] list : pos)
       {
          int r = list[0] + i;
          int c = list[1] + j;
          if((r >= 0 && r < grid.length) && (c >= 0 && c < grid[0].length) && grid[r][c] == '1')
          {
            dfs(grid,pos,r,c);
          }
       }
    }
}


