package datastructures;

public class Queue {
    private final int MAX = 5;
    private int[] queue = new int[MAX];


    private int simpleFront = -1, simpleRear = -1;


    private int circularFront = -1, circularRear = -1;


    public void simpleEnqueue(int x) {
        if (simpleRear == MAX - 1) {
            System.out.println("Overflow (Simple Queue)");
        } else {
            if (simpleFront == -1) simpleFront = 0;
            queue[++simpleRear] = x;
        }
    }

    public void simpleDequeue() {
        if (simpleFront == -1 || simpleFront > simpleRear) {
            System.out.println("Underflow (Simple Queue)");
        } else {
            System.out.println("Removed: " + queue[simpleFront++]);
            if (simpleFront > simpleRear) simpleFront = simpleRear = -1;
        }
    }


    public void circularEnqueue(int x) {
        if ((circularRear + 1) % MAX == circularFront) {
            System.out.println("Overflow (Circular Queue)");
        } else {
            if (circularFront == -1) circularFront = 0;
            circularRear = (circularRear + 1) % MAX;
            queue[circularRear] = x;
        }
    }

    public void circularDequeue() {
        if (circularFront == -1) {
            System.out.println("Underflow (Circular Queue)");
        } else {
            System.out.println("Removed: " + queue[circularFront]);
            if (circularFront == circularRear) {
                circularFront = circularRear = -1;
            } else {
                circularFront = (circularFront + 1) % MAX;
            }
        }
    }
}