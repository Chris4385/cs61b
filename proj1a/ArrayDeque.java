public class ArrayDeque<Item> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private int initialArrSize = 8;

    private Item[] items;

    public ArrayDeque() {
        items = (Item[]) new Object[initialArrSize];
        size = 0;
        int mid = initialArrSize / 2;
        nextFirst = mid - 1;
        nextLast = mid;
    }

    public ArrayDeque(ArrayDeque<Item> other) {
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;
        size = other.initialArrSize;
        items = (Item[]) new Object[size];
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
        Item[] newItems = (Item[]) new Object[capacity];
        int originalSize = items.length;
        int remainingSpace = capacity - originalSize;
        initialArrSize = capacity;
        nextFirst = (remainingSpace / 2) - 1;
        nextLast = (remainingSpace / 2) + originalSize;
        System.arraycopy(items, 0, newItems, nextFirst + 1, originalSize);
        items = newItems;
    }

    private int maxArraySize(int x) {
        if (x == initialArrSize) {
            resizeCapacity(initialArrSize * 2);
        }
        return x + 1;
    }


    public void addLast(Item x) {
        //check the size and decide whether resizing is needed or not
        size = maxArraySize(size);
        items[nextLast] = x;
        nextLast = resetToFront(nextLast + 1);

    }

    public void addFirst(Item x) {
        //check the size and decide whether resizing is needed or not
        size = maxArraySize(size);
        items[nextFirst] = x;
        nextFirst = resetToEnd(nextFirst - 1);

    }

    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Item itemReturned = get(0);
        items[resetToFront(nextFirst + 1)] = null;
        nextFirst++;
        size--;
        return itemReturned;
    }

    public Item removeLast() {
        if (isEmpty()) {
            return null;
        }

        Item itemReturned = get(size);
        items[resetToEnd(nextLast - 1)] = null;
        nextLast--;
        size--;

//        T itemReturned = items[nextLast - 1];
//        items[nextLast - 1] = null;
//        size--;
//        nextLast--;
        return itemReturned;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public Item get(int index) {
        if (isEmpty()) {
            return null;
        }
        return items[resetToFront(index + nextFirst + 1)];

    }

    public static void main(String[] args) {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        L.addFirst(1);
        L.addFirst(2);
        L.addFirst(3);
        L.addFirst(4);
        L.addFirst(5);
        L.addFirst(6);

        L.addLast(100);
        L.addLast(200);
        L.addLast(300);
        L.addLast(400);
        L.addLast(500);

        L.addFirst(7);
        L.addFirst(8);
        L.addFirst(9);
        L.addFirst(10);
        L.addFirst(11);

        L.addLast(600);

        L.printDeque();

    }
}


