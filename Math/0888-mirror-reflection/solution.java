class Solution {
    public int mirrorReflection(int p, int q) {
        int m = p;
        int n = q;

        while (m % 2 == 0 && n % 2 == 0) {
            m /= 2;
            n /= 2;
        }

        if (m % 2 == 0 && n % 2 == 1) {
            return 2;
        }

        if (m % 2 == 1 && n % 2 == 1) {
            return 1;
        }

        return 0;
    }
}
