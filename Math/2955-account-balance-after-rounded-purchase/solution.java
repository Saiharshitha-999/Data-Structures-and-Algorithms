class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) 
    {
        int rounded;
        if (purchaseAmount % 10 < 5)
            rounded = purchaseAmount - purchaseAmount % 10;
        else
            rounded = purchaseAmount + (10 - purchaseAmount % 10);

        return 100 - rounded;
    }
}
