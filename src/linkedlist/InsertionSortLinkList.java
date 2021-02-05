package linkedlist;

public class InsertionSortLinkList {
    /* Driver function to test above methods */
    public static void main(String args[]) {
        LinkedList llist = new LinkedList();

        llist.push(5);
        llist.push(9);
        System.out.println("Created Linked List");
        llist.printList();
        InsertionSortLinkList insertionSortLinkList = new InsertionSortLinkList();
        insertionSortLinkList.insertSorted(llist.head, 9);
        System.out.println("Inserted Linked List");
        llist.printList();
    }

    private LinkedList.Node insertSorted(LinkedList.Node head, Integer value) {


        if (head == null) {
            LinkedList.Node node = new LinkedList.Node(value);
            return node;
        }
        LinkedList.Node currentNode = head;
        LinkedList.Node previousNode = null;
        while (currentNode != null && currentNode.val < value) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        //Append at the end
        LinkedList.Node node = new LinkedList.Node(value);
        previousNode.next = node;
        node.next = currentNode;
        return head;
    }
}
