class UnboundedArrayStack {
    private int[] stack;
    private int top;
    private int capacity;

    UnboundedArrayStack() {
        capacity = 2;
        stack = new int[capacity];
        top = -1;
    }

    void push(int value) {
        if (top == capacity - 1) {
            resize(capacity * 2);
        }
        stack[++top] = value;
        System.out.println(value + " pushed");
    }

    int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }

        int popped = stack[top--];

        if (top > 0 && top == capacity / 4) {
            resize(capacity / 2);
        }
        return popped;
    }

    private void resize(int newCapacity) {
        int[] newStack = new int[newCapacity];
        for (int i = 0; i <= top; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
        capacity = newCapacity;
    }

    public static void main(String[] args) {
        UnboundedArrayStack s = new UnboundedArrayStack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("Popped: " + s.pop());
    }
}
