import java.util.Stack;

class StackQueueEnqueueFriendly {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // Enqueue operation (O(1))
    void enqueue(int x) {
        s1.push(x);
        System.out.println(x + " enqueued");
    }

    // Dequeue operation (O(n))
    int dequeue() {
        if (s1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        int dequeued = s2.pop();

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return dequeued;
    }

    public static void main(String[] args) {
        StackQueueEnqueueFriendly q = new StackQueueEnqueueFriendly();
        q.enqueue(100);
        q.enqueue(200);
        System.out.println("Dequeued: " + q.dequeue());
    }
}
