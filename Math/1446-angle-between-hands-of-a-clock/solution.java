class Solution {
    public double angleClock(int hour, int minutes) 
    {
        hour%=12;
        double angle1 = hour * 30;
        double displaced = minutes * 0.5;
        double hourangle = angle1 + displaced;
        double minuteangle = minutes * 6;
        double diff = Math.abs(hourangle - minuteangle);
        return Math.min(diff,360-diff);
    }
}
