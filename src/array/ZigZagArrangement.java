package array;

import java.util.Arrays;

/**
 * Suppose we are processing B and C currently and the current relation is ‘<', but we have B > C.
 * Since current relation is ‘<' previous relation must be '>‘ i.e., A must be greater than B.
 * So, the relation is A > B and B > C. We can deduce A > C. So if we swap B and C then the relation is A > C and C < B.
 * Finally we get the desired order A C B
 * https://www.geeksforgeeks.org/converting-an-array-of-integers-into-zig-zag-fashion/
 */
public class ZigZagArrangement {
    public static void main(String args[]) {
        int input[] = {4, 3, 2, 6, 7, 1, 9};
        ZigZagArrangement zza = new ZigZagArrangement();
        int output[] = zza.rearrange(input);
        Arrays.stream(output).forEach(i -> System.out.print(i + " "));
    }

    private int[] rearrange(int[] input) {
        Boolean isLessRelation = true;

        for (int i = 0; i < input.length - 1; i++) {
            if (isLessRelation) {
                if (input[i] > input[i + 1]) {
                    swap(input, i, i + 1);
                }
            } else {
                if (input[i] < input[i + 1]) {
                    swap(input, i, i + 1);
                }
            }
            isLessRelation = !isLessRelation;
        }
        return input;
    }

    private void swap(int[] input, int indexOne, int indexTwo) {
        int temp = input[indexOne];
        input[indexOne] = input[indexTwo];
        input[indexTwo] = temp;
    }

}
