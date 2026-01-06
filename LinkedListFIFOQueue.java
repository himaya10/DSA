class QueueNode {
    int data;
    QueueNode next;

    QueueNode(int data) {
        this.data = data;
    }
}

public class LinkedListFIFOQueue {
    QueueNode front = null, rear = null;

    public void enqueue(int value) {
        QueueNode newNode = new QueueNode(value);

        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public int dequeue() {
        if (front == null) {
            System.out.println("Queue Underflow!");
            return -1;
        }
        int val = front.data;
        front = front.next;

        if (front == null) rear = null;

        return val;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void display() {
        QueueNode temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListFIFOQueue q = new LinkedListFIFOQueue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();

        System.out.println(q.dequeue());
        q.display();
    }
}
