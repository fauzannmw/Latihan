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

    public void addFirst(String input) {
        Node temp = new Node(input);
        if (this.isEmpty()) {
            head = tail = temp;
        } else {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
        size++;
    }

    public void addLast(String input) {
        Node temp = new Node(input);
        if (this.isEmpty()) {
            head = tail = temp;
        } else {
            temp.prev = tail;
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    public void insertBefore(String before, String x) {
        Node temp = new Node(x);
        Node input = head;
        while (input != null) {
            if (input.data.equals(before)) {
                if (input == head) {
                    this.addFirst(x);
                    break;
                } else {
                    temp.prev = input.prev;
                    temp.next = input;
                    input.prev.next = temp;
                    input.prev = temp;
                    size++;
                    break;
                }
            }
            input = input.next;
        }
    }
}
