class Solution {
    public String categorizeBox(int length, int width, int height, int mass) 
    {
        boolean is_Bulky = false;
        boolean is_Heavy = false;
        long volume = 1L * length * width * height;

        if(length >= 10000 || width >= 10000 || height >= 10000 || volume >= 1000000000L)
        {
            is_Bulky = true;
        }
        if(mass >= 100)
        {
            is_Heavy = true;
        }
        if(is_Bulky && is_Heavy)
        {
            return "Both";
        }
        else if(is_Bulky && !is_Heavy)
        {
            return "Bulky";
        }
        else if(!is_Bulky && is_Heavy)
        {
            return "Heavy";
        }
        else
        {
            return "Neither";
        }
    }
}
