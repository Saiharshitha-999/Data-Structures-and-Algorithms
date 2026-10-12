class Solution {

    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {

        int answer = Integer.MAX_VALUE;

        int minutes = targetSeconds / 60;
        int seconds = targetSeconds % 60;

        if (minutes <= 99) {
            answer = Math.min(answer,
                    calculateCost(minutes, seconds, startAt, moveCost, pushCost));
        }

        if (minutes > 0 && seconds + 60 <= 99) {
            answer = Math.min(answer,
                    calculateCost(minutes - 1, seconds + 60, startAt, moveCost, pushCost));
        }

        return answer;
    }

    private int calculateCost(int minutes, int seconds,
                              int startAt, int moveCost, int pushCost) {

        String digits = String.format("%02d%02d", minutes, seconds);

        int index = 0;
        while (index < 3 && digits.charAt(index) == '0') {
            index++;
        }

        int current = startAt;
        int cost = 0;

        while (index < 4) {
            int digit = digits.charAt(index) - '0';

            if (current != digit) {
                cost += moveCost;
            }

            cost += pushCost;
            current = digit;
            index++;
        }

        return cost;
    }
}
