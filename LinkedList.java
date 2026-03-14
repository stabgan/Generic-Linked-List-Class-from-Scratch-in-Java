import java.util.NoSuchElementException;

/**
 * A generic singly-linked list implementation built from scratch.
 *
 * @param <T> the type of elements held in this list
 */
class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList<T> {
    private Node<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Returns the number of elements in this list.
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns true if this list contains no elements.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Appends the specified element to the end of this list.
     */
    public void append(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            this.head = newNode;
        } else {
            Node<T> last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        size++;
    }

    /**
     * Displays all elements in the list.
     *
     * @throws NoSuchElementException if the list is empty
     */
    public void display() {
        if (this.head == null) {
            throw new NoSuchElementException("Cannot display: list is empty");
        }
        Node<T> current = this.head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println();
    }

    /**
     * Removes and discards the last element from the list.
     *
     * @throws NoSuchElementException if the list is empty
     */
    public void pop() {
        if (this.head == null) {
            throw new NoSuchElementException("Cannot pop: list is empty");
        }
        if (this.head.next == null) {
            // Single-element list
            this.head = null;
        } else {
            Node<T> secondToLast = this.head;
            while (secondToLast.next.next != null) {
                secondToLast = secondToLast.next;
            }
            secondToLast.next = null;
        }
        size--;
    }

    /**
     * Deletes the element at the specified index (0-based).
     *
     * @param index the index of the element to remove
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                "Index " + index + " out of bounds for list of size " + size);
        }
        if (index == 0) {
            this.head = this.head.next;
        } else {
            int count = 1;
            Node<T> current = this.head;
            while (current != null) {
                if (count == index) {
                    current.next = current.next.next;
                    break;
                }
                current = current.next;
                count++;
            }
        }
        size--;
    }

    /**
     * Inserts the specified element at the beginning of this list.
     */
    public void insertAtBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = this.head;
        this.head = newNode;
        size++;
    }

    /**
     * Removes all elements from this list.
     */
    public void clear() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Returns a string representation of the list.
     */
    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = this.head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // Append elements
        list.append(5);
        list.append(50);
        list.append(55);
        list.append(505);
        System.out.println("After appending 5, 50, 55, 505:");
        list.display();

        // Append another element
        list.append(100);
        System.out.println("After appending 100:");
        list.display();

        // Pop last element and delete index 1
        list.pop();
        list.delete(1);
        System.out.println("After pop() and delete(1):");
        list.display();

        // Insert at beginning
        list.insertAtBeginning(88);
        System.out.println("After insertAtBeginning(88):");
        list.display();

        // toString demo
        System.out.println("toString: " + list);

        // Clear and rebuild
        list.clear();
        list.append(4);
        System.out.println("After clear() and append(4):");
        list.display();

        // Demonstrate exception handling on empty list
        list.clear();
        try {
            list.pop();
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        // Demonstrate out-of-bounds delete
        list.append(1);
        try {
            list.delete(5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        System.out.println("Size: " + list.size());
        System.out.println("Empty: " + list.isEmpty());
    }
}
