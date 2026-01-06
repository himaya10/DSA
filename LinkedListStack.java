class StackNode {
    int data;
    StackNode next;

    StackNode(int data) {
        this.data = data;
    }
}

public class LinkedListStack {
    StackNode top = null;

    public void push(int value) {
        StackNode newNode = new StackNode(value);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        int val = top.data;
        top = top.next;
        return val;
    }

    public int peek() {
        if (top == null) {
            System.out.println("Stack Empty!");
            return -1;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        LinkedListStack st = new LinkedListStack();

        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println(st.pop());
        System.out.println(st.peek());
    }
}
