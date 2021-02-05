package linkedlist;

public class MergeSortLinkList {
    public static void main(String args[]) {
        MergeSortLinkList msll = new MergeSortLinkList();
        LinkedList ll = new LinkedList();
        ll.push(11);
        ll.push(12);
        ll.push(-3);
        ll.push(45);
        ll.push(5);
        ll.printList();
        LinkedList.Node head = msll.sort(ll.head, false);
        head.printList();
    }

    public LinkedList.Node sort(LinkedList.Node head, boolean isAscending) {

        if (head == null || head.next == null) {
            return head;
        }
        LinkedList.Node head1 = frontBackSplit(head);
        head = sort(head, isAscending);
        head1 = sort(head1, isAscending);
        return sortedMerge(head, head1, isAscending);
    }

    private LinkedList.Node sortedMerge(LinkedList.Node one, LinkedList.Node two, boolean isAscending) {
        LinkedList linkedList = new LinkedList();
        LinkedList.Node oneIterator = one;
        LinkedList.Node twoIterator = two;
        while (oneIterator != null || twoIterator != null) {
            if (oneIterator == null || twoIterator == null) {
                while (oneIterator != null) {
                    linkedList.push(oneIterator.val);
                    oneIterator = oneIterator.next;
                }
                while (twoIterator != null) {
                    linkedList.push(twoIterator.val);
                    twoIterator = twoIterator.next;
                }
            } else if (oneIterator.val < twoIterator.val) {
                linkedList.push(oneIterator.val);
                oneIterator = oneIterator.next;
            } else if (twoIterator.val < oneIterator.val) {
                linkedList.push(twoIterator.val);
                twoIterator = twoIterator.next;
            } else {
                linkedList.push(twoIterator.val);
                linkedList.push(oneIterator.val);
                oneIterator = oneIterator.next;
                twoIterator = twoIterator.next;
            }
        }
        return linkedList.head;
    }

    private LinkedList.Node frontBackSplit(LinkedList.Node head) {
        LinkedList.Node fastPtr = head;
        LinkedList.Node middle = head;
        LinkedList.Node middlePrev = null;
        while (fastPtr != null && fastPtr.next != null) {
            middlePrev = middle;
            middle = middle.next;
            fastPtr = fastPtr.next.next;
        }
        if (middlePrev == null) {
            head.next = null;
            return head;
        }
        middlePrev.next = null;
        return middle;
    }
}
