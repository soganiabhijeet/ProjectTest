package linkedlist;

/**
 * Date 04/17/2016
 *
 * <p>
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct
 * numbers from the original list.
 * <p>
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * <p>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class DeleteDuplicateNodes {

    /* Driver program to test above functions */
    public static void main(String args[]) {
        LinkedList llist = new LinkedList();
        llist.push(20);
        llist.push(20);
        llist.push(20);
        llist.push(11);
        llist.push(11);
        llist.push(11);

        System.out.println("List before removal of duplicates");
        llist.printList();
        DeleteDuplicateNodes deleteDuplicateNodes = new DeleteDuplicateNodes();
        deleteDuplicateNodes.deleteDuplicates(llist.head);

        System.out.println("List after removal of elements");
        llist.printList();
    }

    public LinkedList.Node deleteDuplicates(LinkedList.Node node) {
        LinkedList.Node currentNode = node;
        while (currentNode != null) {
            while (currentNode.next != null && currentNode.val == currentNode.next.val) {
                currentNode.next = currentNode.next.next;
            }
            currentNode = currentNode.next;
        }
        return node;

    }
}
