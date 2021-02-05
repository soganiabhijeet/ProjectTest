package sorting;

public class InsertionSort {

    // Driver method 
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6};

        InsertionSort ob = new InsertionSort();
        ob.sort(arr);

        printArray(arr);
    }

    private void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int j = 0;
            while (arr[j] < arr[i]) {
               j++;
            }
            int temp = arr[i];
            move(arr, j, i);
            arr[j] = temp;
        }
    }

    private void move(int[] arr, int left, int right) {
        //Will move all elements from left to right by 1

        for (int i = right; i > left ; i--) {
            arr[i] = arr[i - 1];
        }
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
