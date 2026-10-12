class Solution {
    public int largestRectangleArea(int[] heights){
        if (heights == null || heights.length == 0) return 0;

        int[] nsei = new int[heights.length];
        int[] psei = new int[heights.length];

        for(int i=0; i<heights.length; i++){
            nsei[i] = heights.length;
            psei[i] = 0;
        }

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<heights.length; i++){
            while(true){
                if(stack.isEmpty()){
                    stack.push(i);
                    break;
                }

                int idx = stack.peek();

                if(heights[i] < heights[idx]){
                    nsei[idx] = i;
                    stack.pop();
                } else {
                    stack.push(i);
                    break;
                }
            }
        }
        while(!stack.isEmpty()){
            int idx = stack.pop();
            nsei[idx] = heights.length;
        }

        stack.clear();

        for(int i=heights.length-1; i>=0; i--){
            while(true){
                if(stack.isEmpty()){
                    stack.push(i);
                    break;
                }

                int idx = stack.peek();

                if(heights[i] <= heights[idx]){
                psei[idx] = i;
                    stack.pop();
                } else {
                    stack.push(i);
                    break;
                }
            }
        }
        while(!stack.isEmpty()){
            int idx = stack.pop();
            psei[idx] = -1;
        }

        int max = 0;

        for(int i=0; i<heights.length; i++){
            max = Math.max(max, heights[i] * (nsei[i] - psei[i] - 1));
        }
        return max;

    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[][] mat = new int[matrix.length][matrix[0].length];

        for(int col=0; col<matrix[0].length; col++){
            mat[0][col] = matrix[0][col] == '1' ? 1 : 0;
        }

        int max  = 0;

        max = Math.max(max, largestRectangleArea(mat[0]));

        for(int row=1; row<matrix.length; row++){
            for(int col=0; col<matrix[0].length; col++){
                mat[row][col] = matrix[row][col] == '1' ? mat[row-1][col] + 1 : 0;
            }
            max = Math.max(max, largestRectangleArea(mat[row]));
        }
        return max;
    }
}
