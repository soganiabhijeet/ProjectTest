package stackqueue;

public class CircularQueue<T> {
    //https://www.geeksforgeeks.org/circular-queue-set-1-introduction-array-implementation
    private int QUEUE_LENGTH;
    private T data[] = null;
    private int rear = -1;
    private int front = -1;

    public CircularQueue(int size) {
        this.QUEUE_LENGTH = size;
        data = (T[]) new Object[QUEUE_LENGTH];
    }

    public void enqueue(T item) {
        if (front == -1) {
            data[0] = item;
            rear = 0;
            front = 0;
        } else if (front == (rear + 1) % QUEUE_LENGTH) {
            throw new IllegalArgumentException();
        } else {
            rear = (rear + 1) % QUEUE_LENGTH;
            data[rear] = item;
        }
    }

    public T peek() {
        if (front == -1) {
            throw new IllegalArgumentException();
        }
        return data[front];
    }

    public T dequeue() {
        if (rear == -1) {
            throw new IllegalArgumentException();
        } else if (rear == front) {
            T t = data[front];
            rear = -1;
            front = -1;
            return t;
        }
        else {
            T t=data[front];
            front = (front + 1) % QUEUE_LENGTH;
            return t;
        }
    }
    public static void main(String args[]) {
        CircularQueue<Integer> circularQueue = new CircularQueue<Integer>(5);
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        System.out.println(circularQueue.dequeue());
    }
}
