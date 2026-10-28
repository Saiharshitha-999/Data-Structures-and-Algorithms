class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxSoFar = 0;
        int chunks = 0;
        
        for (int i = 0; i < arr.length; i++) {
            // Track the highest value seen in this prefix
            maxSoFar = Math.max(maxSoFar, arr[i]);
            
            // If the max value matches the current index, we can safely slice a chunk
            if (maxSoFar == i) {
                chunks++;
            }
        }
        
        return chunks;
    }
}
