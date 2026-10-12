class Solution {
    public int deleteGreatestValue(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            Arrays.sort(grid[i]);
        }

        int answer = 0;

        for (int j = cols - 1; j >= 0; j--) {

            int max = 0;

            for (int i = 0; i < rows; i++) {
                max = Math.max(max, grid[i][j]);
            }

            answer += max;
        }

        return answer;
    }
}
