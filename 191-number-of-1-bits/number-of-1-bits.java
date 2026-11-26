class Solution {
    public int hammingWeight(int n) {
        int c = 1;
        int count = 0;
        while(n >= c && c > 0){
            if((c & n) > 0) count++;
            c = c << 1;
        }
        return count;
    }
}