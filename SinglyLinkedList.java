package datastructures;

public class SinglyLinkedList {
    Node head = null;

    class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
            next = null;
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

        if (posChoice == 1) {
            newNode.next = head;
            head = newNode;
        } else if (posChoice == 2) {
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }

        } else {
            Node current = head;
            for (int i = 1; i < posChoice - 1 && current != null; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        traversal();
    }

    public void deletion(int posChoice) {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }
        if (posChoice == 1) {
            Node temp = head;
            head = head.next;
            temp = null;
        } else if (posChoice == 2) {
            if (head.next == null) {

                head = null;
            } else {
                Node current = head;
                while (current.next.next != null) {
                    current = current.next;
                }
                current.next = null;
            }
        } else {
            Node current = head;

            for (int i = 1; i < posChoice - 1 && current.next != null; i++) {
                current = current.next;
            }
            if (current.next != null) {
                current.next = current.next.next;
            } else {
                System.out.println("Position out of bounds.");
            }

        }
        traversal();
    }

    public void searching(int value) {

        Node current = head;
        int position = 1;
        boolean found = false;

        while (current != null) {
            if (current.data == value) {
                System.out.println("Value " + value + " found at position " + position);
                found = true;
                break;
            }
            current = current.next;
            position++;
        }

        if (!found) {
            System.out.println("Value " + value + " not found in the list.");
        }
    }



    public void traversal() {
        Node current = head;

        if (current == null) {
            System.out.println("The list is empty.");
            return;
        }

        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
}

}