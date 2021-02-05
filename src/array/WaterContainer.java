package array;

public class WaterContainer {

    public static void main(String[] args) {
        int a[] = {1, 5, 4, 3};
        int b[] = {3, 1, 2, 4, 5};

        int len1 = 4;
        System.out.print(maxArea(a, len1) + "\n");

        int len2 = 5;
        System.out.print(maxArea(b, len2));
    }

    private static int maxArea(int[] a, int len1) {
        int maxArea = Integer.MIN_VALUE;
        int low = 0;
        int high = len1 - 1;
        while (low < high) {
            int area = Integer.min(a[low], a[high]) * (high - low);
            maxArea = checkAndUpdateMaxArea(maxArea, area);
            if (a[low] < a[high]) {
                low++;
            } else {
                high--;
            }
        }
        return maxArea;
    }

    private static int checkAndUpdateMaxArea(int maxArea, int area) {
        if (maxArea < area) {
            maxArea = area;
        }
        return maxArea;
    }
}
