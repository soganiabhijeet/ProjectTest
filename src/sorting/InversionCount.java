package sorting;

public class InversionCount {

    // Driver code 
    public static void main(String[] args) {
        int[] arr = {1, 20, 6, 4, 5};
        InversionCount inversionCount = new InversionCount();
        System.out.println(inversionCount.mergeSortAndCount(arr, 0, arr.length - 1));
    }

    private int mergeSortAndCount(int[] arr, int left, int right) {
        int count = 0;
        if (left < right) {
            int middle = (left + right) / 2;
            count += mergeSortAndCount(arr, left, middle - 1);
            count += mergeSortAndCount(arr, middle + 1, right);
           // count += countInversionInSubArray(arr, left, right, middle);
        }

        return count;
    }


}
