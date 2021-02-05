package linkedlist;

public class DeleteNAfterMNodes {
    public static void main(String args[]) {
        DeleteNAfterMNodes daf = new DeleteNAfterMNodes();
        LinkedList ll = new LinkedList();
        int M=2, N=3;
        ll.push( 1);
        ll.push( 2);
        ll.push( 3);
        ll.push( 4);
        ll.push( 5);
        ll.push( 6);
        ll.push( 7);
        ll.push( 8);
        ll.push( 9);
        ll.push( 10);
        ll.printList();
        daf.deleteNAfterMNodes(ll.head, N, M);
        ll.printList();
    }

    private void deleteNAfterMNodes(LinkedList.Node head, int n, int m) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            while (n != 0) {
                if (head == null) {
                    throw new IllegalArgumentException();
                }
                head = head.next;
                n--;
            }
        } else {
            LinkedList.Node prev = null;
            LinkedList.Node current = head;
            while (m != 0) {
                prev = current;
                if (current == null) {
                    throw new IllegalArgumentException();
                }
                current = current.next;
                m--;
            }
            while (n != 0) {
                if (current == null) {
                    throw new IllegalArgumentException();
                }
                current = current.next;
                n--;
            }
            prev.next = current;
        }
    }
}
