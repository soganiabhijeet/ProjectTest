package linkedlist;

public class ReverseAlternateKNodes {
    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        LinkedList.Node head = null;
        head = ll.addNode(1, head);
        head = ll.addNode(2, head);
        head = ll.addNode(3, head);
        head = ll.addNode(4, head);
        head = ll.addNode(5, head);
        head = ll.addNode(6, head);
        head = ll.addNode(7, head);
        head = ll.addNode(8, head);

        ReverseAlternateKNodes ra = new ReverseAlternateKNodes();
        head = ra.reverse(head, 3, true);
        ll.printList();
    }

    private LinkedList.Node reverse(LinkedList.Node head, int k, boolean toReverse) {
        Integer kIter = k;
        if (head == null || head.next == null) {
            return head;
        }
        while (kIter != 0) {
            if (toReverse) {
                LinkedList.Node currentIter = head.next;
                LinkedList.Node nextIter = currentIter.next;
                LinkedList.Node prevIter = head;

            }
        }
        return null;
    }
}
