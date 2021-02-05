package array;

import java.util.HashMap;

public class SubarrayWithGivenSum {

    // Driver code
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
        for (int i = 0; i < length; i++) {
            currSum += arr[i];
            if (currSum == sum) {
                start = 0;
                end = i;
                break;
            } else if (sumTillNow.containsKey(currSum - sum)) {
                start = sumTillNow.get(currSum - sum) + 1;
                end = i;
                break;
            }
            sumTillNow.put(currSum, i);
        }
        if (end != -1) {
            System.out.println("Start " + start);
            System.out.println("End " + end);
        }
    }
}
