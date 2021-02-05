package linkedlist;

public class MergeForLargestSum {
    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        LinkedList.Node head1 = null;
        ll.push(1);
        ll.push(3);
        ll.push(30);
        ll.push(90);
        ll.push(120);
        ll.push(240);
        ll.push(243);
        ll.push(251);
        ll.push(511);
        LinkedList ll2 = new LinkedList();
        ll2.push(0);
        ll2.push(3);
        ll2.push(12);
        ll2.push(32);
        ll2.push(90);
        ll2.push(125);
        ll2.push(240);
        ll2.push(249);
        ll2.push(251);
        ll2.push(260);

        MergeForLargestSum mls = new MergeForLargestSum();
        LinkedList.Node result = mls.maxChain(ll.head, ll2.head);
        result.printList();
    }

    private LinkedList.Node maxChain(LinkedList.Node head1, LinkedList.Node head2) {
        LinkedList.Node headOneItr = head1;
        LinkedList.Node headTwoItr = head2;
        LinkedList linkedListOne = new LinkedList();
        LinkedList linkedListTwo = new LinkedList();
        Integer sumOne = 0;
        Integer sumTwo = 0;
        while (headOneItr != null || headTwoItr != null) {

            if (headOneItr == null || headTwoItr == null) {
                while (headOneItr != null) {
                    sumOne = sumOne + headOneItr.val;
                    linkedListOne.push(headOneItr.val);
                    headOneItr = headOneItr.next;

                }
                while (headTwoItr != null) {
                    sumTwo = sumTwo + headTwoItr.val;
                    linkedListTwo.push(headTwoItr.val);
                    headTwoItr = headTwoItr.next;
                }
                if (sumOne > sumTwo) {
                    return linkedListOne.head;
                } else {
                    return linkedListTwo.head;
                }
            }
            if (headOneItr.val < headTwoItr.val) {
                //Add less value
                linkedListOne.push(headOneItr.val);
                sumOne = sumOne + headOneItr.val;
                headOneItr = headOneItr.next;

            } else if (headOneItr.val > headTwoItr.val) {
                linkedListTwo.push(headTwoItr.val);
                sumTwo = sumTwo + headTwoItr.val;
                headTwoItr = headTwoItr.next;
            } else if (headOneItr.val == headTwoItr.val) {
                //Both values are equal
                if (sumTwo > sumOne) {
                    LinkedList.Node lastNode = linkedListTwo.push(headTwoItr.val);
                    lastNode.next = maxChain(headOneItr.next, headTwoItr.next);
                    return linkedListTwo.head;
                } else {
                    LinkedList.Node lastNode = linkedListOne.push(headOneItr.val);
                    lastNode.next = maxChain(headOneItr.next, headTwoItr.next);
                    return linkedListOne.head;
                }

            }
        }
        return null;
    }
}
