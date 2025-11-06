package datastructures;

import java.util.Scanner;

public class CombinedSimulatorWithCircular{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dsChoice, opChoice, posChoice, circularType;
        boolean exit = false;
        Array array = new Array();
        SinglyLinkedList sll = new SinglyLinkedList();
        DoublyLinkedList dll = new DoublyLinkedList();
        SinglyCircularLinkedList scll = new SinglyCircularLinkedList();
        DoublyCircularLinkedList dcll = new DoublyCircularLinkedList();
        Queue queue = new Queue();
        Stack stack = new Stack();

        while (!exit) {
            System.out.println("\nChoose Data Structure:");
            System.out.println("1. Array");
            System.out.println("2. Singly Linked List");
            System.out.println("3. Doubly Linked List");
            System.out.println("4. Circular Linked List");
            System.out.println("5. Queue");
            System.out.println("6. Stack");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            dsChoice = sc.nextInt();

            if (dsChoice == 7) break;

            if (dsChoice == 4) {
                System.out.println("Choose Circular Type:");
                System.out.println("1. Singly Circular Linked List");
                System.out.println("2. Doubly Circular Linked List");
                System.out.print("Enter choice: ");
                circularType = sc.nextInt();
            } else {
                circularType = 0;
            }

            if (dsChoice >= 1 && dsChoice <= 4) {
                System.out.println("Choose Operation:");
                System.out.println("1. Insertion");
                System.out.println("2. Deletion");
                System.out.println("3. Searching");
                System.out.println("4. Traversal");
                System.out.print("Enter operation: ");
                opChoice = sc.nextInt();

                if (opChoice == 1 || opChoice == 2) {
                    System.out.println("Choose Position:");
                    System.out.println("1. At Start");
                    System.out.println("2. At End");
                    System.out.println("3. At Specific Position");
                    System.out.print("Enter position choice: ");
                    posChoice = sc.nextInt();
                } else {
                    posChoice = 0;
                }

                int value = 0;
                // insertion and searching require a value
                if (opChoice == 1 || opChoice == 3) {
                    System.out.print("Enter value (if needed): ");
                    value = sc.nextInt();
                }

                switch (dsChoice) {
                    case 1:
                        array.handleOperation(opChoice, posChoice, value);
                        break;
                    case 2:
                        sll.handleOperation(opChoice, posChoice, value);
                        break;
                    case 3:
                        dll.handleOperation(opChoice, posChoice, value);
                        break;
                    case 4:
                        // Circular lists
                        if (circularType == 1) {
                            scll.handleOperation(opChoice, posChoice, value);
                        } else if (circularType == 2) {
                            dcll.handleOperation(opChoice, posChoice, value);
                        } else {
                            System.out.println("Invalid circular list type.");
                        }
                        break;
                    default:
                        System.out.println("Invalid data structure choice.");
                }

            } else if (dsChoice == 5) {
                System.out.println("Choose Queue Type:");
                System.out.println("1. Simple Queue");
                System.out.println("2. Circular Queue");
                System.out.print("Enter queue type: ");
                int queueType = sc.nextInt();

                System.out.println("Choose Operation:");
                System.out.println("1. Enqueue");
                System.out.println("2. Dequeue");
                System.out.print("Enter queue operation: ");
                int queueOp = sc.nextInt();
                int value = 0;
                if (queueOp == 1) {
                    System.out.print("Enter value to enqueue: ");
                    value = sc.nextInt();
                }
                switch (queueType) {
                    case 1:
                        switch (queueOp) {
                            case 1:
                                queue.simpleEnqueue(value);
                                break;
                            case 2:
                                queue.simpleDequeue();
                                break;
                            default:
                                System.out.println("Invalid operation for Simple Queue.");
                        }
                        break;

                    case 2:
                        switch (queueOp) {
                            case 1:
                                queue.circularEnqueue(value);
                                break;
                            case 2:
                                queue.circularDequeue();
                                break;
                            default:
                                System.out.println("Invalid operation for Circular Queue.");
                        }
                        break;

                    default:
                        System.out.println("Invalid queue type.");
                }

            } else if (dsChoice == 6) {
                System.out.println("Choose Stack Operation:");
                System.out.println("1. Push");
                System.out.println("2. Pop");
                System.out.println("3. Peek");
                System.out.println("4. Display");
                System.out.println("5. Check if Empty");
                System.out.println("6. Size");
                System.out.print("Enter stack operation: ");
                int stackOp = sc.nextInt();

                switch (stackOp) {
                    case 1:
                        System.out.print("Enter value to push: ");
                        int val = sc.nextInt();
                        stack.push(val);
                        break;
                    case 2:
                        stack.pop();
                        break;
                    case 3:
                        stack.peek();
                        break;
                    case 4:
                        stack.display();
                        break;
                    case 5:
                        System.out.println("Is Empty: " + stack.isEmpty());
                        break;
                    case 6:
                        System.out.println("Size: " + stack.size());
                        break;
                    default:
                        System.out.println("Invalid stack operation.");
                }
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
        System.out.println("Exiting Data Structure Simulator. Goodbye!");
    }
}
