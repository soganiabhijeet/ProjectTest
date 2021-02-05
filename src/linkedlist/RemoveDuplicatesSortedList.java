package linkedlist;

public class RemoveDuplicatesSortedList {
    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        LinkedList.Node head = null;
        head = ll.addNode(1, head);
        head = ll.addNode(1, head);
        head = ll.addNode(1, head);
        head = ll.addNode(4, head);
        head = ll.addNode(4, head);
        head = ll.addNode(5, head);
        head = ll.addNode(6, head);
        head = ll.addNode(6, head);
        head = ll.addNode(6, head);
        RemoveDuplicatesSortedList rds = new RemoveDuplicatesSortedList();
        rds.removeDuplicates(ll.head);
        //ll.printList();
    }

    private void removeDuplicates(LinkedList.Node head) {
        LinkedList.Node prev = null;
        LinkedList.Node iter = head;
        while (iter != null) {
            while (prev != null && iter != null && iter.val == prev.val) {
                prev.next = iter.next;
                iter = iter.next;
            }
            if (iter != null) {
                prev = iter;
                iter = iter.next;
            }
        }
        LinkedList.Node iterCLone = head;
        while (iterCLone != null) {
            System.out.println(iterCLone.val);
            iterCLone = iterCLone.next;
        }

    }
}
