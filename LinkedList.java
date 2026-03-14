class Node<T> {
    T data;
    Node<T> next;

    Node(T d) {
        this.data = d;
        this.next = null;
    }
}

class LinkedList<T> {
    Node<T> head;

    /** Append data at the end of the list. */
    public void append(T d) {
        Node<T> temp = new Node<>(d);
        if (head == null) {
            this.head = temp;
        } else {
            Node<T> last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = temp;
        }
    }

    /** Display all elements in the list. */
    public void display() {
        if (this.head == null) {
            throw new IllegalStateException("Empty List");
        }
        Node<T> current = this.head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println();
    }

    /** Remove the last element from the list. */
    public void pop() {
        if (this.head == null) {
            throw new IllegalStateException("Empty List");
        }
        if (this.head.next == null) {
            this.head = null;
            return;
        }
        Node<T> secondToLast = this.head;
        while (secondToLast.next.next != null) {
            secondToLast = secondToLast.next;
        }
        secondToLast.next = null;
    }

    /** Delete the element at the given index. */
    public void delete(int index) {
        if (this.head == null) {
            throw new IllegalStateException("Empty List");
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException("Negative index: " + index);
        }
        if (index == 0) {
            this.head = this.head.next;
            return;
        }
        int count = 1;
        Node<T> current = this.head;
        while (current.next != null) {
            if (count == index) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
            count++;
        }
        throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
    }

    /** Insert data at the beginning of the list. */
    public void insertAtBeginning(T d) {
        Node<T> temp = new Node<>(d);
        temp.next = this.head;
        this.head = temp;
    }

    /** Remove all elements from the list. */
    public void clear() {
        this.head = null;
    }
}

class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.append(5);
        list.append(50);
        list.append(55);
        list.append(505);
        System.out.println("--- After appending 5, 50, 55, 505 ---");
        list.display();

        list.append(100);
        System.out.println("--- After appending 100 ---");
        list.display();

        list.pop();
        list.delete(1);
        System.out.println("--- After pop() and delete(1) ---");
        list.display();

        list.insertAtBeginning(88);
        System.out.println("--- After insertAtBeginning(88) ---");
        list.display();

        list.clear();
        list.append(4);
        System.out.println("--- After clear() and append(4) ---");
        list.display();

        list.clear();
        try {
            list.pop();
        } catch (IllegalStateException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }
    }
}
