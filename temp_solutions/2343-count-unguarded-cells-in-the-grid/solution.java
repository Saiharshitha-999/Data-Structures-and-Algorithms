class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

        int[][] grid = new int[m][n];

        // 1 = guard, 2 = wall, 3 = guarded
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }

        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 2;
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int[] guard : guards) {

            int r = guard[0];
            int c = guard[1];

            for (int d = 0; d < 4; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];

                while (nr >= 0 && nr < m && nc >= 0 && nc < n) {

                    if (grid[nr][nc] == 1 || grid[nr][nc] == 2) {
                        break;
                    }

                    grid[nr][nc] = 3;

                    nr += dr[d];
                    nc += dc[d];
                }
            }
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
