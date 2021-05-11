public class ArrayDeque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private int initialArrSize = 8;

    private T[] items;

    public ArrayDeque() {
        items = (T[]) new Object[initialArrSize];
        size = 0;
        int mid = initialArrSize / 2;
        nextFirst = mid - 1;
        nextLast = mid;
    }

    public ArrayDeque(ArrayDeque<T> other) {
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;
        size = other.initialArrSize;
        items = (T[]) new Object[size];
        System.arraycopy(other.items, 0, items, 0, size);

    }

    //if the index reaches the max limit of the array size, reset the index into 0
    private int resetToFront(int x) {
        if (x >= initialArrSize) {
            return x - initialArrSize;
        } else {
            return x;
        }
    }

    //if the index reaches the lower limit of 0, reset the index into array size

    private int resetToEnd(int x) {
        if (x < 0) {
            return initialArrSize - 1;
            /** because intialArrSize is 8, but index starts from 0 to 7 so the max index is 7 */
        } else {
            return x;
        }
    }

    private void resizeCapacity(int capacity) {


        T[] newItems = (T[]) new Object[capacity];
        int originalSize = items.length;
        int remainingSpace = capacity - originalSize;
        int newNextFirst = (remainingSpace / 2) - 1;
        int newNextLast = (remainingSpace / 2) + originalSize;
        int resetNextFirst = resetToFront(nextFirst + 1);
        System.arraycopy(items, resetNextFirst, newItems, newNextFirst + 1, originalSize - nextLast);
        System.arraycopy(items, 0, newItems, newNextFirst + 1 + originalSize - nextLast, nextLast);
        initialArrSize = capacity;
        nextFirst = newNextFirst;
        nextLast = newNextLast;
        items = newItems;
    }

    public void resizeDown(int capacity) {
        T[] newItems = (T[]) new Object[capacity];

        int originalSize = items.length;
        int remainingSpace = capacity - size;
        int newNextFirst = (remainingSpace / 2);
        int newNextLast = (remainingSpace / 2) + size + 1;
        int resetNextFirst = resetToFront(nextFirst + 1);
        System.arraycopy(items, resetNextFirst, newItems, newNextFirst + 1, size);
//        System.arraycopy(items, 0, newItems, newNextFirst + 1 + capacity - nextLast, nextLast);
        initialArrSize = capacity;
        nextFirst = newNextFirst;
        nextLast = newNextLast;
        items = newItems;
    }

    private int maxArraySize(int x) {
        if (x == initialArrSize) {
            resizeCapacity(initialArrSize * 2);
        }
        return x;
    }


    public void addLast(T x) {
        //check the size and decide whether resizing is needed or not

        items[nextLast] = x;
        nextLast = resetToFront(nextLast + 1);
        size = maxArraySize(size + 1);

    }

    public void addFirst(T x) {
        //check the size and decide whether resizing is needed or not
        items[nextFirst] = x;
        nextFirst = resetToEnd(nextFirst - 1);
        size = maxArraySize(size + 1);

    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T itemReturned = get(0);
        nextFirst = resetToFront(nextFirst + 1);
        items[nextFirst] = null;
        size--;
        if (resizeDownNeeded()) {
            resizeDown(initialArrSize / 2);
        }
        return itemReturned;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T itemReturned = get(size - 1);
        nextLast = resetToEnd(nextLast - 1);
        items[nextLast] = null;
        size--;
        if (resizeDownNeeded()) {
            resizeDown(initialArrSize / 2);
        }

        return itemReturned;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean resizeDownNeeded() {
        double usageRatio = (double) size / initialArrSize;
        return initialArrSize >= 16 && usageRatio < 0.25;
    }

    public void printDeque() {
        for (T item : items) {
            System.out.println(item);
        }
    }

    public T get(int index) {
        if (isEmpty()) {
            return null;
        }
        return items[resetToFront(index + nextFirst + 1)];

    }


    public static void main(String[] args) {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque<>();
//        ArrayDeque.addFirst(0);
//        ArrayDeque.addLast(1);
//        ArrayDeque.addLast(2);
//        ArrayDeque.addFirst(3);
//        ArrayDeque.addLast(4);
//        ArrayDeque.addFirst(5);
//        ArrayDeque.get(1);
//        ArrayDeque.removeFirst();
//        ArrayDeque.addLast(8);
//        ArrayDeque.addLast(9);
//        ArrayDeque.addLast(10);
//        ArrayDeque.removeFirst();
//        ArrayDeque.removeLast();
//        ArrayDeque.get(2);
//        ArrayDeque.removeFirst();
//        ArrayDeque.removeFirst();
//        ArrayDeque.get(3);
//        ArrayDeque.get(2);
//        ArrayDeque.addLast(18);
//        ArrayDeque.removeFirst();
//        ArrayDeque.removeFirst();
//        ArrayDeque.get(2);

//        ArrayDeque.addFirst(0);
//        ArrayDeque.removeLast();
//        ArrayDeque.addFirst(2);
//        ArrayDeque.addFirst(3);
//        ArrayDeque.addFirst(4);
//        ArrayDeque.addLast(5);
//        ArrayDeque.removeLast();
//        ArrayDeque.get(0);
//        ArrayDeque.addLast(8);
//        ArrayDeque.addLast(9);
//        ArrayDeque.addFirst(10);
//        ArrayDeque.addFirst(11);
//        ArrayDeque.addFirst(12);
//        ArrayDeque.removeFirst();
//        ArrayDeque.removeLast();
//        ArrayDeque.removeFirst();
//        ArrayDeque.removeLast();
//        ArrayDeque.removeFirst();
//        ArrayDeque.removeLast();
//        ArrayDeque.addFirst(19);
//        ArrayDeque.removeFirst();
//        ArrayDeque.get(0);
//        ArrayDeque.addLast(22);
//        ArrayDeque.removeLast();

        ArrayDeque.addFirst(1);
        ArrayDeque.addFirst(2);
        ArrayDeque.addFirst(3);
        ArrayDeque.addFirst(4);
        ArrayDeque.addFirst(5);
        ArrayDeque.addFirst(6);
        ArrayDeque.addFirst(7);
        ArrayDeque.addFirst(8);

        ArrayDeque.removeFirst();
        ArrayDeque.removeFirst();
        ArrayDeque.removeFirst();
        ArrayDeque.removeFirst();
        ArrayDeque.removeFirst();
        ArrayDeque.removeFirst();
        ArrayDeque.removeFirst();
        ArrayDeque.removeFirst();
//        ArrayDeque.addFirst(8);
//        ArrayDeque.addFirst(9);
//        ArrayDeque.addFirst(10);
//        ArrayDeque.addFirst(11);
//        ArrayDeque.addFirst(12);
//        ArrayDeque.addFirst(13);
//        ArrayDeque.addFirst(14);
    }
}


