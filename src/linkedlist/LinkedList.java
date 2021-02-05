package linkedlist;

public class LinkedList {

    public Node find(int i) {
        if (head == null)
            return null;
        Node current = head;
        while (current != null) {
            if (current.val == i) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public Node addNode(int i, Node head) {
        this.push(i);
        return head;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }

        public void printList() {
            Node node = this;
            while (node != null) {
                System.out.println(node.val);
                node = node.next;
            }
        }
    }

    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void printList() {
        Node ptr = head;
        while (ptr != null) {
            System.out.println(ptr.val);
            ptr = ptr.next;
        }
    }

    public Node push(Integer value, Integer position) {
        if (position == 0) {
            Node node = new Node(value);
            node.next = head;
            head = node;
        } else if (position == 1) {
            Node node = new Node(value);
            node.next = head.next;
            head.next = node;
        } else {
            Node ptr = head;
            Integer counter = 0;
            Node prev = head;
            while (counter != position) {
                if (ptr == null) {
                    throw new IllegalStateException();
                }
                prev = ptr;
                ptr = ptr.next;
                counter++;
            }
            Node node = new Node(value);
            node.next = ptr;
            prev.next = node;
        }
        return head;
    }

    public Node push(Integer value) {
        if (head == null) {
            head = new Node(value);
            return head;
        }
        Node ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = new Node(value);
        return ptr.next;
    }

    public int size() {
        int size = 0;
        Node ptr = head;
        while (ptr != null) {
            size++;
            ptr = ptr.next;
        }
        return size;
    }


}
