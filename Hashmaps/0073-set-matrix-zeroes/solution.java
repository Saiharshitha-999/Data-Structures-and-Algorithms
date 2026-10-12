class Solution {
    public void setZeroes(int[][] matrix) 
    {
        HashSet<Integer> zeromap = new HashSet<>();
        HashSet<Integer> onemap = new HashSet<>();
        for(int i = 0; i < matrix.length ; i++)
        {
           for(int j = 0; j < matrix[0].length; j++)
           {
               if(matrix[i][j] == 0)
               {
                  zeromap.add(i);
                  onemap.add(j);
               }
           }
        }

        for(int i = 0; i < matrix.length ; i++)
        {
           for(int j = 0; j < matrix[0].length; j++)
           {
               if(zeromap.contains(i) || onemap.contains(j))
               {
                  matrix[i][j] = 0;
               }    
           }
        }
    }
}
