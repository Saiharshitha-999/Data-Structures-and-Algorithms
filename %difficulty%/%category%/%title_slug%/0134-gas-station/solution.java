class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currentTank = 0;
        int startingStation = 0;
        
        for (int i = 0; i < gas.length; i++) {
            int netFuel = gas[i] - cost[i];
            totalTank += netFuel;
            currentTank += netFuel;
            
            if (currentTank < 0) {
                startingStation = i + 1;
                currentTank = 0;
            }
        }
        
        return totalTank >= 0 ? startingStation : -1;
    }
}

