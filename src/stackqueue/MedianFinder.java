package stackqueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> minPq = new PriorityQueue<>();
    PriorityQueue<Integer> maxPq = new PriorityQueue<>();

    public MedianFinder() {
        minPq = new PriorityQueue<>();
        maxPq = new PriorityQueue<>(20, Collections.reverseOrder());
    }

    public void addNum(int num) {

        if (minPq.isEmpty() && maxPq.isEmpty()) {
            minPq.add(num);
        } else if (minPq.isEmpty() || num >= minPq.peek()) {
            minPq.add(num);
        } else if (maxPq.isEmpty() || num < minPq.peek()) {
            maxPq.add(num);
        }
        if ((minPq.size() - maxPq.size()) == 2) {
            Integer value = minPq.poll();
            maxPq.add(value);
        }
        if ((maxPq.size() - minPq.size()) == 2) {
            Integer value = maxPq.poll();
            minPq.add(value);
        }

    }

    public double findMedian() {
        if (maxPq.size() == minPq.size() && maxPq.size() == 0) {
            return 0d;
        } else if (maxPq.size() == minPq.size()) {
            double value = (maxPq.peek() + minPq.peek()) / 2D;
            return value;
        } else if (maxPq.size() > minPq.size()) {
            return maxPq.peek();
        } else {
            return minPq.peek();
        }
    }

    public static void main(String args[]) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(4);
        System.out.println(mf.findMedian());
        mf.addNum(8);
        System.out.println(mf.findMedian());
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(11);
        System.out.println(mf.findMedian());
        mf.addNum(13);
        System.out.println(mf.findMedian());
        mf.addNum(14);
        System.out.println(mf.findMedian());
        mf.addNum(-1);
        System.out.println(mf.findMedian());

    }
}
