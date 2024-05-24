public class SinglyLinkedList<E> implements Cloneable {

  private static class Node<E> {

    private E element;
    private Node<E> next;

    public Node(E e, Node<E> n) {
      element = e;
      next = n;
    }

    public E getElement() {
      return element;
    }

    public Node<E> getNext() {
      return next;
    }

    public void setNext(Node<E> n) {
      next = n;
    }
  }

  private Node<E> head = null;
  private Node<E> tail = null;
  private int size = 0;

  public SinglyLinkedList() {
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public E first() {
    if (isEmpty())
      return null;
    return head.getElement();
  }

  public E last() {
    if (isEmpty())
      return null;
    return tail.getElement();
  }

  public void addFirst(E e) {
    head = new Node<>(e, head);
    if (size == 0)
      tail = head;
    size++;
  }

  public void addLast(E e) {
    Node<E> newest = new Node<>(e, null);
    if (isEmpty())
      head = newest;
    else
      tail.setNext(newest);
    tail = newest;
    size++;
  }

  public E removeFirst() {
    if (isEmpty())
      return null;
    E answer = head.getElement();
    head = head.getNext();
    size--;
    if (size == 0)
      tail = null;
    return answer;
  }

  @SuppressWarnings({ "unchecked" })
  public boolean equals(Object o) {
    if (o == null)
      return false;
    if (getClass() != o.getClass())
      return false;
    SinglyLinkedList other = (SinglyLinkedList) o;
    if (size != other.size)
      return false;
    Node walkA = head;
    Node walkB = other.head;
    while (walkA != null) {
      if (!walkA.getElement().equals(walkB.getElement()))
        return false;
      walkA = walkA.getNext();
      walkB = walkB.getNext();
    }
    return true;
  }

  @SuppressWarnings({ "unchecked" })
  public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
    SinglyLinkedList<E> other = (SinglyLinkedList<E>) super.clone();
    if (size > 0) {
      other.head = new Node<>(head.getElement(), null);
      Node<E> walk = head.getNext();
      Node<E> otherTail = other.head;
      while (walk != null) {
        Node<E> newest = new Node<>(walk.getElement(), null);
        otherTail.setNext(newest);
        otherTail = newest;
        walk = walk.getNext();
      }
    }
    return other;
  }

  public int hashCode() {
    int h = 0;
    for (Node walk = head; walk != null; walk = walk.getNext()) {
      h ^= walk.getElement().hashCode();
      h = (h << 5) | (h >>> 27);
    }
    return h;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder("(");
    Node<E> walk = head;
    while (walk != null) {
      sb.append(walk.getElement());
      if (walk != tail)
        sb.append(", ");
      walk = walk.getNext();
    }
    sb.append(")");
    return sb.toString();
  }

  private void removeLast() {
    Node walk = head;
    while (walk.getNext() != tail) {
      walk = walk.getNext();
    }
    tail = walk;
    walk.setNext(null);
    size--;
  }

  private boolean search(String string) {
    Node walk = head;
    boolean found = false;
    while (walk != null) {
      if (walk.getElement().equals(string)) {
        found = true;
      }
      walk = walk.getNext();
    }
    return found;
  }

  private void concatenate(SinglyLinkedList<String> list2) {
    Node walk = head;
    while (walk.next != null) {
      walk = walk.getNext();
    }
    walk.setNext(list2.head);
    size = this.size + list2.size;
    tail = (Node<E>) list2.tail;
  }

  public static void main(String[] args) {
    SinglyLinkedList<String> list1 = new SinglyLinkedList<String>();
    list1.addFirst("MSP");
    list1.addLast("ATL");
    list1.addLast("BOS");
    
    list1.addFirst("LAX");
    System.out.println(list1);
    list1.removeLast();
    System.out.println(list1);
    System.out.println(list1.search("LAM"));

    SinglyLinkedList<String> list2 = new SinglyLinkedList<String>();
    list2.addFirst("YYZ");
    list2.addFirst("YVR");
    System.out.println(list2);

    list1.concatenate(list2);
    System.out.println(list1);
  }
}
