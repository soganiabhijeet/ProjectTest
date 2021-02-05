package dp;

import java.util.HashMap;

public class CountAs {
    private static int counter = 0;

    public static void main(String args[]) {
        CountAs ca = new CountAs();
        System.out.println(ca.countAsRec(20));
        System.out.println(counter);
        HashMap<Integer, Integer> inputResultMap = new HashMap<>();
        counter = 0;
        System.out.println(ca.countAs(20, inputResultMap));
        System.out.println(counter);

    }

    private int countAs(int input, HashMap<Integer, Integer> inputResultMap) {
        if (input <= 6) {
            inputResultMap.put(input, input);
            return input;
        }
        if (inputResultMap.containsKey(input)) {
            return inputResultMap.get(input);
        }
        counter++;
        int max = Integer.MIN_VALUE;
        int currValue = Integer.MIN_VALUE;
        for (int i = input; i > 2; i--) {
            currValue = (input - i + 1) * countAs(i - 2, inputResultMap);
            if (max < currValue) {
                max = currValue;
            }
        }
        inputResultMap.put(input, max);
        return max;
    }


    private int countAsRec(int input) {
        counter++;
        if (input <= 6) {
            return input;
        }
        int max = Integer.MIN_VALUE;
        int currValue = Integer.MIN_VALUE;

        /**
         * TODO explanation https://www.youtube.com/watch?v=nyR8K63F2KY
         * Max of 2*f(N-3) for case of just 1 Command+V at end f(N-3) Command+A Command+C Command+V
         *        3*f(N-4) for case of f(N-4) Command+A Command+C Command+V Command+V
         *        (N-2)*f(1)
         */
        for (int i = input; i > 2; i--) {
            currValue = (input - i + 1) * countAsRec(i - 2);
            if (max < currValue) {
                max = currValue;
            }
        }

        return max;
    }
}
