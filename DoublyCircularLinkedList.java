package datastructures;

public class DoublyCircularLinkedList {
    Node head = null;
    Node tail = null;

    class Node {
        int data;
        Node next, prev;

        public Node(int d) {
            data = d;
            next = prev = null;
        }
    }

    public void handleOperation(int opChoice, int posChoice, int value) {
        switch (opChoice) {
            case 1:
                insertion(posChoice, value);
                break;
            case 2:
                deletion(posChoice);
                break;
            case 3:
                searching(value);
                break;
            case 4:
                traversal();
                break;
        }
    }

    public void insertion(int posChoice, int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = tail = newNode;
            head.next = head.prev = head;
        } else if (posChoice == 1) {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        } else if (posChoice == 2) {
            newNode.prev = tail;
            newNode.next = head;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        } else {
            Node current = head;
            for (int i = 1; i < posChoice - 1 && current.next != head; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
        traversal();
    }

    public void deletion(int posChoice) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else if (posChoice == 1) {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        } else if (posChoice == 2) {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        } else {
            Node current = head;
            for (int i = 1; i < posChoice - 1 && current.next != head; i++) {
                current = current.next;
            }
            if (current.next != head) {
                current.next = current.next.next;
                current.next.prev = current;
            } else {
                System.out.println("Position out of range.");
            }
        }
        traversal();
    }

    public void searching(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        int pos = 1;
        boolean found = false;

        do {
            if (current.data == value) {
                System.out.println("Value " + value + " found at position " + pos);
                found = true;
                break;
            }
            current = current.next;
            pos++;
        } while (current != head);

        if (!found)
            System.out.println("Value " + value + " not found.");
    }

    public void traversal() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        System.out.print("Doubly Circular List (forward): ");
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyCircularLinkedList dcll = new DoublyCircularLinkedList();
        dcll.handleOperation(1, 1, 10);
        dcll.handleOperation(1, 2, 20);
        dcll.handleOperation(1, 2, 30);
        dcll.handleOperation(4, 0, 0);
        dcll.handleOperation(2, 2, 0);
        dcll.handleOperation(4, 0, 0);
    }
}
