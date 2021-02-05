package array;

public class SmallestIntegerNotRepresentedBySubsetSum {

    public static void main(String args[]) {
        int input[] = {1, 2, 3, 8};
        SmallestIntegerNotRepresentedBySubsetSum ss = new SmallestIntegerNotRepresentedBySubsetSum();
        System.out.println(ss.findSmallestInteger(input));

        int input1[] = {};

        System.out.println(ss.minPatches(input1, 7));
    }

    private int minPatches(int[] input, int num) {
        int result = 1;
        int patches = 0;
        for (int j = 0; j < input.length; j++) {
            while (input[j] <= num) {
                if (input[j] <= result) {
                    result += input[j];
                } else {
                    result += result;
                    patches++;
                }
            }

        }
        return result;
    }

    private int findSmallestInteger(int[] input) {
        int result = 1;
        for (int i = 0; i < input.length; i++) {
            if (input[i] <= result) {
                result += input[i];
            } else {
                break;
            }
        }
        return result;
    }
}
