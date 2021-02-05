package stackqueue;

public class RainWaterTrapping {

    public int trap(int[] height) {
        int[] largestAtLeft = new int[height.length];
        int[] largestAtRight = new int[height.length];
        int leftConst = Integer.MIN_VALUE;
        int rightConst = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > leftConst) {
                leftConst = height[i];
            }
            largestAtLeft[i] = leftConst;
        }
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > rightConst) {
                rightConst = height[i];
            }
            largestAtRight[i] = rightConst;
        }
        int waterTrapped = 0;
        for (int i = 0; i < height.length; i++) {
            Integer value = height[i] - Integer.min(largestAtLeft[i], largestAtRight[i]);
            if (value > 0) {
                waterTrapped = value + waterTrapped;
            }
        }

        return waterTrapped;
    }
}
