class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int maxOnes = 0;
        int maxRow = 0;

        for (int i = 0; i < rows; i++) {
            int ones = 0;

            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1)
                    ones++;
            }

            if (ones > maxOnes) {
                maxOnes = ones;
                maxRow = i;
            }
        }

        return new int[]{maxRow, maxOnes};
    }
}
