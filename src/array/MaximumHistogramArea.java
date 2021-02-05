package array;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumHistogramArea {

    /**
     * 1. Add to stack if current value is equal to or greater than top of stack.
     * 2. Otherwise keep removing values from stack till a number which is smaller than current is found.
     * 3. Calculate area everytime you remove
     * if(stack is empty)
     * //You are at the lowest value in array.
     * area=input[top]*i
     * else
     * area=input[top]*(i-stack.peek-1)
     */


    public static void main(String args[]) {
        MaximumHistogramArea mh = new MaximumHistogramArea();
        int input[] = {2, 2, 2, 6, 1, 5, 4, 2, 2, 2, 2};
        int maxArea = mh.maxHistogram(input);
        System.out.println(maxArea);
        assert maxArea == 12;
    }

    private int maxHistogram(int[] input) {
        Deque<Integer> stack = new LinkedList<Integer>();

        int maxArea = Integer.MIN_VALUE;
        int i;
        for (i = 0; i < input.length;) {
            if (stack.isEmpty() || input[stack.peek()] <= input[i]) {
                System.out.println("Pushed" + i);
                stack.offerFirst(i++);
            } else {
                int top = stack.poll();
                if (stack.isEmpty()) {
                    //Last value
                    int area = input[top] * i;
                    maxArea = checkAndUpdateMaxArea(maxArea, area);
                } else {
                    int area = input[top] * (i - stack.peek() - 1);
                    maxArea = checkAndUpdateMaxArea(maxArea, area);
                }
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.poll();
            if (stack.isEmpty()) {
                //Last value
                int area = input[top] * i;
                maxArea = checkAndUpdateMaxArea(maxArea, area);
            } else {
                int area = input[top] * (i - stack.peekFirst() - 1);
                maxArea = checkAndUpdateMaxArea(maxArea, area);
            }
        }
        return maxArea;
    }

    private int checkAndUpdateMaxArea(int maxArea, int area) {
        if (maxArea < area) {
            maxArea = area;
        }
        return maxArea;
    }
}
