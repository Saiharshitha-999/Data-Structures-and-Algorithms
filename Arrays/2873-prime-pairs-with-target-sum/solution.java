class Solution {
    public List<List<Integer>> findPrimePairs(int n) {

        List<List<Integer>> result = new ArrayList<>();

        boolean[] isPrime = new boolean[n + 1];

        // Assume all numbers are prime
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        // Sieve of Eratosthenes
        for(int i = 2; i * i <= n; i++) {

            if(isPrime[i]) {

                for(int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Find prime pairs
        for(int i = 2; i <= n / 2; i++) {

            int x = n - i;

            if(isPrime[i] && isPrime[x]) {

                List<Integer> pair = new ArrayList<>();
                pair.add(i);
                pair.add(x);

                result.add(pair);
            }
        }

        return result;
    }
}
