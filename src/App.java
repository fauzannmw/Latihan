import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        LinkedList[] tmp = new LinkedList[2];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = new LinkedList();
        }

        String[] inputanUtama = new String[1];
        boolean ancur = true;
        int countinput = 0;

        while (ancur) {
            String awal = input.nextLine();
            String perintah = awal;

            inputanUtama[countinput] = perintah;

            if (awal.isEmpty() == true) {
                ancur = false;
            } else {
                countinput++;

                String[] oldArray = inputanUtama;
                inputanUtama = new String[oldArray.length + 1];
                System.arraycopy(oldArray, 0, inputanUtama, 0, oldArray.length);
            }
        }
        for (int i = 0; i < countinput; i++)
        // while(ancur)
        {
            String inputan = inputanUtama[i];
            String[] perintah = inputan.split(" ");
            switch (perintah[0].toLowerCase()) {
            case "tambah":
                tmp[Integer.parseInt(perintah[2]) - 1].addLast(perintah[3].toUpperCase());
                break;
            case "cetak":
                String coba = perintah[1].substring(6, 7);
                tmp[Integer.parseInt(coba) - 1].print();
                break;
            case "cetak_beda":
                String asal = perintah[1].substring(6, 7);
                String tujuan = perintah[2].substring(6, 7);

                int penunjuk = Integer.parseInt(asal);
                int penunjuk1 = Integer.parseInt(tujuan);

                String[] temp = tmp[penunjuk - 1].toArray();
                String[] temp1 = tmp[penunjuk1 - 1].toArray();

                for (int j = 0; j < temp.length; j++) {
                    int akhir = 0;
                    for (int k = 0; k < temp1.length; k++) {
                        if (temp[j].equals(temp1[k])) {
                        } else {
                            akhir++;
                        }
                    }
                    if (akhir == temp1.length) {
                        System.out.println("BEDA DAFTAR" + penunjuk + ": " + temp[j]);
                    }
                }

                break;
            }
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

    public String[] toArray() {
        Node p = head;
        String[] array = new String[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = p.data;
            p = p.next;
        }
        return array;
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
