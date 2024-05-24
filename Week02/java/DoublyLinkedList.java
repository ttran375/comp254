public class DoublyLinkedList<E> {
  private static class Node<E> {
    private E element;
    private Node<E> prev;
    private Node<E> next;

    public Node(E e, Node<E> p, Node<E> n) {
      element = e;
      prev = p;
      next = n;
    }

    public E getElement() {
      return element;
    }

    public Node<E> getPrev() {
      return prev;
    }

    public Node<E> getNext() {
      return next;
    }

    public void setPrev(Node<E> p) {
      prev = p;
    }

    public void setNext(Node<E> n) {
      next = n;
    }
  }

  private Node<E> header;
  private Node<E> trailer;
  private int size = 0;

  public DoublyLinkedList() {
    header = new Node<>(null, null, null);
    trailer = new Node<>(null, header, null);
    header.setNext(trailer);
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
    return header.getNext().getElement();
  }

  public E last() {
    if (isEmpty())
      return null;
    return trailer.getPrev().getElement();
  }

  public void addFirst(E e) {
    addBetween(e, header, header.getNext());
  }

  public void addLast(E e) {
    addBetween(e, trailer.getPrev(), trailer);
  }

  public E removeFirst() {
    if (isEmpty())
      return null;
    return remove(header.getNext());
  }

  public E removeLast() {
    if (isEmpty())
      return null;
    return remove(trailer.getPrev());
  }

  private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
    Node<E> newest = new Node<>(e, predecessor, successor);
    predecessor.setNext(newest);
    successor.setPrev(newest);
    size++;
  }

  private E remove(Node<E> node) {
    Node<E> predecessor = node.getPrev();
    Node<E> successor = node.getNext();
    predecessor.setNext(successor);
    successor.setPrev(predecessor);
    size--;
    return node.getElement();
  }

  public String toString() {
    StringBuilder sb = new StringBuilder("(");
    Node<E> walk = header.getNext();
    while (walk != trailer) {
      sb.append(walk.getElement());
      walk = walk.getNext();
      if (walk != trailer)
        sb.append(", ");
    }
    sb.append(")");
    return sb.toString();
  }

  public static void main(String[] args) {
    DoublyLinkedList<String> list1 = new DoublyLinkedList<String>();
    list1.addFirst("MSP");
    list1.addLast("ATL");
    list1.addLast("BOS");
    //
    list1.addFirst("LAX");
    System.out.println(list1);

    DoublyLinkedList<String> list2 = new DoublyLinkedList<String>();
    list2.addFirst("YYZ");
    list2.addLast("YVR");
    System.out.println(list2);
    list1.concatenate(list2);
    // System.out.println(list.first());
    //
  }

  private void concatenate(DoublyLinkedList<String> list2) {
    // TODO Auto-generated method stub
    trailer.prev.setNext((Node<E>) list2.header.next);
    list2.header.next.setPrev((Node<String>) trailer.getPrev());
    trailer = (Node<E>) list2.trailer;
  }
}
