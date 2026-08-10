class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;

        for (int n = low; n <= high; n++) {
            String s = String.valueOf(n);
            int len = s.length();

            if (len % 2 != 0) {
                continue;
            }

            int mid = len / 2;
            int sum1 = 0;
            int sum2 = 0;

            for (int i = 0; i < mid; i++) {
                sum1 += s.charAt(i) - '0';
            }

            for (int i = mid; i < len; i++) {
                sum2 += s.charAt(i) - '0';
            }

            if (sum1 == sum2) {
                count++;
            }
        }

        return count;
    }
}
