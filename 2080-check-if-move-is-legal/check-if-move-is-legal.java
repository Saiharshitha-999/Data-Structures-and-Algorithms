class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        // Define all 8 possible directions: (rowChange, colChange)
        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},   // Vertical and Horizontal
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}  // Diagonals
        };
        
        char oppositeColor = (color == 'W') ? 'B' : 'W';
        
        // Check if any of the 8 directions form a good line
        for (int[] dir : directions) {
            int dr = dir[0];
            int dc = dir[1];
            
            int r = rMove + dr;
            int c = cMove + dc;
            int length = 1; // Includes the starting cell
            
            // Move in the current direction as long as we see the opposite color
            while (r >= 0 && r < 8 && c >= 0 && c < 8 && board[r][c] == oppositeColor) {
                r += dr;
                c += dc;
                length++;
            }
            
            // To be a good line, we must stop on our own color,
            // and the total length of the line must be at least 3 cells.
            if (r >= 0 && r < 8 && c >= 0 && c < 8 && board[r][c] == color && length >= 2) {
                return true;
            }
        }
        
        return false;
    }
}
