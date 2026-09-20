class Solution {
    public int orangesRotting(int[][] grid) 
    {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 2)
                {
                   queue.add(new int[]{i,j});
                }
                if(grid[i][j] == 1)
                {
                   fresh++;
                }
            }
        }
        int[][] directions = {{-1, 0},{1, 0},{0, -1},{0, 1}};
        int count = 0;
        while(!queue.isEmpty() && fresh > 0)
        {
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                int[] num = queue.poll();
                for(int[] direction : directions)
                {
                    int r = num[0];
                    int c = num[1];
                    r = r + direction[0];
                    c = c + direction[1];
                    if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1)
                    {
                        grid[r][c] = 2;
                        fresh--;
                        queue.add(new int[]{r,c});
                    }
                }
                
            }
            count++;
        }
        if(fresh > 0)
        {
            return -1;
        }
        return count;
    }
}
