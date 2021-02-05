package dp;

public class SubsetSum {
    public static void main(String[] args) {
        SubsetSum subsetSum = new SubsetSum();
        int input[] = {1, 5, 11, 5};
        subsetSum.subsetSum(0, input, 0, 0);

    }

    boolean subsetSum(int total, int[] input, int index, int currSum) {
        if (total == currSum) {
            return true;
        } else if (index == input.length) {
            return false;
        }
        return subsetSum(total - input[index], input, index + 1, currSum) ||
                subsetSum(total, input, index + 1, currSum);
    }
}
