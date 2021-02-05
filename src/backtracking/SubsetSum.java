package backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {


    public static void main(String[] args) {
        int weights[] = {10, 7, 5, 18, 12, 20, 15};
        List<Integer> integerList = new ArrayList<>();

        new SubsetSum().generateSubsets(weights, integerList, 35, 0);
    }

    private void generateSubsets(int[] weights, List<Integer> integerList, int total, int index) {
        if (total == 0) {
            System.out.println(integerList);
        }
        if (total < 0 || index >= weights.length) {
            return;
        }

        //dont Include current number
        generateSubsets(weights, integerList, total, index + 1);
        //Include current number
        integerList.add(weights[index]);
        generateSubsets(weights, integerList, total - weights[index], index + 1);
        integerList.remove(integerList.size() - 1);
    }
}
