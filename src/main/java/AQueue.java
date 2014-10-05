/**
 * This is an generic Queue implementation using a circular array.
 * This class has been optimized for algorithmic runtime, memory usage,
 * and memory throughput.
 *
 * An array based implementation of a Queue has been used over a linked list
 * implementation of a Queue to optimize memory usage. Since the Queue will
 * be holding small elements(4 byte integers) and the constructor requires
 * a size we can assume the purpose of this bounded Queue is to store
 * a known max size of integers. Without the pointers used in a linked list
 * Queue this array based Queue is more space efficient if the maxSize
 * of the Queue is known initially.
 *
 * @author Quinn Liu(quinnliu@vt.edu)
 */
public class AQueue<E> {
    private static final int DEFAULT_SIZE = 10;
    private int maxSize;
    private int frontElementIndex;
    private int rearElementIndex;
    private E circularArray[];

    /**
     * @param maxSize The maximum number of elements this queue can hold.
     */
    AQueue(int maxSize) {
        this.maxSize = maxSize+1;
        this.rearElementIndex = 0;
        this.frontElementIndex = 1;
        this.circularArray = (E[]) new Object[this.maxSize];
    }

    AQueue() { this(DEFAULT_SIZE); }

    /**
     * @param element Element to add to the queue if not full.
     * @return True is element is added to queue.
     * @throws java.lang.IllegalStateException If queue is full.
     */
    boolean enqueue(E element) {
        if (((rearElementIndex +2) % maxSize) == frontElementIndex) {
            throw new IllegalStateException("Bounded queue is full at size = "
                    + this.length() + ". Call dequeue() before recalling " +
                    "enqueue()");
        }
        rearElementIndex = (rearElementIndex +1) % maxSize; // Circular increment
        circularArray[rearElementIndex] = element;
        return true;
    }

    /**
     * @return Remove and return element at front of queue.
     * @throws java.lang.IllegalStateException If queue is empty.
     */
    E dequeue() {
        if(length() == 0) {
            throw new IllegalStateException("Bounded queue is currently empty. "
                    + "Call enqueue() before dequeue()");
        }
        E element = circularArray[frontElementIndex];
        frontElementIndex = (frontElementIndex +1) % maxSize; // Circular increment
        return element;
    }

    /**
     * @return The front element or null if queue is empty.
     */
    E frontValue() {
        if (length() == 0) {
            return null;
        } else {
            return circularArray[frontElementIndex];
        }
    }

    /**
     * @return Number of elements in queue.
     */
    int length() {
        return ((rearElementIndex + maxSize) - frontElementIndex + 1) % maxSize;
    }

    /**
     * Remove all elements in Queue.
     */
    void clear() {
        rearElementIndex = 0;
        frontElementIndex = 1;
    }
}