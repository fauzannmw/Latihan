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

    public void insertBefore(String before, String node) {
        Node input = new Node(node);
        Node temp = head;
        while (temp != null) {
            if (temp.data.equals(before)) {
                if (temp == head) {
                    this.addFirst(node);
                    break;
                } else {
                    input.prev = temp.prev;
                    input.next = temp;
                    temp.prev.next = input;
                    temp.prev = input;
                    size++;
                    break;
                }
            }
            input = input.next;
        }
    }

    public void insertAfter(String after, String x) {
        Node temp = new Node(x);
        Node input = head;
        while (input != null) {
            if (input.data.equals(after)) {
                if (input == tail) {
                    this.addLast(x);
                    break;
                }
                if (input.next == null) {
                    input.next = tail = temp;
                    size++;
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

    public void print() {
        Node p = head;
        for (int i = 0; i < size; i++) {
            System.out.print(p.data);
            if (p.next != null) {
                System.out.print(" -- ");
            }
            p = p.next;
        }
        System.out.println();
    }
}
