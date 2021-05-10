public class LinkedListDeque<T> {

    private static class Node<T> {
        private Node<T> head;
        private Node<T> tail;
        private T data;

        public Node(T input, Node<T> prev, Node<T> next) {
            data = input;
            head = prev;
            tail = next;
        }

    }

    private Node<T> sentinelA;
    private Node<T> sentinelB;
    private int size;

    public LinkedListDeque() {
        sentinelA = new Node<>(null, null, null);
        sentinelB = new Node<>(null, null, null);
        sentinelA.tail = sentinelB;
        sentinelB.head = sentinelA;
        size = 0;
    }

    public LinkedListDeque(T item) {
        sentinelA = new Node<>(null, null, null);
        sentinelB = new Node<>(null, null, null);

        Node<T> newData = new Node<>(item, sentinelA, sentinelB);
        sentinelA.tail = newData;
        sentinelB.head = newData;
        size = 1;

    }

    public LinkedListDeque(LinkedListDeque<T> other) {
        this();
        int size = other.size();
        Node<T> p = other.sentinelA.tail;

        for (int i = 0; i < size; i++) {

            this.addLast(p.data);
            p = p.tail;
        }
    }

    public void addFirst(T item) {
        Node<T> data = new Node<>(item, sentinelA, sentinelA.tail);
        sentinelA.tail = data;
        data.tail.head = data;
        size++;
    }

    public void addLast(T item) {
        Node<T> data = new Node<>(item, sentinelB.head, sentinelB);
        sentinelB.head = data;
        data.head.tail = data;
        size++;
    }


    public void printDeque() {
        Node<T> p = sentinelA.tail;
        for (int i = 0; i < size; i++) {
            System.out.println(p.data);
            p = p.tail;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<T> deletedNode = sentinelA.tail;

        Node<T> firstNodeAfterDelete = sentinelA.tail.tail;
        sentinelA.tail = firstNodeAfterDelete;
        firstNodeAfterDelete.head = sentinelA;
        size--;
        return deletedNode.data;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node<T> deletedNode = sentinelB.head;
        Node<T> lastNodeAfterDelete = sentinelB.head.head;
        sentinelB.head = lastNodeAfterDelete;
        lastNodeAfterDelete.tail = sentinelB;
        size--;
        return deletedNode.data;
    }

    public T get(int index) {
        if (isEmpty()) {
            return null;
        }
        Node<T> p = sentinelA.tail;
        for (int i = 0; i <= index; i++) {
            if (i != index) {
                p = p.tail;
            }
        }
        return p.data;
    }

    private static <Item> Item getNodeRecursive(Node<Item> p, int index) {
        if (index == 0) {
            return p.data;
        } else {
            return getNodeRecursive(p.tail, index - 1);
        }

    }

    public T getRecursive(int index) {
        if (isEmpty()) {
            return null;
        }
        return getNodeRecursive(sentinelA.tail, index);


    }


//    public static void main(String[] args) {
//        LinkedListDeque<Integer> LL = new LinkedListDeque<>(100);
//        LL.addLast(200);
//        LL.addLast(300);
//        LL.addFirst(150);
//        LL.addFirst(1000);
//
//        int a = LL.getRecursive(1);
//        System.out.println("First item is: " + a + " and its total size is: " + LL.size());
//    }

}
