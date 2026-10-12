class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            int min = Integer.MAX_VALUE;
            int minCol = -1;

            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minCol = j;
                }
            }

            boolean isLucky = true;

            for (int k = 0; k < rows; k++) {
                if (matrix[k][minCol] > min) {
                    isLucky = false;
                    break;
                }
            }

            if (isLucky) {
                result.add(min);
            }
        }

        return result;
    }
}
