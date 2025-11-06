package datastructures;

public class Stack {
    private Node top = null;
    private int size = 0;

    class Node {
        int data;
        Node next;
        public Node(int d) {
            data = d;
            next = null;
        }
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
        display();
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Popped: " + top.data);
        top = top.next;
        size--;
        display();
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Top element: " + top.data);
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack: ");
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
}
}