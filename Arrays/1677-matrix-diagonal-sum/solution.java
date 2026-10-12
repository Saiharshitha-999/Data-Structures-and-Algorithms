class Solution {
    public int diagonalSum(int[][] mat)
    {
        int sum = 0;
        for(int i = 0 ;i < mat.length; i++)
        {
            for(int j = 0 ; j < mat[0].length; j++)
            {
                if(i == j)
                {
                sum += mat[i][j];
                }
            }
        }
        int left = 0;
        int right = mat[0].length - 1;
        while(left < mat[0].length && right >= 0)
        {
            if(left != right)
            {
            sum += mat[left][right];
            }
            left++;
            right--;
            
        }
        return sum;
    }
}
