/**
 * Demonstration of two recursive approaches to computing the sum of an array of
 * integers.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class ArraySum {

  /** Returns the sum of the first n integers of the given array. */
  public static int linearSum(int[] data, int n) {
    if (n == 0)
      return 0;
    else
      return linearSum(data, n - 1) + data[n - 1];
  }

  /** Returns the sum of subarray data[low] through data[high] inclusive. */
  public static int binarySum(int[] data, int low, int high) {
    if (low > high) // zero elements in subarray
      return 0;
    else if (low == high) // one element in subarray
      return data[low];
    else {
      int mid = (low + high) / 2;
      return binarySum(data, low, mid) + binarySum(data, mid + 1, high);
    }
  }

  /** Returns the maximum value in the array. */
  public static int findMax(int[] data, int n) {
    if (n == 1) // Base case: only one element
      return data[0];
    else
      return Math.max(data[n - 1], findMax(data, n - 1));
  }

  public static void main(String[] args) {

    int[] data = { 3, 4, 8, 6 ,2 };
    int max = findMax(data, data.length);
    System.out.println("The maximum value is: " + max);

    // for (int limit = 1; limit < 100; limit++) {
    // int[] data = new int[limit];
    // for (int k = 0; k < limit; k++)
    // data[k] = k + 1;
    // int answer = limit * (limit + 1) / 2;

    // int linear = linearSum(data, limit);
    // if (linear != answer)
    // System.out.println("Problem with linear sum for n=" + limit);

    // int binary = binarySum(data, 0, limit - 1);
    // if (binary != answer)
    // System.out.println("Problem with binary sum for n=" + limit);
    // }
  }
}
