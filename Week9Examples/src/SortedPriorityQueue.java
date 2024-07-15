import java.util.Comparator;

public class SortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
  private PositionalList<Entry<K, V>> list = new LinkedPositionalList<>();

  public SortedPriorityQueue() {
    super();
  }

  public SortedPriorityQueue(Comparator<K> comp) {
    super(comp);
  }

  @Override
  public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
    checkKey(key);
    Entry<K, V> newest = new PQEntry<>(key, value);
    Position<Entry<K, V>> walk = list.last();
    while (walk != null && compare(newest, walk.getElement()) < 0)
      walk = list.before(walk);
    if (walk == null)
      list.addFirst(newest);
    else
      list.addAfter(walk, newest);
    return newest;
  }

  @Override
  public Entry<K, V> min() {
    if (list.isEmpty())
      return null;
    return list.first().getElement();
  }

  @Override
  public Entry<K, V> removeMin() {
    if (list.isEmpty())
      return null;
    return list.remove(list.first());
  }

  @Override
  public int size() {
    return list.size();
  }

  public static void main(String[] args) {
    SortedPriorityQueue<String, String> queue = new SortedPriorityQueue<>();
    queue.insert("5", "A");
    queue.insert("9", "C");
    queue.insert("9", "G");
    queue.insert("3", "B");

    for (Position<Entry<String, String>> walk : queue.list.positions())
      System.out.println("(" + walk.getElement().getKey() +
          ", " + walk.getElement().getValue() + ")");

    Position<Entry<String, String>> first = queue.list.first();
    System.out.println(first.getElement().getKey());

    System.out.println("Entry with minimal key: (" + queue.min().getKey() +
        ", " + queue.min().getValue() + ")");
  }
}
