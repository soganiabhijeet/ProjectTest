package dp;

import java.util.Arrays;

public class LargestDivisiblePairSubset {
    // driver code to check the above function
    public static void main(String[] args) {
        int[] a = {18, 1, 3, 6, 13, 17} ;
        Arrays.sort(a);
        int n = a.length;
        System.out.println(largestSubset(a, 1, 0, 0));
    }

    private static int largestSubset(int[] array, int lastDiv, int numTillNow, int index) {
        if (index == array.length - 1) {
            if (array[index] % lastDiv == 0) {
                return 1 + numTillNow;
            } else {
                return numTillNow;
            }
        }
        //Include Current Number
        int includedNum;
        if (array[index] % lastDiv == 0) {
            includedNum = largestSubset(array, array[index], numTillNow + 1, index + 1);
        } else {
            includedNum = largestSubset(array, lastDiv, numTillNow, index + 1);
        }
        // start from here
        int excludedNum = largestSubset(array, array[index], 1, index + 1);
        return Integer.max(includedNum, excludedNum);
    }
}
