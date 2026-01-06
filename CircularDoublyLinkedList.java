class Node {
    int data;
    Node next, prev;

    Node(int data) {
        this.data = data;
    }
}

public class CircularDoublyLinkedList {
    Node head = null;

    // Insert at end
    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
            return;
        }

        Node last = head.prev;

        last.next = newNode;
        newNode.prev = last;
        newNode.next = head;
        head.prev = newNode;
    }

    // Delete a value
    public void delete(int data) {
        if (head == null) return;

        Node curr = head;

        do {
            if (curr.data == data) {
                if (curr == head && curr.next == head) {
                    head = null; // only one node
                    return;
                }

                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;

                if (curr == head) {
                    head = curr.next;
                }
                return;
            }
            curr = curr.next;
        } while (curr != head);
    }

    // Display list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList cd = new CircularDoublyLinkedList();

        cd.insert(10);
        cd.insert(20);
        cd.insert(30);
        cd.display();

        cd.delete(20);
        cd.display();
    }
}
