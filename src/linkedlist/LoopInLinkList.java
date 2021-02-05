package linkedlist;

public class LoopInLinkList {
    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        LinkedList.Node head = null;
        head = ll.push(1);
        ll.push(2);
        ll.push(3);
        ll.push(4);
        ll.push(5);
        ll.push(6);
        ll.push(7);
        ll.push(8);
        LinkedList.Node node1 = ll.find(8);
        LinkedList.Node node2 = ll.find(4);
        node1.next = node2;
        LoopInLinkList lll = new LoopInLinkList();
        System.out.println(lll.hasCycle(head));

        node2.next = null;
        System.out.println(lll.hasCycle(head));

        node1 = ll.find(3);
        node2.next = node1;
        System.out.println(lll.hasCycle(head));
    }

    private boolean hasCycle(LinkedList.Node head) {
        LinkedList.Node slowIter = head;
        LinkedList.Node fastIter = head.next;
        while (slowIter != null && fastIter != null && fastIter.next != null) {
            if (slowIter == fastIter) {
                return true;
            }
            slowIter = slowIter.next;
            fastIter = fastIter.next.next;
        }
        return false;
    }
}
