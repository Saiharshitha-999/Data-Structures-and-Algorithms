class Solution {
    public boolean checkXMatrix(int[][] grid) 
    {
        int n = grid.length - 1;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(i == j || j == n - i)
                {
                    if(grid[i][j] == 0)
                    {
                        return false;
                    }
                }
                else
                {
                    if(grid[i][j] != 0)
                    {
                        return false;
                    }
                }

            }
        }
        return true;
    }
}
