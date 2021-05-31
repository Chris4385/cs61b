// TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;

import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
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
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        fillCount = 0;
        this.capacity = capacity;
        first = capacity / 2 - 1;
        last = capacity / 2;
        rb = (T[]) new Object[capacity];
    }

    @Override
    public Iterator<T> iterator() {
        return new GuitarIterator<>();
    }

    private class GuitarIterator<T> implements Iterator<T> {
        private int currPos;

        public GuitarIterator() {
            currPos = 0;
        }

        @Override
        public boolean hasNext() {
            return currPos < capacity;
        }

        @Override
        public T next() {

            T returned = (T) rb[currPos];
            currPos++;

            return returned;
        }
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    private int resetToFront(int last) {
        if (last > capacity - 1) {
            return 0;
        } else return last;
    }

    private int resetToBack(int first) {
        if (first < 0) {
            return capacity - 1;
        } else return first;

    }


    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (!isFull()) {
            rb[last] = x;
            last = resetToFront(++last);
            fillCount++;
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        if (!isEmpty()) {
            first = resetToBack(++first);
            T returned = rb[first];
            rb[first] = null;
            fillCount--;
            return returned;
        } else {
            throw new RuntimeException("Ring buffer underflow");
        }
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        first = resetToBack(++first);
        return rb[first];
    }


    // TODO: When you get to part 5, implement the needed code to support iteration.
}
