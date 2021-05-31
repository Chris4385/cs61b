package synthesizer;

import java.util.Iterator;


public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        fillCount = 0;
        this.capacity = capacity;
        first = capacity / 2 - 1;
        last = capacity / 2;
        rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    private int resetToFront(int last) {
        if (last > capacity - 1) {
            return 0;
        } else {
            return last;
        }

    }

    private int resetToBack(int first) {
        if (first < 0) {
            return capacity - 1;
        } else {
            return first;
        }

    }


    public void enqueue(T x) {
        if (!isFull()) {
            rb[last] = x;
            last = resetToFront(++last);
            fillCount++;
        } else {
            throw new RuntimeException("Ring Buffer Overflow");
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if (!isEmpty()) {
            first = resetToFront(++first);
            T returned = rb[first];
            fillCount--;
            return returned;
        } else {
            throw new RuntimeException("Ring Buffer Underflow");
        }
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (!isEmpty()) {
            int oriFirst = resetToFront(first + 1);
            return rb[oriFirst];
        } else {
            throw new RuntimeException("Ring buffer underflow");
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new GuitarIterator<>();
    }

    private class GuitarIterator<T> implements Iterator<T> {
        private int currPos;
        private int count;

        public GuitarIterator() {
            currPos = resetToFront(first + 1);
            count = 0;
        }

        @Override
        public boolean hasNext() {
            return count != capacity;
        }

        @Override
        public T next() {

            T returned = (T) rb[currPos];
            currPos = resetToFront(currPos + 1);
            count++;
            return returned;
        }
    }


}
