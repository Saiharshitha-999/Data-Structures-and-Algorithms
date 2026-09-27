class Solution {
    public List<String> topKFrequent(String[] words, int k) 
    {
       Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        List<String> uniqueWords = new ArrayList<>(frequencyMap.keySet());
        uniqueWords.sort((w1, w2) -> {
            int freq1 = frequencyMap.get(w1);
            int freq2 = frequencyMap.get(w2);
            if (freq1 != freq2) {
                return freq2 - freq1;
            }
            return w1.compareTo(w2);
        });
        return uniqueWords.subList(0, k);
    }
}
