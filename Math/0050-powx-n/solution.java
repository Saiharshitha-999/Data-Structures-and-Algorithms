class Solution {
    public double myPow(double x, int n) 
    {
        double ans = 1;
        long power = n;
        if(power < 0)
        {
            x = 1/x;
            power = -power;
        }
        return power(x,power);
    }
    public double power(double x, long power)
    {
        if(power==0)
        {
            return 1;
        }
        if(power%2==1)
        {
            return x * power(x,power-1);
        }
        else
        {
            return power(x*x,power/2);
        }
               
    } 
 }

