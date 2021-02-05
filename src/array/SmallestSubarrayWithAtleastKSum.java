package array;

import java.util.HashMap;

public class SmallestSubarrayWithAtleastKSum {
    //TODO https://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/ Try this with hashing method

    public static void main(String[] args) {
        int[] arr = {1, 4, 20, 3, 10, 4};
        int n = arr.length;
        int sum = 37;
        subArraySum(arr, n, sum);

    }

    private static void subArraySum(int[] arr, int length, int sum) {
        HashMap<Integer, Integer> sumTillNow = new HashMap<>();
        Integer currSum = 0;
        Integer start = 0;
        Integer end = -1;
        Integer minSubArray = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            currSum += arr[i];
            if (currSum == sum) {
                start = 0;
                end = i;
                minSubArray = updateMinIfNeeded(i, minSubArray);
            } else if (sumTillNow.containsKey(currSum - sum)) {
                start = sumTillNow.get(currSum - sum) + 1;
                end = i;
                minSubArray = updateMinIfNeeded(i, minSubArray);
            }
            sumTillNow.put(currSum, i);
        }
    }

    private static int updateMinIfNeeded(int value, int min) {
        if (value < min) {
            return value;
        }
        return min;
    }
}
