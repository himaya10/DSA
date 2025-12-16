import java.util.LinkedList;
import java.util.Queue;

class QueueStackPushFriendly {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push operation (O(1))
    void push(int x) {
        q1.add(x);
        System.out.println(x + " pushed");
    }

    // Pop operation (O(n))
    int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int popped = q1.remove();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return popped;
    }

    public static void main(String[] args) {
        QueueStackPushFriendly s = new QueueStackPushFriendly();
        s.push(10);
        s.push(20);
        System.out.println("Popped: " + s.pop());
    }
}
