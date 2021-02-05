package sorting;

public class QuickSort {
    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n - 1);

        System.out.println("sorted array");
        printArray(arr);
    }

    private void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            sort(arr, pivot + 1, high);
            sort(arr, low, pivot - 1);
        }
    }

    //Will return pivot position and all elements to left of it less and vice versa.
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        while (low < high) {
            if (arr[low] < pivot) {
                low++;
            } else if (arr[high] > pivot) {
                high--;
            } else {
                //swap
                swap(arr, low, high);
            }
        }
        return low;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
