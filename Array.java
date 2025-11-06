package datastructures;


public class Array {
    private static final int MAX_CAPACITY = 10;
    private int[] arr;
    private int currentSize;

    public Array() {
        this.arr = new int[MAX_CAPACITY];
        this.currentSize = 0;
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
            default:
                System.out.println("Invalid array operation choice.");
        }
    }

    public void insertion(int posChoice, int value) {
        if (currentSize >= MAX_CAPACITY) {
            System.out.println("Error: Array is full (Max " + MAX_CAPACITY + "). Cannot insert.");
            return;
        }

        int pos = 0;

        if (posChoice == 1) {
            pos = 0;
        } else if (posChoice == 2) {
            pos = currentSize;
        } else {
            pos = posChoice - 1;
            if (pos < 0 || pos > currentSize) {
                System.out.println("Error: Specific position " + posChoice + " is out of bounds [1 to " + (currentSize + 1) + "].");
                return;
            }
        }

        for (int i = currentSize; i > pos; i--) {
            arr[i] = arr[i - 1];
        }

        arr[pos] = value;
        currentSize++;
        System.out.println("Successfully inserted " + value + " at position " + (pos + 1) + ".");
        traversal();
    }

    public void deletion(int posChoice) {
        if (currentSize == 0) {
            System.out.println("Error: Array is empty. Nothing to delete.");
            return;
        }

        int pos = 0;

        if (posChoice == 1) {
            pos = 0;
        } else if (posChoice == 2) {
            pos = currentSize - 1;
        } else {
            pos = posChoice - 1;
            if (pos < 0 || pos >= currentSize) {
                System.out.println("Error: Specific position " + posChoice + " is out of bounds [1 to " + currentSize + "].");
                return;
            }
        }

        int deletedValue = arr[pos];

        for (int i = pos; i < currentSize - 1; i++) {
            arr[i] = arr[i + 1];
        }

        currentSize--;
        System.out.println("Successfully deleted value " + deletedValue + " from position " + (pos + 1) + ".");
        traversal();
    }

    public void searching(int value) {
        boolean found = false;
        for (int i = 0; i < currentSize; i++) {
            if (arr[i] == value) {
                System.out.println("Value " + value + " found at position " + (i + 1) + " (1-based index).");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Value " + value + " not found in the array.");
        }
    }

    public void traversal() {
        if (currentSize == 0) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.print("Current Array (" + currentSize + "/" + MAX_CAPACITY + "): [");
        for (int i = 0; i < currentSize; i++) {
            System.out.print(arr[i] + (i < currentSize - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
