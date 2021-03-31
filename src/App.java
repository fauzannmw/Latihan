import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        LinkedList listSementara = new LinkedList();
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();


        while (true) {
            String inputanUser = input.nextLine();
            if (inputanUser.length() == 0) {
                break;
            }
            listSementara.addLast(inputanUser);
        }
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
            temp = temp.next;
        }
    }

    public void insertAfter(String after, String node) {
        Node input = new Node(node);
        Node temp = head;
        while (temp != null) {
            if (temp.data.equals(after)) {
                if (temp == tail) {
                    this.addLast(node);
                    break;
                }
                if (temp.next == null) {
                    temp.next = tail = input;
                    size++;
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
            temp = temp.next;
        }
    }

    public void print() {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" -- ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}
