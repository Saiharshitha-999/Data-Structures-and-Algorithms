class Solution {
    public List<Integer> numOfBurgers(int tomato, int cheese) 
    {
        List<Integer> result = new ArrayList<>();
        if (tomato < cheese) {
            return result;
        }
        int jumbo = (tomato - (2 * cheese)) / 2;
        int small = cheese - jumbo;
        
        tomato -= 4 * jumbo + 2 * small;
        cheese -= jumbo + small;
        
        if (tomato == 0 && cheese == 0 && jumbo >= 0 && small >= 0) {
            result.add(jumbo);
            result.add(small);
        }
        
        return result;
    }
}
