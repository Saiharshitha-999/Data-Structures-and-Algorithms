class Solution {
    public int[] findColumnWidth(int[][] grid) 
    {
        int row = grid.length;
        int col = grid[0].length;
        int[] arr = new int[col];
        int k = 0;
        for(int i = 0; i < col ; i++)
        {
            int maxi = Integer.MIN_VALUE;
            for(int j = 0; j < row; j++)
            {
                int count = 0;
                int n = grid[j][i];
                if(n <= 0)
                {
                    count = 1;
                }
                while(n != 0)
                {
                    n = n/10;
                    count++;
                }
                maxi = Math.max(maxi,count);
            }
            if(k < col)
            {
            arr[k++] = maxi;
            }
        }
        return arr;
    }
}
