package linkedlist;

import java.util.ArrayDeque;

public class LinkedListSum {
    //https://www.geeksforgeeks.org/sum-of-two-linked-lists/
    public static void main(String args[]) {
        //144
        //1029
        LinkedList numOne = new LinkedList();
        numOne.push(1, 0);
        numOne.push(4, 1);
        numOne.push(4, 2);

        LinkedList numTwo = new LinkedList();
        numTwo.push(1, 0);
        numTwo.push(0, 1);
        numTwo.push(2, 2);
        numTwo.push(9, 3);
        LinkedListSum linkedListSum = new LinkedListSum();
        LinkedList sum = linkedListSum.sum(numOne, numTwo);
        sum.printList();
    }

    public LinkedList sum(LinkedList numOne, LinkedList numTwo) {
        Integer sizeOne = numOne.size();
        Integer sizeTwo = numTwo.size();
        Integer diff = Math.abs(sizeOne - sizeTwo);
        if (sizeOne > sizeTwo) {
            numTwo = appendNumber(numTwo, diff);
        }
        if (sizeTwo > sizeOne) {
            numOne = appendNumber(numOne, diff);
        }
        ArrayDeque stackOne = new ArrayDeque<Integer>();
        ArrayDeque stackTwo = new ArrayDeque<Integer>();
        LinkedList.Node numOnePtr = numOne.head;
        LinkedList.Node numTwoPtr = numTwo.head;
        for (int i = 0; i < numOne.size(); i++) {
            stackOne.addFirst(numOnePtr.val);
            stackTwo.addFirst(numTwoPtr.val);
            numOnePtr = numOnePtr.next;
            numTwoPtr = numTwoPtr.next;
        }
        Integer carry = 0;
        LinkedList solution = new LinkedList();
        while (!stackOne.isEmpty()) {
            Integer one = (Integer) stackOne.pop();
            Integer two = (Integer) stackTwo.pop();
            Integer sum = carry + one + two;
            solution.push(sum % 10, 0);
            carry = sum / 10;
        }
        return solution;
    }

    private LinkedList appendNumber(LinkedList smallerNum, Integer carry) {
        for (int i = 0; i < carry; i++) {
            smallerNum.push(0, 0);
        }
        return smallerNum;
    }
}
