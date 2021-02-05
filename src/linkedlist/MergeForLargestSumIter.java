package linkedlist;

public class MergeForLargestSumIter {
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

        MergeForLargestSumIter mls = new MergeForLargestSumIter();
        LinkedList.Node result = mls.maxChain(ll.head, ll2.head);
        result.printList();
    }

    private LinkedList.Node maxChain(LinkedList.Node headOne, LinkedList.Node headTwo) {
        LinkedList.Node headOneIter = headOne;
        LinkedList.Node headTwoIter = headTwo;
        LinkedList.Node prevNode;
        LinkedList.Node ptrToBeReturned;
        Boolean isPtrToNodeOne;
        Boolean isItFirstTimeSameNumEncountered = true;

        while (headOneIter != null || headTwoIter != null) {
            Integer sumOne = 0, sumTwo = 0;
            if (headOneIter == null || headTwoIter == null) {

            }
            if (headOneIter.val > headTwoIter.val) {
                sumTwo = sumTwo + headTwoIter.val;
                headTwoIter = headTwoIter.next;
            } else if (headTwoIter.val > headOneIter.val) {
                sumOne = sumOne + headOneIter.val;
                headOneIter = headOneIter.next;
            } else {
                //Both are equal
                if (sumOne > sumTwo) {
                    if (isItFirstTimeSameNumEncountered) {
                        ptrToBeReturned = headOne;
                        isItFirstTimeSameNumEncountered = false;

                    }
                    //ptrNode = headOneIter;
                    isPtrToNodeOne = true;
                } else {
                    if (isItFirstTimeSameNumEncountered) {
                        ptrToBeReturned = headTwo;
                        isItFirstTimeSameNumEncountered = false;
                    } else {

                    }
                    //ptrNode = headTwoIter;
                    isPtrToNodeOne = false;
                }
            }
        }
        return null;
    }
}
