class Solution {
    public int oddCells(int m, int n, int[][] indices) 
    {
        int[][] matrix = new int[m][n];
        int count = 0;
        for(int[] i : indices)
        {
            int left = i[0];
            int right = i[1];

            matrix[left][right]++;

            for(int j = 0; j < n; j++)
            {
                matrix[left][j]++;
            }
            for(int j = 0; j < m; j++)
            {
                matrix[j][right]++;
            }
            matrix[left][right]++;
        }
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(matrix[i][j] % 2 != 0)
                {
                   count++;
                }
            }
        }
        return count;
        
    }
}