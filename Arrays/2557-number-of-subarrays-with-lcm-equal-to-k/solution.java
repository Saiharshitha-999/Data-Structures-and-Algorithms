class Solution {
    public int subarrayLCM(int[] nums, int k) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            int runningLCM = nums[i];

            for (int j = i; j < nums.length; j++) {

                runningLCM = LCM(runningLCM, nums[j]);

                if (runningLCM > k) {
                    break;
                }

                if (runningLCM == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public int gcd(int a, int b) {

        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public int LCM(int a, int b) {
        return a * (b / gcd(a, b));
    }
}
