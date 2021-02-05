package dp;

import java.util.PriorityQueue;

//TODO do this
public class SuperUglyNumbers {

    private class Node implements Comparable<Node> {
        int value;
        int primeNum;
        int index;

        public Node(int value, int primeNum, int index) {
            this.value = value;
            this.primeNum = primeNum;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            if (this.value == o.value) {
                return this.primeNum - o.primeNum;
            }
            return this.value - o.value;
        }
    }

    public static void main(String[] args) {
        SuperUglyNumbers superUglyNumbers = new SuperUglyNumbers();
        int[] primes = {2, 7, 13, 19};
        System.out.println(superUglyNumbers.nthSuperUglyNumber(12, primes));
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        int num[] = new int[n + 1];

        for (int i = 0; i < primes.length; i++) {
            priorityQueue.offer(new Node(0, primes[i], i));
        }

        num[0] = 1;
        int i = 1;
        while (i < n) {
            Node node = priorityQueue.remove();
            if (num[i - 1] == node.value) {
                //we have already seen this value. lets remove it from the PQ
            } else {

                num[i] = node.value;
                i++;
            }
            node.index = node.index + 1;
            node.value = primes[node.primeNum]*num[node.index];
            priorityQueue.offer(node);
        }
        return num[n];
    }
}
