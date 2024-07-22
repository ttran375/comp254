class ArrayMax {
  public static double arrayMax(double[] data) {
    int n = data.length; // 1 assignment, 1 array length access
    double currentMax = data[0]; // 1 assignment, 1 array access
    for (int j = 1; j < n; j++) { // 1 assignment, (n-1) comparisons, (n-1) increments
      if (data[j] > currentMax) // (n-1) array accesses, (n-1) comparisons
        currentMax = data[j]; // at most (n-1) assignments
    }
    return currentMax; // 1 return
  }
}
