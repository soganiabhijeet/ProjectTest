package array;

public class TrappingRainWater {
    static int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

    // Driver method to test the above function
    public static void main(String[] args) {

        System.out.println("Maximum water that can be accumulated is " + findWater(arr.length));
    }

    private static Integer findWater(int length) {
        int[] leftMax = new int[length];
        int leftMaxTillNow = 0;
        for (int i = 0; i < length; i++) {
            leftMax[i] = leftMaxTillNow;
            if (arr[i] > leftMaxTillNow) {
                leftMaxTillNow = arr[i];
            }
        }
        int[] rightMax = new int[length];
        int rightMaxTillNow = 0;
        for (int j = length - 1; j >= 0; j--) {
            rightMax[j] = rightMaxTillNow;
            if (arr[j] > rightMaxTillNow) {
                rightMaxTillNow = arr[j];
            }
        }
        Integer area = 0;
        for (int i = 0; i < length; i++) {
            area = area + Integer.max(0, Integer.min(leftMax[i], rightMax[i]) - arr[i]);
        }
        return area;
    }
}
