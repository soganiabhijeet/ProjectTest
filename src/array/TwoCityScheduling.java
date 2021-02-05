package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class TwoCityScheduling {

    public int twoCitySchedCost(int[][] costs) {
        //TODO read about comparators
        Comparator<int[]> comparator = (a, b) -> Math.abs(b[0] - b[1]) - Math.abs(a[0] - a[1]);
        Arrays.sort(costs, comparator);
        int n = costs.length / 2;
        int firstCityCounter = 0;
        int secondCityCounter = 0;
        int counter = 0;
        int output = 0;
        while (counter < 2 * n) {
            if (firstCityCounter == n || costs[counter][1] < costs[counter][0]) {
                counter++;
                secondCityCounter++;
                output += costs[counter][1];
            } else {
                counter++;
                firstCityCounter++;
                output += costs[counter][0];
            }
        }
        return output;
    }
}
