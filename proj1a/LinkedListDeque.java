public class LinkedListDeque<Item> {

    private static class Node<Item> {
        private Node<Item> head;
        private Node<Item> tail;
        private Item data;

        public Node(Item input, Node<Item> prev, Node<Item> next) {
            data = input;
            head = prev;
            tail = next;
        }

    }

    private Node<Item> sentinelA;
    private Node<Item> sentinelB;
    private int size;

    public LinkedListDeque() {
        sentinelA = new Node<>(null, null, null);
        sentinelB = new Node<>(null, null, null);
        sentinelA.tail = sentinelB;
        sentinelB.head = sentinelA;
        size = 0;
    }

    public LinkedListDeque(Item item) {
        sentinelA = new Node<>(null, null, null);
        sentinelB = new Node<>(null, null, null);

        Node<Item> newData = new Node<>(item, sentinelA, sentinelB);
        sentinelA.tail = newData;
        sentinelB.head = newData;
        size = 1;

    }

    public LinkedListDeque(LinkedListDeque<Item> other) {
        this();
        int size = other.size();
        Node<Item> p = other.sentinelA.tail;

        for (int i = 0; i < size; i++) {

            this.addLast(p.data);
            p = p.tail;
        }
    }

    public void addFirst(Item item) {
        Node<Item> data = new Node<>(item, sentinelA, sentinelA.tail);
        sentinelA.tail = data;
        data.tail.head = data;
        size++;
    }

    public void addLast(Item item) {
        Node<Item> data = new Node<>(item, sentinelB.head, sentinelB);
        sentinelB.head = data;
        data.head.tail = data;
        size++;
    }
    

    public void printDeque() {
        Node<Item> p = sentinelA.tail;
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

    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<Item> firstNodeAfterDelete = sentinelA.tail.tail;
        sentinelA.tail = firstNodeAfterDelete;
        firstNodeAfterDelete.head = sentinelA;
        size--;
        return firstNodeAfterDelete.data;
    }

    public Item removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node<Item> lastNodeAfterDelete = sentinelB.head.head;
        sentinelB.head = lastNodeAfterDelete;
        lastNodeAfterDelete.tail = sentinelB;
        size--;
        return lastNodeAfterDelete.data;
    }

    public Item get(int index) {
        if (isEmpty()) {
            return null;
        }
        Node<Item> p = sentinelA;
        for (int i = 0; i <= index; i++) {
            if (i != index) {
                p = p.tail;
            }
        }
        return p.data;
    }

    private static <Item> Item getNodeRecursive(Node<Item> p, int index) {
        if (index == 1) {
            return p.data;
        } else {
            return getNodeRecursive(p.tail, index - 1);
        }

    }

    public Item getRecursive(int index) {
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
