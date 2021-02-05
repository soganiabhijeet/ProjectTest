package dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Knapsack01 {
    static Integer totalCountAtEnd = 0;
    static Integer totalCount = 0;

    class Index {
        int weight;
        int index;

    }

    public static void main(String args[]) {
        Knapsack01 k = new Knapsack01();
        int val[] = {22, 20, 15, 30, 24, 54, 21, 32, 18, 25};
        int wt[] = {4, 2, 3, 5, 5, 6, 9, 7, 8, 10};

        int r1 = k.topDownRecursive(val, wt, 30);

        System.out.println(r1);
        System.out.println(totalCount);
        System.out.println(totalCountAtEnd);
    }

    private int topDownRecursive(int[] val, int[] wt, int weight) {
        Map<Index, Integer> indexIntegerMap = new HashMap<>();
        return topDownRecursiveUtil(val, wt, weight, 0, indexIntegerMap);
    }

    private int topDownRecursiveUtil(int[] val, int[] wt, int remainingWeight, int currItem, Map<Index, Integer> indexIntegerMap) {
        totalCount++;
        if (remainingWeight <= 0 || currItem >= val.length) {
            return 0;
        }
        Index index = new Index();
 /*       index.index = currItem;
        index.weight = remainingWeight;*/
        index.index = currItem;
        index.weight = remainingWeight;
        if (indexIntegerMap.containsKey(index)) {
            System.out.println("In loop");
            return indexIntegerMap.get(index);
        }
        totalCountAtEnd++;
        Integer result;
        if (remainingWeight < wt[currItem]) {
            result = topDownRecursiveUtil(val, wt, remainingWeight, currItem + 1, indexIntegerMap);
        } else {
            result = Integer.max(topDownRecursiveUtil(val, wt, remainingWeight - wt[currItem], currItem + 1, indexIntegerMap) + val[currItem],
                    topDownRecursiveUtil(val, wt, remainingWeight, currItem + 1, indexIntegerMap));
        }

        indexIntegerMap.put(index, result);
        return result;
    }
}
