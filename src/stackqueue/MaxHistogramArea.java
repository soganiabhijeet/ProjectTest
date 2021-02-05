package stackqueue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class MaxHistogramArea {

    public static void main(String[] args) {
        MaxHistogramArea maxHistogramArea = new MaxHistogramArea();
        int[] he = {2, 1, 5, 6, 2, 3};
        maxHistogramArea.largestRectangleArea(he);
    }

    public int largestRectangleArea(int[] heights) {

        int maxArea = Integer.MIN_VALUE;
        HashMap<Integer, Integer> nextSmallerToLeftMap = findNextSmallerToLeft(heights);

        HashMap<Integer, Integer> nextSmallerToRightMap = findNextSmallerToRight(heights);

        for (int i = 0; i < heights.length; i++) {

            int nextSmallerToLeft = nextSmallerToLeftMap.get(i);
            int nextSmallerToRight = nextSmallerToRightMap.get(i);
            if (nextSmallerToRight == -1) {
                nextSmallerToRight = heights.length;
            }
            int area = ((nextSmallerToRight - 1) - (nextSmallerToLeft)) * heights[i];
            if (area > maxArea) {
                maxArea = area;
            }

        }
        return maxArea;
    }

    private HashMap<Integer, Integer> findNextSmallerToLeft(int[] heights) {
        Deque<Pair> dq = new LinkedList<Pair>();
        HashMap<Integer, Integer> nextSmallerToLeftMap = new HashMap<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            if (dq.isEmpty()) {
                dq.push(new Pair(i, heights[i]));
            } else if (dq.peek().value <= heights[i]) {
                dq.push(new Pair(i, heights[i]));
            } else {
                while (!dq.isEmpty() && dq.peek().value > heights[i]) {
                    Pair pair = dq.remove();
                    nextSmallerToLeftMap.put(pair.index, i);
                }
                dq.push(new Pair(i, heights[i]));
            }
        }
        while (!dq.isEmpty()) {
            Pair pair = dq.remove();
            nextSmallerToLeftMap.put(pair.index, -1);
        }
        return nextSmallerToLeftMap;
    }

    private HashMap<Integer, Integer> findNextSmallerToRight(int[] heights) {
        Deque<Pair> dq = new LinkedList<Pair>();
        HashMap<Integer, Integer> nextSmallerToLeftMap = new HashMap<>();
        for (int i = 0; i < heights.length; i++) {
            if (dq.isEmpty()) {
                dq.push(new Pair(i, heights[i]));
            } else if (dq.peek().value <= heights[i]) {
                dq.push(new Pair(i, heights[i]));
            } else {
                while (!dq.isEmpty() && dq.peek().value > heights[i]) {
                    Pair pair = dq.remove();
                    nextSmallerToLeftMap.put(pair.index, i);
                }
                dq.push(new Pair(i, heights[i]));
            }
        }
        while (!dq.isEmpty()) {
            Pair pair = dq.remove();
            nextSmallerToLeftMap.put(pair.index, -1);
        }
        return nextSmallerToLeftMap;
    }

    private class Pair {
        Integer index;
        Integer value;

        public Pair(Integer index, Integer value) {
            this.index = index;
            this.value = value;
        }
    }
}
