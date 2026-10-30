class Solution {
    public int superpalindromesInRange(String left, String right) 
    {
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        int ans = 0;

        // Count odd-length palindromes (e.g., 121 from half 12)
        // Root upper bound is 10^9, so the first half goes up to 10^5
        for (long i = 1; i < 100000; i++) {
            StringBuilder sb = new StringBuilder(String.valueOf(i));
            for (int j = sb.length() - 2; j >= 0; j--) {
                sb.append(sb.charAt(j));
            }
            long p = Long.parseLong(sb.toString());
            long square = p * p;
            if (square > r) break;
            if (square >= l && isPalindrome(square)) {
                ans++;
            }
        }

        // Count even-length palindromes (e.g., 1221 from half 12)
        for (long i = 1; i < 100000; i++) {
            StringBuilder sb = new StringBuilder(String.valueOf(i));
            for (int j = sb.length() - 1; j >= 0; j--) {
                sb.append(sb.charAt(j));
            }
            long p = Long.parseLong(sb.toString());
            long square = p * p;
            if (square > r) break;
            if (square >= l && isPalindrome(square)) {
                ans++;
            }
        }

        return ans;
    }

    private boolean isPalindrome(long x) {
        long reversed = 0;
        long temp = x;
        while (temp > 0) {
            reversed = reversed * 10 + temp % 10;
            temp /= 10;
        }
        return x == reversed;
    }
}