import java.util.Stack;

public class StackQueueDequeueFriendly {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    // Enqueue operation - O(n)
    public void enqueue(int data) {
        // Move all elements from s2 to s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        s1.push(data);
        // Move all back to s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }

    // Dequeue operation - O(1)
    public int dequeue() {
        if (s2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return s2.pop();
    }

    public boolean isEmpty() {
        return s2.isEmpty();
    }

    public int peek() {
        if (s2.isEmpty()) return -1;
        return s2.peek();
    }
}
