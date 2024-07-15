import java.util.Comparator;
import java.util.Date;

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
        // Create a comparator for Dates
        Comparator<Date> dateComparator = Comparator.naturalOrder();

        // Create a SortedPriorityQueue with the Date comparator
        SortedPriorityQueue<Date, Employee> queue = new SortedPriorityQueue<>(dateComparator);

        // Create Employee instances
        Employee emp1 = new Employee("John Doe", "123-45-6789", new Date(120, 5, 20)); // June 20, 2020
        Employee emp2 = new Employee("Jane Smith", "987-65-4321", new Date(119, 3, 10)); // April 10, 2019
        Employee emp3 = new Employee("Alice Brown", "555-55-5555", new Date(121, 1, 15)); // February 15, 2021

        // Insert employees into the queue
        queue.insert(emp1.getHireDate(), emp1);
        queue.insert(emp2.getHireDate(), emp2);
        queue.insert(emp3.getHireDate(), emp3);

        // Print employees in the order of their hire dates
        for (Position<Entry<Date, Employee>> walk : queue.list.positions()) {
            Entry<Date, Employee> entry = walk.getElement();
            System.out.println("(" + entry.getKey() + ", " + entry.getValue() + ")");
        }

        // Get the employee with the earliest hire date
        Entry<Date, Employee> earliest = queue.min();
        if (earliest != null) {
            System.out.println("Employee with the earliest hire date: " + earliest.getValue());
        }
    }
}

