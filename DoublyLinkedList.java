package datastructures;

public class DoublyLinkedList {
    Node head = null;
    Node tail = null; // Adding a tail pointer for efficiency

    class Node {
        int data;
        Node prev; // New: Pointer to the previous node
        Node next;

        public Node(int d) {
            data = d;
            prev = null;
            next = null;
        }
    }

    // --- Core Operations (Using the same structure as the original) ---

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
            default:
                System.out.println("Invalid operation choice.");
        }
    }

    public void insertion(int posChoice, int value) {
        Node newNode = new Node(value);

        if (head == null) {
            // Case: List is empty
            head = newNode;
            tail = newNode;
            traversal();
            return;
        }

        if (posChoice == 1) {
            // Case 1: Insert at the beginning
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (posChoice == 2) {
            // Case 2: Insert at the end
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            // Case 3: Insert at Nth position
            Node current = head;
            // Traverse to the node *before* the insertion point (posChoice - 1)
            for (int i = 1; i < posChoice - 1 && current != null; i++) {
                current = current.next;
            }

            if (current == null || current.next == null && posChoice > 2) {
                System.out.println("Position out of bounds for middle insertion. Appending instead.");
                insertion(2, value); // Fallback to end insertion
                return;
            }

            // Standard insertion between current and current.next
            newNode.next = current.next;
            newNode.prev = current;

            if (current.next != null) {
                current.next.prev = newNode;
            } else {

                tail = newNode;
            }
            current.next = newNode;
        }
        traversal();
    }

    public void deletion(int posChoice) {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        if (head == tail) {
            // Only one node in the list
            head = null;
            tail = null;
            traversal();
            return;
        }

        if (posChoice == 1) {
            // Case 1: Delete from the beginning
            head = head.next;
            if (head != null) {
                head.prev = null; // ❗ Doubly Linked List update: New head has no previous
            }
        } else if (posChoice == 2) {
            // Case 2: Delete from the end
            tail = tail.prev;
            if (tail != null) {
                tail.next = null; // Sever the forward link
            }
        } else {
            // Case 3: Delete from Nth position
            Node current = head;
            // Traverse to the node *to be deleted*
            for (int i = 1; i < posChoice && current != null; i++) {
                current = current.next;
            }

            if (current == null) {
                System.out.println("Position out of bounds.");
                return;
            }

            // Standard deletion (Bypass 'current')
            if (current.prev != null) {
                current.prev.next = current.next;
            }
            if (current.next != null) {
                current.next.prev = current.prev;
            } else {
                // If the deleted node was the tail, update the tail pointer
                tail = current.prev;
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

        System.out.print("Linked List (Forward): ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
