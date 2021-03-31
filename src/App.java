public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}

class Node {
    String data;
    Node next, prev;

    public Node(String data) {
        this.data = data;
    }

    public Node(String data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class LinkedList {
    Node head;
    Node tail;
    int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public void makeEmpty() {
        head = tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void addFirst(String node) {
        Node input = new Node(node);
        if (this.isEmpty()) {
            head = tail = input;
        } else {
            input.next = head;
            head.prev = input;
            head = input;
        }
        size++;
    }

    public void addLast(String input) {
        Node tmp = new Node(input);
        if (isEmpty()) {
            tmp.prev = tmp.next = tmp;
            head = tail = tmp;
        } else {
            tmp.prev = tail;
            tmp.next = head;
            tail.next = tmp;
            tail = tmp;
        }
        size++;
    }
}
