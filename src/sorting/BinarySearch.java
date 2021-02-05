package sorting;

public class BinarySearch {

    // Driver method to test above
    public static void main(String args[]) {
        BinarySearch ob = new BinarySearch();
        int arr[] = {2, 3, 4, 10, 40};
        int n = arr.length;
        int x = 10;
        int result = ob.binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }

    public int binarySearch(int arr[], int left, int right, int element) {
        if (left <= right) {
            int mid = (right + left) / 2;
            if (arr[mid] == element) {
                return mid;
            }
            if (element > arr[mid]) {
               return binarySearch(arr, mid + 1, right, element);
            } else {
               return binarySearch(arr, left, mid - 1, element);
            }
        }

        return -1;

    }
}
