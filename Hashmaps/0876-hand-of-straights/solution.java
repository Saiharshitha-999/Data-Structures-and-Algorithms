class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) 
            return false;

        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int card : hand)
            freq.put(card, freq.getOrDefault(card, 0) + 1);

       
        for (int card : freq.keySet()) {
            int count = freq.get(card);
            if (count > 0) {
                
                for (int i = 1; i < groupSize; i++) {
                    int next = card + i;
                    if (!freq.containsKey(next) || freq.get(next) < count)
                        return false;
                    freq.put(next, freq.get(next) - count);
                }
            }
        }
        return true;
    }
}
