class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
       
        int i = prices.length - 1;
        int j = discounts.length - 1;
        double sum = 0;
        while(i >= 0 && j >= 0)
        {
            double formula = (prices[i] * (100 - discounts[j]))/(double)100;
            sum += formula;
            i--;
            j--;
        }
        while(i >= 0)
        {
            sum += prices[i];  
            i--;
        }
        return sum;
    }
}
