# Iterative vs Recursive

Should we use iterative or recursive approach:

```java
public class BinarySearchExample {
    public static boolean binarySearch(int[] data, int target, int low, int high) {
        if (low > high) // interval empty; no match
            return false;
        else {
            int mid = (low + high) / 2;
            if (target == data[mid]) // found a match
                return true;
            else if (target < data[mid])
                return binarySearch(data, target, low, mid - 1); // recur left of the middle
            else
                return binarySearch(data, target, mid + 1, high); // recur right of the middle
        }
    }

    public static void main(String[] args) {
        int[] data = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25 };
        int target = 15;

        boolean found = binarySearch(data, target, 0, data.length - 1);
        if (found) {
            System.out.println("Target " + target + " found in the array.");
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }
    }
}
```
