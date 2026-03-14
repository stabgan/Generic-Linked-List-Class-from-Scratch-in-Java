
class Node<T> {
  T data;
  Node next;
  Node(T d) {
    this.data = d ;
    this.next = null;
  }
}

class LinkedList<T> {
  Node<T> head ;

  public void append(T d){
    if(head == null){
      this.head = new Node<T>(d);
    }
    else {
      Node<T> temp = new Node<T>(d);
      Node<T> last = this.head;
      while(last.next != null){
        last = last.next;
      }
      last.next = temp;
    }
  }

  public void display(){
    if(this.head == null){
    throw new java.lang.Error("Empty List");
    }
    else {
      Node<T> print = this.head;
      while(print != null){
      System.out.println(print.data);
      print = print.next;
      }
    }
    System.out.println("\n");
  }

  public void pop(){
    Node<T> demilast = this.head;
    if(this.head == null){
      throw new java.lang.Error("Empty List");
    }
    else {
      while(demilast.next.next != null){
        demilast = demilast.next;
      }
      demilast.next = null;
    }
  }

  public void delete(int i){
    try {
      if (i == 0){
        this.head = head.next;
      }
      else {
        int c = 1;
        Node count = this.head;
        while (count != null){
          if (c == i){
            count.next = count.next.next;
            break;
          }
          count = count.next;
          c++;
        }
      }
    }
    catch(Exception  e){
      throw new java.lang.Error("Wrong Index");
    }
  }

  public void insertAtBeginning(T d){
    Node<T> temp = new Node<T>(d);
    if (head == null){
      this.head = temp;
    }
    else {
      temp.next = this.head;
      temp.next.next = this.head.next;
      this.head = temp;
    }
  }

  public void clear(){
    this.head = null;
  }
}

class Main {
  public static void main(String[] args) {
    LinkedList<Integer> l = new LinkedList<>();
    l.append(5);
    l.append(50);
    l.append(55);
    l.append(505);
    l.display();
    l.append(100);
    l.display();
    l.pop();
    l.delete(1);
    l.display();
    l.insertAtBeginning(88);
    l.display();
    l.clear();
    l.append(4);
    l.display();
    l.clear();
    l.pop();

  }
}
